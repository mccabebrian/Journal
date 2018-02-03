package com.brianmccabe.journal.model;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public class GoogleRiversResponse {
  private Response response;

  public GoogleRiversResponse(Response response) {
    this.response = response;
  }

  public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }
}
