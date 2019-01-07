package com.kat2n.practice_android.lesson5.lab2.transitiontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SecondActivity extends AppCompatActivity {

  private ImageView imageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    imageView = findViewById(R.id.imageView);

    Intent intent = getIntent();
    int imageId = getResources().getIdentifier(intent.getStringExtra("image"), "drawable", getPackageName());
    Glide.with(this).load(imageId).into(imageView);

  }
}
