package com.brianmccabe.journal.ui;

import com.brianmccabe.journal.model.Articles;

import java.util.List;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public interface MainActivityView {
  void loadGoogleRivers(List<Articles> googleArticles);
  void loadJournalRivers(List<Articles> journalArticles);
}
