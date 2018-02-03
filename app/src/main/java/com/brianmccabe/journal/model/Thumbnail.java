package com.brianmccabe.journal.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public class Thumbnail {
  @Nullable
  @SerializedName("image")
  @Expose
  private String image;

  public Thumbnail(String image) {
    this.image = image;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
