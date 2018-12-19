package com.kat2n.practice_android.lesson4.lab5.homework.recipe_list;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;
import com.kat2n.practice_android.lesson4.lab5.homework.RecipeActivity;

public class OnClickListener implements View.OnClickListener {

  private ViewHolder viewHolder;

  public OnClickListener(ViewHolder viewHolder) {
    this.viewHolder = viewHolder;
  }

  @Override
  public void onClick(View v) {
    Context context = v.getContext();
    Gson gson = new Gson();
    Intent intent = new Intent(context.getApplicationContext(), RecipeActivity.class);
    intent.putExtra(RecipeActivity.EXTRA, gson.toJson(viewHolder.getRecipe()));
    context.startActivity(intent);
  }
}
