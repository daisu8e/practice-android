package com.kat2n.practice_android.lesson10.lab1.part_a.task;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

  private LayoutInflater layoutInflater;
  private List<Word> words;

  public WordListAdapter(Context context) {
    layoutInflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = layoutInflater.inflate(R.layout.recyclerview_item, viewGroup, )
    return new WordViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int i) {
    if (words != null) {
      Word current = words.get(i);
      wordViewHolder.wordItemView.setText(current.getWord());
    } else {
      wordViewHolder.wordItemView.setText("No Word");
    }

  }

  @Override
  public int getItemCount() {
    if (words != null) {
      return words.size();
    }
    return 0;
  }

  public void setWords(List<Word> words) {
    this.words = words;
  }

  class WordViewHolder extends RecyclerView.ViewHolder {
    private TextView wordItemView;
    public WordViewHolder(@NonNull View itemView) {
      super(itemView);
      wordItemView = itemView.findViewById(R.id.);
    }
  }
}
