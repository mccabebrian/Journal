package com.brianmccabe.journal.ui.presenter;

import com.brianmccabe.journal.ui.MainActivityView;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public interface MainActivityPresenter {
  void makeRequestForGoogleRivers();
  void makeRequestForJournalRivers();
  void init(MainActivityView mainActivityView);
}
