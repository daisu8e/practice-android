package com.kat2n.practice_android.lesson4.lab3.challenge2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Formatter;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void showTimePicker(View view) {
    TimePickerFragment newFragment = new TimePickerFragment();
    newFragment.show(getSupportFragmentManager(),getString(R.string.time_picker));
  }

  public void processTimePickerResult(int hour, int minute) {
    StringBuilder sb = new StringBuilder();
    Formatter formatter = new Formatter(sb, Locale.US);
    String timeMessage = formatter.format("%d:%2d", hour, minute).toString();
    Toast.makeText(this, "Time: " + timeMessage, Toast.LENGTH_SHORT).show();
  }
}
