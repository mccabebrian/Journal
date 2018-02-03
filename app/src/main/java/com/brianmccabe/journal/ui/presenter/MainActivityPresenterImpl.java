package com.brianmccabe.journal.ui.presenter;

import com.brianmccabe.journal.data.river.RiverRestGateway;
import com.brianmccabe.journal.data.river.RiversGatewayCallback;
import com.brianmccabe.journal.model.GoogleRiversResponse;
import com.brianmccabe.journal.model.JournalRiversResponse;
import com.brianmccabe.journal.ui.MainActivityView;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
  private MainActivityView mainActivityView;

  @Override
  public void init(MainActivityView mainActivityView) {
    this.mainActivityView = mainActivityView;
    makeRequestForGoogleRivers();
  }

  @Override
  public void makeRequestForGoogleRivers() {
    RiverRestGateway riverRestGateway = new RiverRestGateway();

    riverRestGateway.loadGoogleRivers(new RiversGatewayCallback.OnGetGoogleRivers() {
      @Override
      public void onSuccess(GoogleRiversResponse googleRiversResponse) {
        if(googleRiversResponse != null) {
          mainActivityView.loadGoogleRivers(googleRiversResponse.getResponse().getArticles());
        }
      }

      @Override
      public void onError() {

      }
    });
  }

  @Override
  public void makeRequestForJournalRivers() {
    RiverRestGateway riverRestGateway = new RiverRestGateway();

    riverRestGateway.loadJournalRivers(new RiversGatewayCallback.OnGetJournalRivers() {
      @Override
      public void onSuccess(JournalRiversResponse journalRiversResponse) {
        if(journalRiversResponse != null) {
          mainActivityView.loadJournalRivers(journalRiversResponse.getResponse().getArticles());
        }
      }

      @Override
      public void onError() {

      }
    });
  }
}
