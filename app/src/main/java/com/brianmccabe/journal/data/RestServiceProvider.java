package com.brianmccabe.journal.data;

import com.brianmccabe.journal.BuildConfig;
import com.brianmccabe.journal.model.Articles;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RestServiceProvider {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Gson gson = new GsonBuilder().registerTypeAdapter(Articles.class, new ImagesDeserializer()).create();
    public static Retrofit.Builder builder =
         new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson));


    private static Retrofit retrofit = builder.build();

    public static <S> S createService(
            Class<S> serviceClass) {
            AuthenticationInterceptor interceptor =
                    new AuthenticationInterceptor();

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);

                builder.client(httpClient.build());
                retrofit = builder.build();
            }

        return retrofit.create(serviceClass);
    }

}
