package com.brianmccabe.journal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public class Response {
  @SerializedName("articles")
  @Expose
  private List<Articles> articles;

  public Response() {

  }

  public Response(List<Articles> articles) {
    this.articles = articles;
  }

  public List<Articles> getArticles() {
    return articles;
  }

  public void setArticles(List<Articles> articles) {
    this.articles = articles;
  }
}
