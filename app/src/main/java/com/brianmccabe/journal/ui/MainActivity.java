package com.brianmccabe.journal.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.brianmccabe.journal.R;
import com.brianmccabe.journal.model.Articles;
import com.brianmccabe.journal.ui.presenter.MainActivityPresenter;
import com.brianmccabe.journal.ui.presenter.MainActivityPresenterImpl;

import java.util.List;

public class MainActivity extends Activity implements MainActivityView{
    ListView lListView;
    TextView title;
    int articleIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lListView = (ListView) findViewById(R.id.listView);
        title = (TextView) findViewById(R.id.title) ;

        final MainActivityPresenter mainActivityPresenter = new MainActivityPresenterImpl();
        mainActivityPresenter.init(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(articleIndex ==0) {
                    mainActivityPresenter.makeRequestForGoogleRivers();
                    return;
                }
                mainActivityPresenter.makeRequestForJournalRivers();
            }
        });
    }

    @Override
    public void loadGoogleRivers(List<Articles> googleArticles) {
        title.setText(R.string.google_title);
        lListView.setAdapter(new CustomAdapter(googleArticles, this));
        articleIndex = 1;
    }

    @Override
    public void loadJournalRivers(List<Articles> journalArticles) {
        title.setText(R.string.journal_title);
        lListView.setAdapter(new CustomAdapter(journalArticles, this));
        articleIndex = 0;
    }
}
