package com.kat2n.practice_android.lesson8.lab2.task;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

  private static final int NOTIFICATION_ID = 0;
  private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

  private NotificationManager mNotificationManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    Intent notifyIntent = new Intent(this, AlarmReceiver.class);
    final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

    ToggleButton alarmToggle = findViewById(R.id.alarmToggle);
    alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        String toastMessage;
        if(isChecked){
          Calendar calendar = Calendar.getInstance();
          calendar.setTimeInMillis(System.currentTimeMillis());
          calendar.set(Calendar.HOUR_OF_DAY, 11);
          calendar.set(Calendar.MINUTE, 11);
          long triggerTime = calendar.getTimeInMillis();
          long repeatInterval = AlarmManager.INTERVAL_DAY;

          if (alarmManager != null) {
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, triggerTime, repeatInterval, notifyPendingIntent);
          }
          toastMessage = "Alarm On!";
        } else {
          if (alarmManager != null) {
            alarmManager.cancel(notifyPendingIntent);
          }
          mNotificationManager.cancelAll();
          toastMessage = "Alarm Off!";
        }
        Toast.makeText(MainActivity.this, toastMessage,Toast.LENGTH_SHORT).show();
      }
    });

    boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);
    alarmToggle.setChecked(alarmUp);

    createNotificationChannel();
  }

  public void createNotificationChannel() {
    mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
      NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID, "Notification", NotificationManager.IMPORTANCE_HIGH);
      notificationChannel.enableLights(true);
      notificationChannel.setLightColor(Color.RED);
      notificationChannel.enableVibration(true);
      notificationChannel.setDescription("Notifies every 11:11");
      mNotificationManager.createNotificationChannel(notificationChannel);
    }
  }
}
