package com.kat2n.practice_android.lesson2.lab3.challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

  public static final String EXTRA_ITEM = "com.kat2n.practice_android.lesson2.lab3.challenge.extra.ITEM";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
  }

  public void touchItemButton(View view) {
    String item = "";
    switch (view.getId()) {
      case R.id.riceButton:     item = "Rice";      break;
      case R.id.potatoesButton: item = "Potatoes";  break;
      case R.id.carrotsButton:  item = "Carrots";   break;
      case R.id.onionsButton:   item = "Onions";    break;
      case R.id.curryButton:    item = "curry";     break;
    }
    Intent intent = new Intent();
    intent.putExtra(EXTRA_ITEM, item);
    setResult(RESULT_OK, intent);
    finish();
  }
}
