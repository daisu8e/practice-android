package com.kat2n.practice_android.lesson10.lab1.part_a.task;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {
  @Insert
  void insert(Word word);

  @Query("DELETE FROM word_table")
  void deleteAll();

  @Query("SELECT * FROM word_table ORDER BY word ASC")
  LiveData<List<Word>> getAllWords();
}
