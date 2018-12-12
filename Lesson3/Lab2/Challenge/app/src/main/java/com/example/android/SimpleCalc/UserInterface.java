package com.example.android.SimpleCalc;

import android.content.Context;

public class UserInterface {

  private Context context;

  public UserInterface(Context context) {
    this.context = context;
  }

  public String calcButton() {
    return this.context.getString(R.string.app_name);
  }
}
