package com.kat2n.practice_android.lesson10.lab1.part_a.task;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
  private WordDao wordDao;
  private LiveData<List<Word>> allWords;

  WordRepository(Application application) {
    WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
    wordDao = db.wordDao();
    allWords = wordDao.getAllWords();
  }

  public LiveData<List<Word>> getAllWords() {
    return allWords;
  }

  public void insert(Word word) {
    new insertAsyncTask(wordDao).execute(word);
  }

  private static class insertAsyncTask extends AsyncTask<Word, Void ,Void> {

    private WordDao asyncTaskDao;

    public insertAsyncTask(WordDao asyncTaskDao) {
      this.asyncTaskDao = asyncTaskDao;
    }

    @Override
    protected Void doInBackground(Word... words) {
      asyncTaskDao.insert(words[0]);
      return null;
    }
  }
}
