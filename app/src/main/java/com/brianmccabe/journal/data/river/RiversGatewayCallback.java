package com.brianmccabe.journal.data.river;

import com.brianmccabe.journal.model.GoogleRiversResponse;
import com.brianmccabe.journal.model.JournalRiversResponse;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public interface RiversGatewayCallback {
  interface OnGetJournalRivers {
    void onSuccess(JournalRiversResponse journalRiversResponse);
    void onError();
  }
  interface OnGetGoogleRivers {
    void onSuccess(GoogleRiversResponse googleRiversResponse);
    void onError();
  }
}
