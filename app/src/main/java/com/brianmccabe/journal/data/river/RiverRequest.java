package com.brianmccabe.journal.data.river;

import com.brianmccabe.journal.data.RestServiceProvider;
import com.brianmccabe.journal.model.GoogleRiversResponse;
import com.brianmccabe.journal.model.JournalRiversResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by brian on 06/05/2017.
 */

public class RiverRequest {
    private static final String HEADER_CONTENT_TYPE = "Content-type: application/json;charset=UTF-8";
    private static final String GET_GOOGLE_RIVERS_ENDPOINT = "sample/tag/google";
    private static final String GET_JOURNAL_RIVERS_ENDPOINT = "sample/thejournal/";

    public interface RiverRestService {
        @Headers({HEADER_CONTENT_TYPE})
        @GET(GET_GOOGLE_RIVERS_ENDPOINT)
        Call<GoogleRiversResponse> getGoogleRiversResponse();

        @Headers({HEADER_CONTENT_TYPE})
        @GET(GET_JOURNAL_RIVERS_ENDPOINT)
        Call<JournalRiversResponse> getJournalRiversResponse();
    }

    private final RiverRestService riverRestService;

    public RiverRequest() {
        riverRestService = RestServiceProvider.createService(RiverRestService.class);
    }

    public void getGoogleRiversResponse(Callback<GoogleRiversResponse> callback) {
        Call<GoogleRiversResponse> call = riverRestService.getGoogleRiversResponse();
        call.enqueue(callback);
    }

    public void getJournalRiversResponse(Callback<JournalRiversResponse> callback) {
        Call<JournalRiversResponse> call = riverRestService.getJournalRiversResponse();
        call.enqueue(callback);
    }
}
