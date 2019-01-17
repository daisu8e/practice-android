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
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

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
          //long repeatInterval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;
          long repeatInterval = 1 * 1000;
          long triggerTime = SystemClock.elapsedRealtime() + repeatInterval;

          if (alarmManager != null) {
            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, repeatInterval, notifyPendingIntent);
          }
          toastMessage = "Stand Up Alarm On!";
        } else {
          if (alarmManager != null) {
            alarmManager.cancel(notifyPendingIntent);
          }
          mNotificationManager.cancelAll();
          toastMessage = "Stand Up Alarm Off!";
        }
        Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
      }
    });

    boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);
    alarmToggle.setChecked(alarmUp);

    Button nextAlarmButton = findViewById(R.id.nextAlarmButton);
    nextAlarmButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        AlarmManager.AlarmClockInfo alarmClockInfo = alarmManager.getNextAlarmClock();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(alarmClockInfo.getTriggerTime());
        Toast.makeText(MainActivity.this, DateFormat.format("EEEE, MMMM d, yyyy 'at' h:mm a", calendar), Toast.LENGTH_SHORT).show();
      }
    });

    createNotificationChannel();
  }

  public void createNotificationChannel() {
    mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
      NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID, "Stand up notification", NotificationManager.IMPORTANCE_HIGH);
      notificationChannel.enableLights(true);
      notificationChannel.setLightColor(Color.RED);
      notificationChannel.enableVibration(true);
      notificationChannel.setDescription("Notifies every 15 minutes to stand up and walk");
      mNotificationManager.createNotificationChannel(notificationChannel);
    }
  }

}
