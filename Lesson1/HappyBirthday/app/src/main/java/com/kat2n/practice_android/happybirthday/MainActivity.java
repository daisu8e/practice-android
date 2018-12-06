package com.kat2n.practice_android.happybirthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

  private static final String LOG_TAG = MainActivity.class.getSimpleName();

  private static class MainActivityException extends Exception {}

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    try {
      throw new MainActivityException();
    } catch (MainActivityException ex) {
      Log.e(LOG_TAG, "Happy Birthday");
    }

  }
}
