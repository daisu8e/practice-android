package com.kat2n.practice_android.lesson7.lab1.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private static final String TEXT_STATE = "currentText";

  private TextView textView;
  private ProgressBar progressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = findViewById(R.id.textView);
    progressBar = findViewById(R.id.progressBar);

    if (savedInstanceState != null) {
      textView.setText(savedInstanceState.getString(TEXT_STATE));
    }
  }

  public void startTask(View view) {
    textView.setText(R.string.napping);
    new SimpleAsyncTask(textView, progressBar).execute();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString(TEXT_STATE, textView.getText().toString());
  }
}
