package com.brianmccabe.journal.data;

import com.brianmccabe.journal.model.Articles;
import com.brianmccabe.journal.model.Images;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public class ImagesDeserializer implements JsonDeserializer<Articles> {

  @Override
  public Articles deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    JsonObject articlesElement = json.getAsJsonObject();
    JsonElement imagesElement = json.getAsJsonObject().get("images");
    String title = articlesElement.get("title").getAsString();
    String type = articlesElement.get("type").getAsString();
    if (imagesElement.isJsonArray()) {
      return new Articles(title, type, (Images[]) context.deserialize(imagesElement.getAsJsonArray(), Images[].class));
    } else if (imagesElement.isJsonObject()) {
      return new Articles(title, type, (Images) context.deserialize(imagesElement.getAsJsonObject(), Images.class));
    } else {
      throw new JsonParseException("Unsupported type of Images element");
    }
  }

}
