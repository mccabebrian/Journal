package com.brianmccabe.journal.model;

import com.google.gson.annotations.Expose;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public class JournalRiversResponse {
  @Expose
  private Response response;

  public JournalRiversResponse(Response response) {
    this.response = response;
  }

  public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }
}
