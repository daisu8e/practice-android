package com.kat2n.practice_android.lesson4.lab5.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kat2n.practice_android.lesson4.lab5.homework.models.Recipe;
import com.squareup.picasso.Picasso;

public class RecipeActivity extends AppCompatActivity {

  public static final String EXTRA = "com.kat2n.practice_android.lesson4.lab5.homework.recipe_activity.extra";

  private Recipe recipe;
  private TextView recipeName;
  private TextView recipeDescription;
  private ImageView recipeImage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recipe);

    recipeName = findViewById(R.id.recipe_name);
    recipeDescription = findViewById(R.id.recipe_description);
    recipeImage = findViewById(R.id.recipe_image);

    Gson gson = new Gson();
    Intent intent = getIntent();
    recipe = gson.fromJson(intent.getStringExtra(EXTRA), Recipe.class);

    render();
  }



  private void render() {
    recipeName.setText(recipe.getName());
    recipeDescription.setText(recipe.getDescription());

    int imageId = getResources().getIdentifier(recipe.getImage(), "drawable", getPackageName());
    recipeImage.setImageResource(imageId);
//    Picasso.get().load(recipe.getImage()).into(recipeImage);

  }
}
