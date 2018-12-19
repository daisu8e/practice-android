package com.kat2n.practice_android.lesson4.lab5.homework.models;

import java.util.LinkedList;

public class Recipe {

  private String name;
  private String description;
  private String image;
  private String ingredients;
  private String procedure;

  public Recipe(String name, String description, String image, String ingredients, String procedure) {
    this.name = name;
    this.description = description;
    this.image = image;
    this.ingredients = ingredients;
    this.procedure = procedure;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getImage() {
    return image;
  }

  public String getIngredients() {
    return ingredients;
  }

  public String getProcedure() {
    return procedure;
  }
}
