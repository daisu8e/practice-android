package com.kat2n.practice_android.lesson4.lab2.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

  private Map<Integer, String> toppings = new HashMap<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void checkTopping(View view) {
    int id = view.getId();
    boolean checked = ((CheckBox) view).isChecked();
    switch (id) {
      case R.id.chocolate_syrup:
        if (checked)  keepTopping(id, getString(R.string.chocolate_syrup));
        else clearTopping(id);
        break;
      case R.id.sprinkles:
        if (checked)  keepTopping(id, getString(R.string.sprinkles));
        else clearTopping(id);
        break;
      case R.id.crushed_nuts:
        if (checked)  keepTopping(id, getString(R.string.crushed_nuts));
        else clearTopping(id);
        break;
      case R.id.cherries:
        if (checked)  keepTopping(id, getString(R.string.cherries));
        else clearTopping(id);
        break;
      case R.id.orio_cookie_crumbles:
        if (checked)  keepTopping(id, getString(R.string.orio_cookie_crumbles));
        else clearTopping(id);
        break;
      default:
        break;
    }
  }

  public void tapShowToastButton(View view) {
    String message = "None";
    if (toppings.size() > 0) message = TextUtils.join(" ", toppings.values());
    displayToast("Toppings: " + message);
  }

  public void displayToast(String message) {
    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
  }

  private void keepTopping(int id, String name) {
    toppings.put(id, name);
    displayToast(name);
  }

  private void clearTopping(int id) {
    toppings.remove(id);
  }
}
