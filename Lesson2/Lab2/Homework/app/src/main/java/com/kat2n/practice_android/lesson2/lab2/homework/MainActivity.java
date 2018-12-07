package com.kat2n.practice_android.lesson2.lab2.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private TextView numberField;
  private Button countButton;
  private EditText editText;
  private Integer number = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    numberField = findViewById(R.id.numberField);
    countButton = findViewById(R.id.countButton);
    editText = findViewById(R.id.editText);

    if (savedInstanceState != null) restore(savedInstanceState);

    render();
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    save(outState);
  }

  public void touchCountButton(View view) {
    number++;
    render();
  }

  private void render() {
    numberField.setText(number.toString());
  }

  private void save(Bundle outState) {
    outState.putInt("number", number);
  }

  private void restore(Bundle savedInstanceState) {
    number = savedInstanceState.getInt("number");
  }
}
