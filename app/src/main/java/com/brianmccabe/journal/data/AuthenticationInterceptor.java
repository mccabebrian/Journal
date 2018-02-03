package com.brianmccabe.journal.data;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {


  public AuthenticationInterceptor() {
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request original = chain.request();

    Request.Builder builder = original.newBuilder()
      .header("Authorization", "Basic c2FtcGxlOmVmZXJ3NXdyMzM1wqM2NQ==");


    Request request = builder.build();
    return chain.proceed(request);
  }
}