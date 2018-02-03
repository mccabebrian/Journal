package com.brianmccabe.journal.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brianmccabe.journal.R;
import com.brianmccabe.journal.model.Articles;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
  private List<Articles> articles;
  private Context context;

  private static LayoutInflater inflater=null;

  public CustomAdapter(List<Articles> articles, Context context) {
    this.articles = articles;
    this.context = context;
    inflater = ( LayoutInflater )context.
      getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }
  @Override
  public int getCount() {
    return articles.size();
  }

  @Override
  public Object getItem(int position) {
    return position;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  public class Holder
  {
    TextView riverTitle;
    TextView riverType;
    ImageView riverImage;
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    Holder holder=new Holder();
    View rowView;
    rowView = inflater.inflate(R.layout.list_item, null);

    holder.riverTitle = (TextView) rowView.findViewById(R.id.riverTitle);
    holder.riverType = (TextView) rowView.findViewById(R.id.riverType);
    holder.riverImage = (ImageView) rowView.findViewById(R.id.riverImage);

    Articles article = articles.get(position);

    holder.riverTitle.setText(article.getTitle());
    holder.riverType.setText(article.getType());

    if(article.getImages() != null) {
      Picasso.with(context).load(article.getImages().getThumbnail().getImage()).into(holder.riverImage);
    }

    rowView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });
    return rowView;
  }

}