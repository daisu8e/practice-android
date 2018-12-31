package com.kat2n.practice_android.lesson5.lab2.challenge2;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

  protected ImageButton redButton;
  protected ImageButton blueButton;
  protected ImageButton greenButton;
  protected ImageButton yellowButton;
  protected ObjectAnimator rotationAnimator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    init();
  }

  public void onClickRedButton(View view) {
    Intent intent = new Intent(this, this.getClass());
    intent.putExtra("transition type", "explode");
    getWindow().setExitTransition(new Explode());
    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
  }

  public void onClickBlueButton(View view) {
    Intent intent = new Intent(this, this.getClass());
    intent.putExtra("transition type", "fade");
    getWindow().setExitTransition(new Fade());
    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
  }

  public void onClickGreenButton(View view) {
    Intent intent = new Intent(this, this.getSwitchIntentClass());
    Pair<View, String> switchOrigin = Pair.create((View)greenButton, "switchOrigin");
    Pair<View, String> switchTarget = Pair.create((View)blueButton, "switchTarget");
    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, switchOrigin, switchTarget);
    startActivity(intent, options.toBundle());
  }

  public void onClickYellowButton(View view) {
    rotationAnimator.start();
  }



  protected void init() {
    redButton = findViewById(R.id.redButton);
    blueButton = findViewById(R.id.blueButton);
    greenButton = findViewById(R.id.greenButton);
    yellowButton = findViewById(R.id.yellowButton);

    rotationAnimator = ObjectAnimator.ofFloat(yellowButton, View.ROTATION, 0f, 360f);
    rotationAnimator.setDuration(1000);
    rotationAnimator.setRepeatMode(ValueAnimator.REVERSE);
    rotationAnimator.setRepeatCount(1);

    if (getIntent().hasExtra("transition type")) {
      switch (getIntent().getStringExtra("transition type")) {
        case "explode":
          getWindow().setEnterTransition(new Explode());
          break;
        case "fade":
          getWindow().setEnterTransition(new Fade());
          break;
      }
    }
  }

  protected Class<?> getSwitchIntentClass() {
    return SwitchActivity.class;
  }
}

