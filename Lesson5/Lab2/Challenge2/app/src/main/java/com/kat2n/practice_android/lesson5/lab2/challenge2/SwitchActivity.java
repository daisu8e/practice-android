package com.kat2n.practice_android.lesson5.lab2.challenge2;

import android.os.Bundle;

public class SwitchActivity extends MainActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_switch);

    init();
  }

  @Override
  protected Class<?> getSwitchIntentClass() {
    return MainActivity.class;
  }
}


