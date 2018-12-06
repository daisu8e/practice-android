package com.kat2n.practice_android.lesson2.lab1.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  public static final String EXTRA_MESSAGE = "com.kat2n.practice_android.lesson2.lab1.homework.extra.MESSAGE";

  private Integer mCount = 0;
  private TextView mShowCount;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mShowCount = (TextView) findViewById(R.id.show_count);
  }

  public void launchSecondActivity(View view) {
    Intent intent = new Intent(this, SecondActivity.class);
    String message = mCount.toString();
    intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);
  }

  public void countUp(View view) {
    ++mCount;
    if (mShowCount != null) mShowCount.setText(Integer.toString(mCount));
  }

}
