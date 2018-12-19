package com.kat2n.practice_android.lesson4.lab5.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kat2n.practice_android.lesson4.lab5.homework.models.Recipe;
import com.kat2n.practice_android.lesson4.lab5.homework.recipe_list.Adapter;
import com.kat2n.practice_android.lesson4.lab5.homework.recipe_list.ItemDecoration;

import java.util.LinkedList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

  private LinkedList<Recipe> recipes;
  private RecyclerView recyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recipes = getRecipes();
    recyclerView = findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(new Adapter(this, recipes));
    recyclerView.addItemDecoration(new ItemDecoration(this));
  }



  private LinkedList<Recipe> getRecipes() {
    Gson gson = new Gson();
    String json = "";
    int recipesId = getResources().getIdentifier("recipes", "raw", getPackageName());
    Scanner scanner = new Scanner(getResources().openRawResource(recipesId));
    while (scanner.hasNext()) json += scanner.nextLine();
    scanner.close();
    return gson.fromJson(json, new TypeToken<LinkedList<Recipe>>(){}.getType());
  }
}
