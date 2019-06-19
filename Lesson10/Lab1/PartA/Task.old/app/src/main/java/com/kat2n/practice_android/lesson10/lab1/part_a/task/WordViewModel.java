package com.kat2n.practice_android.lesson10.lab1.part_a.task;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * role is to privide data to the UI and survive configuration changes.
 * acts as a communication center between the Repository and the UI.
 */
public class WordViewModel extends AndroidViewModel {
  private WordRepository wordRepository;
  private LiveData<List<Word>> allWords;

  public WordViewModel(@NonNull Application application) {
    super(application);
    this.wordRepository = new WordRepository(application);
    this.allWords = wordRepository.getAllWords();
  }

  public LiveData<List<Word>> getAllWords() {
    return allWords;
  }

  public void insert(Word word) {
    wordRepository.insert(word);
  }
}
