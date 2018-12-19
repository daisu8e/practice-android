package com.kat2n.practice_android.lesson4.lab5.homework.recipe_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kat2n.practice_android.lesson4.lab5.homework.R;
import com.kat2n.practice_android.lesson4.lab5.homework.models.Recipe;

public class ViewHolder extends RecyclerView.ViewHolder {

  private Recipe recipe;
  private TextView recipeName;
  private TextView recipeDescription;

  public ViewHolder(@NonNull View itemView) {
    super(itemView);
    recipeName = itemView.findViewById(R.id.recipe_name);
    recipeDescription = itemView.findViewById(R.id.recipe_description);
    itemView.setOnClickListener(new OnClickListener(this));
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
    render();
  }



  private void render() {
    recipeName.setText(recipe.getName());
    recipeDescription.setText(recipe.getDescription());
  }
}
