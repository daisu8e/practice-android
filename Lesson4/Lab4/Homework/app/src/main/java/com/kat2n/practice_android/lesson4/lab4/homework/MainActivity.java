package com.kat2n.practice_android.lesson4.lab4.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onImageClicked(View view) {
    switch (view.getId()) {
      case R.id.donut:
        goTo(DonutActivity.class);
        break;
      case R.id.icecream:
        goTo(IcecreamActivity.class);
        break;
      case R.id.froyo:
        goTo(FroyoActivity.class);
        break;
    }
  }

  private void goTo(Class<?> cls) {
    Intent intent = new Intent(MainActivity.this, cls);
    startActivity(intent);
  }
}
