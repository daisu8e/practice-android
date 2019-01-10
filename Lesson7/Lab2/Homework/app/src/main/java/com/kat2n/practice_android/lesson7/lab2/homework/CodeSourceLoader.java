package com.kat2n.practice_android.lesson7.lab2.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CodeSourceLoader extends AsyncTaskLoader<String> {

  private String url;

  public CodeSourceLoader(@NonNull Context context, String url) {
    super(context);
    this.url = url;
  }

  @Override
  protected void onStartLoading() {
    super.onStartLoading();
    forceLoad();
  }

  @Nullable
  @Override
  public String loadInBackground() {
    HttpURLConnection http = null;
    BufferedReader reader = null;
    StringBuilder builder = new StringBuilder();
    String json = null;
    String line;

    try {
      http = (HttpURLConnection) new URL(url).openConnection();
      http.setRequestMethod("GET");
      http.connect();
      reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
      while ((line = reader.readLine()) != null) {
        builder.append(line);
        builder.append("\n");
      }
      if (builder.length() == 0) return null;
      json = builder.toString();

    } catch (IOException e) {
      e.printStackTrace();

    } finally {
      if (http != null) http.disconnect();
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    Log.d("xxx", json);
    return json;
  }
}
