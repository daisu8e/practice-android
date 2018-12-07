package com.github.kat2n.practice_android_assignment1;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Quiz {

  private static final Map<String, Integer> COLORS = new HashMap<>();
  static {
    COLORS.put("Aka-iro", Color.rgb(255, 0, 0));
    COLORS.put("Daidai-iro", Color.rgb(255, 128, 0));
    COLORS.put("Ki-iro", Color.rgb(255, 255, 0));
    COLORS.put("Kimidori-iro", Color.rgb(128, 255, 0));
    COLORS.put("Midori-iro", Color.rgb(0, 255, 0));
    COLORS.put("Mizu-iro", Color.rgb(0, 255, 255));
    COLORS.put("Ao-iro", Color.rgb(0, 0, 255));
    COLORS.put("Pink-iro", Color.rgb(255, 0, 255));
    COLORS.put("Murasaki-iro", Color.rgb(128, 0, 255));
    COLORS.put("Nezumi-iro", Color.rgb(128, 128, 128));
    COLORS.put("Kuro-iro", Color.rgb(0, 0, 0));
  }

  private String question = "Select the right color!";
  private String leftColor;
  private String rightColor;
  private String color;
  private Integer score;

  public Quiz() {
    initLeftAndRightColors();
    initColor();
    this.score = 0;
  }

  public String getQuestion() {
    return question;
  }

  public Integer getLeftColorCode() {
    return COLORS.get(leftColor);
  }

  public Integer getRightColorCode() {
    return COLORS.get(rightColor);
  }

  public String getColor() {
    return color;
  }

  public Integer getScore() {
    return score;
  }

  public void mark(String which) {
    if (which.equals("left")) markLeftColor();
    else if (which.equals("right")) markRightColor();
  }

  public void retry() {
    initLeftAndRightColors();
    initColor();
  }

  private void markLeftColor() {
    if (leftColor.equals(color)) score++;
    else score--;
  }

  private void markRightColor() {
    if (rightColor.equals(color)) score++;
    else score--;
  }
  
  private void initLeftAndRightColors() {
    leftColor = pickColor();
    rightColor = pickColor();
    while (leftColor.equals(rightColor)) rightColor = pickColor();
  }

  private void initColor() {
    int flag = (int)(Math.random() * 2);
    if (flag == 0) color = leftColor;
    else if (flag == 1) color = rightColor;
  }

  private String pickColor() {
    List<String> keys = new ArrayList<>(COLORS.keySet());
    int index = (int)(Math.random() * keys.size());
    return keys.get(index);
  }
}
