package com.kat2n.practice_android.lesson4.lab3.challenge2;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    // Use the current time as the default time in the picker.
    final Calendar c = Calendar.getInstance();
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);

    // Create a new instance of TimePickerDialog and return it.
    return new TimePickerDialog(getActivity(), this, hour, minute, false);
  }

  @Override
  public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    MainActivity activity = (MainActivity) getActivity();
    activity.processTimePickerResult(hourOfDay, minute);
  }
}
