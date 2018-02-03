package com.brianmccabe.journal.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public class Articles {
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("type")
  @Expose
  private String type;
  @Nullable
  @SerializedName("images")
  @Expose
  private Images images;
  private Images[] imagesList;


  public Articles(String title, String type, Images images) {
    this.title = title;
    this.type = type;
    this.images = images;
  }

  public Articles(String title, String type, Images[] imagesList) {
    this.title = title;
    this.type = type;
    this.imagesList = imagesList;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Images getImages() {
    return images;
  }

  public void setImages(Images images) {
    this.images = images;
  }
}
