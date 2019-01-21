package com.kat2n.practice_android.lesson10.lab1.part_a.task;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
  public abstract WordDao wordDao();
  private static WordRoomDatabase INSTANCE;

  static WordRoomDatabase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (WordRoomDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordRoomDatabase.class, "word_database")
            .fallbackToDestructiveMigration()
            .build();
        }
      }
    }
    return INSTANCE;
  }

  private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
    @Override
    public void onOpen(@NonNull SupportSQLiteDatabase db) {
      super.onOpen(db);
      new PopulateDbAsync(INSTANCE).execute();
    }
  };

  private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
    private WordDao wordDao;
    String[] words = {};
    PopulateDbAsync(WordRoomDatabase db) {
      wordDao = db.wordDao();
    }

    @Override
    protected Void doInBackground(Void... voids) {
      wordDao.deleteAll();
      for (int i = 0; i < words.length; i++) {
        Word word = new Word(words[i]);
        wordDao.insert(word);
      }
      return null;
    }
  }
}
