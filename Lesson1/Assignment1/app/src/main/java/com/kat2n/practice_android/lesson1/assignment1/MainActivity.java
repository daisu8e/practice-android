package com.kat2n.practice_android.lesson1.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private Quiz quiz;
  private TextView question;
  private Button leftButton;
  private Button rightButton;
  private TextView color;
  private TextView score;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    quiz = new Quiz();
    question = findViewById(R.id.question);
    leftButton = findViewById(R.id.leftButton);
    rightButton = findViewById(R.id.rightButton);
    color = findViewById(R.id.color);
    score = findViewById(R.id.score);
    render();
  }

  public void touchLeftButton(View view) {
    quiz.mark("left");
    quiz.retry();
    render();
  }

  public void touchRightButton(View view) {
    quiz.mark("right");
    quiz.retry();
    render();
  }

  private void render() {
    question.setText(quiz.getQuestion());
    leftButton.setBackgroundColor(quiz.getLeftColorCode());
    rightButton.setBackgroundColor(quiz.getRightColorCode());
    color.setText(quiz.getColor());
    score.setText(quiz.getScore().toString());
  }
}
