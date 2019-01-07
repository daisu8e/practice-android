package com.kat2n.practice_android.lesson5.lab2.transitiontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private static final ArrayList<String> IMAGES = new ArrayList<>();
  static {
    IMAGES.add("img_badminton");
    IMAGES.add("img_baseball");
    IMAGES.add("img_basketball");
    IMAGES.add("img_bowling");
    IMAGES.add("img_cycling");
    IMAGES.add("img_golf");
    IMAGES.add("img_running");
    IMAGES.add("img_soccer");
    IMAGES.add("img_swimming");
    IMAGES.add("img_tabletennis");
    IMAGES.add("img_tennis");
  }

  private RecyclerView recyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(new ListAdapter(IMAGES));
  }
}
