package com.example.android.materialme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

  TextView titleDetail;
  ImageView sportsImageDetail;
  TextView subTitleDetail;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    titleDetail = findViewById(R.id.titleDetail);
    sportsImageDetail = findViewById(R.id.sportsImageDetail);
    subTitleDetail = findViewById(R.id.subTitleDetail);

    titleDetail.setText(getIntent().getStringExtra("title"));
    Glide.with(this).load(getIntent().getIntExtra("image_resource",0)).into(sportsImageDetail);
    subTitleDetail.setText(getIntent().getStringExtra("detail"));
  }
}
