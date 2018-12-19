package com.kat2n.practice_android.lesson4.lab5.task;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

  private LinkedList<String> mWordList;
  private RecyclerView mRecyclerView;
  private WordListAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        int wordListSize = mWordList.size();
        mWordList.addLast("+ Word " + wordListSize);
        mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
        mRecyclerView.smoothScrollToPosition(wordListSize);
      }
    });

    initWordList();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.reset:
        initWordList();
        return true;
      case R.id.action_settings:
        return true;
    }
    return super.onOptionsItemSelected(item);
  }



  private void initWordList() {
    mWordList = new LinkedList<>();
    for (int i = 0; i < 20; i++) {
      mWordList.addLast("Word " + i);
    }
    mRecyclerView = findViewById(R.id.recyclerview);
    mAdapter = new WordListAdapter(this, mWordList);
    mRecyclerView.setAdapter(mAdapter);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
  }
}
