package com.kat2n.practice_android.lesson4.lab5.homework.recipe_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kat2n.practice_android.lesson4.lab5.homework.R;
import com.kat2n.practice_android.lesson4.lab5.homework.models.Recipe;

import java.util.LinkedList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

  private LayoutInflater layoutInflater;
  private LinkedList<Recipe> recipes;

  public Adapter(Context context, LinkedList<Recipe> recipes) {
    this.layoutInflater = LayoutInflater.from(context);
    this.recipes = recipes;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = layoutInflater.inflate(R.layout.recipe_list_item, viewGroup, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    viewHolder.setRecipe(recipes.get(i));
  }

  @Override
  public int getItemCount() {
    return recipes.size();
  }
}
