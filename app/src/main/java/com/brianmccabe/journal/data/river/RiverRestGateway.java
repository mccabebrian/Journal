package com.brianmccabe.journal.data.river;

import com.brianmccabe.journal.model.GoogleRiversResponse;
import com.brianmccabe.journal.model.JournalRiversResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by brian on 06/05/2017.
 */

public class RiverRestGateway implements RiverGateway{

    private final RiverRequest riverRequest;

    public RiverRestGateway() {
        riverRequest = new RiverRequest();
    }

    @Override
    public void loadJournalRivers(final RiversGatewayCallback.OnGetJournalRivers journalRivers) {
        riverRequest.getJournalRiversResponse(new Callback<JournalRiversResponse>() {
            @Override
            public void onResponse(Call<JournalRiversResponse> call, Response<JournalRiversResponse> response) {
                journalRivers.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<JournalRiversResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadGoogleRivers(final RiversGatewayCallback.OnGetGoogleRivers googleRivers) {

        riverRequest.getGoogleRiversResponse(new Callback<GoogleRiversResponse>() {
            @Override
            public void onResponse(Call<GoogleRiversResponse> call, Response<GoogleRiversResponse> response) {
                googleRivers.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<GoogleRiversResponse> call, Throwable t) {
            }
        });
    }
}
