package com.kat2n.practice_android.lesson7.lab3.task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

  private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

  @Override
  public void onReceive(Context context, Intent intent) {
    String intentAction = intent.getAction();
    if (intentAction != null) {
      String toastMessage = "unknown intent action";
      switch (intentAction){
        case Intent.ACTION_POWER_CONNECTED:
          toastMessage = "Power connected!";
          break;
        case Intent.ACTION_POWER_DISCONNECTED:
          toastMessage = "Power disconnected!";
          break;
        case ACTION_CUSTOM_BROADCAST:
          int randomNumber = Integer.parseInt(intent.getStringExtra("RANDOM_NUMBER"));
          toastMessage = "Custom Broadcast Received\nSquare of the Random number: " + (randomNumber * randomNumber);
          break;
        case Intent.ACTION_HEADSET_PLUG:
          toastMessage = "Headset plug changed";
          break;
      }
      Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
    }
  }
}
