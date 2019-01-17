package com.kat2n.practice_android.lesson9.remembermyage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  public static final String AGE_KEY = "AGE_KEY";

  private int age;
  private TextView ageText;
  private SharedPreferences sharedPreferences;
  private final String sharedPreferenceFile = BuildConfig.APPLICATION_ID;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ageText = findViewById(R.id.ageText);
    sharedPreferences = getSharedPreferences(sharedPreferenceFile, MODE_PRIVATE);
    age = sharedPreferences.getInt(AGE_KEY, 0);
    ageText.setText(Integer.toString(age));
  }

  @Override
  protected void onPause() {
    super.onPause();
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt(AGE_KEY, age);
    editor.apply();
  }

  public void makeMeYounger(View view) {
    age = Integer.parseInt(ageText.getText().toString());
    if (age > 0) {
      age--;
    }
    ageText.setText(Integer.toString(age));
  }

  public void makeMeOlder(View view) {
    age = Integer.parseInt(ageText.getText().toString());
    age++;
    ageText.setText(Integer.toString(age));
  }
}
