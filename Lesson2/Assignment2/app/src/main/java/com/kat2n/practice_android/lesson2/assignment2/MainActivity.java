package com.kat2n.practice_android.lesson2.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

  private Spinner spinner;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    spinner = findViewById(R.id.moviesSpinner);

    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

      }
      @Override
      public void onNothingSelected() {

      }
    });

    ImageView imageView = new ImageView(this);
    imageView.setImageResource(R.drawable.catch_me_if_you_can);

    int id = getResources().getIdentifier("the_godfatehr", "raw", getPackageName());
    String result = "";
    Scanner in = new Scanner(getResources().openRawResource(R.raw.the_godfather));
    while (in.hasNext()) {
      result += in.nextLine();
    }
    in.close();
  }
}
