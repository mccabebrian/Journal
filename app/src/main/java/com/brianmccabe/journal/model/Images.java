package com.brianmccabe.journal.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public class Images {

  @Nullable
  @SerializedName("thumbnail")
  @Expose
  private Thumbnail thumbnail;

  public Images(Thumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }

  public Thumbnail getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(Thumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }
}
