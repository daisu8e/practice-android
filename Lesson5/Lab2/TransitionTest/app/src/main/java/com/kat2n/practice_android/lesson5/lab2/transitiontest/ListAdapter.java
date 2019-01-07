package com.kat2n.practice_android.lesson5.lab2.transitiontest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private ArrayList<String> images;

  public ListAdapter(ArrayList<String> images) {
    this.images = images;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    return new ListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false));
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    ((ListViewHolder)viewHolder).setImage(images.get(i));
  }

  @Override
  public int getItemCount() {
    return images.size();
  }
}
