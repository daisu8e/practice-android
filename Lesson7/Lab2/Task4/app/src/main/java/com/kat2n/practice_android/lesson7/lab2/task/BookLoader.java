package com.kat2n.practice_android.lesson7.lab2.task;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class BookLoader extends AsyncTaskLoader<String> {

  private String mQueryString;

  public BookLoader(Context context, String queryString) {
    super(context);
    mQueryString = queryString;
  }

  @Override
  protected void onStartLoading() {
    super.onStartLoading();
    forceLoad();
  }

  @Nullable
  @Override
  public String loadInBackground() {
    return NetworkUtils.getBookInfo(mQueryString);
  }
}
