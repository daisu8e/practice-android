package com.kat2n.practice_android.lesson7.lab3.task;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

  private TextView randomNumberText;
  private CustomReceiver mReceiver = new CustomReceiver();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    randomNumberText = findViewById(R.id.randomNumberText);
    initRandomNumber();

    receivePowerBroadcast();
    receiveCustomBroadcast();
    receiveHeadsetPlugBroadcast();
  }

  @Override
  protected void onDestroy() {
    this.unregisterReceiver(mReceiver);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
    super.onDestroy();
  }

  public void sendCustomBroadcast(View view) {
    Intent intent = new Intent(ACTION_CUSTOM_BROADCAST);
    intent.putExtra("RANDOM_NUMBER", randomNumberText.getText());
    LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    initRandomNumber();
  }

  private void initRandomNumber() {
    randomNumberText.setText(String.valueOf(new Random().nextInt(19) + 1));
  }

  private void receivePowerBroadcast() {
    IntentFilter filter = new IntentFilter();
    filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
    filter.addAction(Intent.ACTION_POWER_CONNECTED);
    this.registerReceiver(mReceiver, filter);
  }

  private void receiveCustomBroadcast() {
    LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
  }

  private void receiveHeadsetPlugBroadcast() {
    this.registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_HEADSET_PLUG));
  }
}
