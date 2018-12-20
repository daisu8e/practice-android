package com.kat2n.practice_android.lesson5.lab1.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

  private static final int BATTERY_MAX = 6;
  private static final int BATTERY_MIN = 0;

  int batteryLevel;
  private ImageView batteryImage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    batteryLevel = 3;
    batteryImage = findViewById(R.id.battery_image);
    render();
  }

  public void onPlusButtonClicked(View view) {
    if (batteryLevel < BATTERY_MAX) {
      batteryLevel++;
      render();
    }
  }

  public void onMinusButtonClicked(View view) {
    if (batteryLevel > BATTERY_MIN) {
      batteryLevel--;
      render();
    }
  }



  private void render() {
    batteryImage.setImageLevel(batteryLevel);
  }
}
