package com.kat2n.practice_android.lesson7.lab2.homework;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

  private Spinner urlOptions;
  private EditText urlField;
  private TextView codeSource;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    urlOptions = findViewById(R.id.urlOptions);
    urlField = findViewById(R.id.urlField);
    codeSource = findViewById(R.id.codeSource);

    if(getSupportLoaderManager().getLoader(0) != null){
      getSupportLoaderManager().initLoader(0, null, this);
    }
  }

  public void onButtonClick(View view) {
    String url = urlOptions.getSelectedItem().toString() + urlField.getText().toString();
    hideKeyboard(view);
    NetworkInfo networkInfo = null;
    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    if (connectivityManager != null) networkInfo = connectivityManager.getActiveNetworkInfo();
    if (networkInfo != null && networkInfo.isConnected() && url.length() != 0) {
      Bundle bundle = new Bundle();
      bundle.putString("url", url);
      getSupportLoaderManager().restartLoader(0, bundle, this);
      codeSource.setText(R.string.loading);
    } else {
      if (url.length() == 0) {
        codeSource.setText(R.string.no_search_term);
      } else {
        codeSource.setText(R.string.no_network);
      }
    }
  }

  @NonNull
  @Override
  public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
    String url = "";
    if (bundle != null) url = bundle.getString("url");
    return new CodeSourceLoader(this, url);
  }

  @Override
  public void onLoadFinished(@NonNull Loader<String> loader, String s) {
    if (s != null) {
      codeSource.setText(s);
    } else {
      codeSource.setText(R.string.no_results);
    }
  }

  @Override
  public void onLoaderReset(@NonNull Loader<String> loader) {

  }

  private void hideKeyboard(View view) {
    InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    if (manager != null ) manager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
  }
}
