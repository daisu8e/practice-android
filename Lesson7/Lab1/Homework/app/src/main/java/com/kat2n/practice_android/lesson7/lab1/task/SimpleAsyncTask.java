package com.kat2n.practice_android.lesson7.lab1.task;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {

  private WeakReference<TextView> textView;
  private WeakReference<ProgressBar> progressBar;

  SimpleAsyncTask(TextView textView, ProgressBar progressBar) {
    this.textView = new WeakReference<>(textView);
    this.progressBar = new WeakReference<>(progressBar);
  }

  @Override
  protected String doInBackground(Void... voids) {
    Random r = new Random();
    int s = r.nextInt(11);
    progressBar.get().setMax(s);

    for (int i = 0; i < s ; i++) {
      publishProgress(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    publishProgress(s);
    return "Awake at last after sleeping for " + s + " seconds!";
  }

  @Override
  protected void onProgressUpdate(Integer... values) {
    super.onProgressUpdate(values);
    progressBar.get().setProgress(values[0], true);
  }

  @Override
  protected void onPostExecute(String result) {
    textView.get().setText(result);
  }
}
