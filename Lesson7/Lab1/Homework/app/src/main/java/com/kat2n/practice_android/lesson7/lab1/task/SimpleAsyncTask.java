package com.kat2n.practice_android.lesson7.lab1.task;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, String, String> {

  private WeakReference<TextView> mTextView;

  SimpleAsyncTask(TextView tv) {
    mTextView = new WeakReference<>(tv);
  }

  @Override
  protected String doInBackground(Void... voids) {
    Random r = new Random();
    int s = r.nextInt(11);

    for (int i = 0; i <= s ; i++) {
      publishProgress("Napping for " + i + " seconds");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    return "Awake at last after sleeping for " + s + " seconds!";
  }

  @Override
  protected void onProgressUpdate(String... values) {
    super.onProgressUpdate(values);
    mTextView.get().setText(values[0]);
  }

  @Override
  protected void onPostExecute(String result) {
    mTextView.get().setText(result);
  }
}
