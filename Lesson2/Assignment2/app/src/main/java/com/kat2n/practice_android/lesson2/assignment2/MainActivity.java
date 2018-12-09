package com.kat2n.practice_android.lesson2.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

  private static final List<String> MOVIE_ID_LIST = new ArrayList<>();
  static {
    MOVIE_ID_LIST.add("catch_me_if_you_can");
    MOVIE_ID_LIST.add("fight_club");
    MOVIE_ID_LIST.add("forrest_gump");
    MOVIE_ID_LIST.add("good_will_hunting");
    MOVIE_ID_LIST.add("pulp_fiction");
    MOVIE_ID_LIST.add("the_godfather");
    MOVIE_ID_LIST.add("the_hangover");
    MOVIE_ID_LIST.add("the_shawshank_redemption");
    MOVIE_ID_LIST.add("titanic");
  }

  private Spinner spinner;
  private ImageView imageView;
  private TextView textView;
  private String movieId;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    spinner = findViewById(R.id.moviesSpinner);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        movieId = MOVIE_ID_LIST.get(position);
        render();
      }
      @Override
      public void onNothingSelected(AdapterView<?> parent) {
      }
    });
    imageView = findViewById(R.id.imageView);
    textView = findViewById(R.id.textView);
  }

  private void render() {
    int imageId = getResources().getIdentifier(movieId, "drawable", getPackageName());
    imageView.setImageResource(imageId);

    int textId = getResources().getIdentifier(movieId, "raw", getPackageName());
    String text = "";
    Scanner scanner = new Scanner(getResources().openRawResource(textId));
    while (scanner.hasNext()) text += scanner.nextLine();
    scanner.close();
    textView.setText(text);
  }
}
