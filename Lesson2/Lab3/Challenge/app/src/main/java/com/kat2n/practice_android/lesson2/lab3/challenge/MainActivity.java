package com.kat2n.practice_android.lesson2.lab3.challenge;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  public static final int REQUEST_CODE = 1;

  private List<String> shoppingList = new ArrayList<>();
  private List<TextView> itemFields = new ArrayList<>();
  private EditText mLocationEditText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    itemFields.add((TextView)findViewById(R.id.itemField0));
    itemFields.add((TextView)findViewById(R.id.itemField1));
    itemFields.add((TextView)findViewById(R.id.itemField2));
    itemFields.add((TextView)findViewById(R.id.itemField3));
    itemFields.add((TextView)findViewById(R.id.itemField4));
    itemFields.add((TextView)findViewById(R.id.itemField5));
    itemFields.add((TextView)findViewById(R.id.itemField6));
    itemFields.add((TextView)findViewById(R.id.itemField7));
    itemFields.add((TextView)findViewById(R.id.itemField8));
    itemFields.add((TextView)findViewById(R.id.itemField9));
    mLocationEditText = findViewById(R.id.location_edittext);
  }

  public void touchAddItemButton(View view) {
    Intent intent = new Intent(this, SecondActivity.class);
    startActivityForResult(intent, REQUEST_CODE);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_CODE) {
      if (resultCode == RESULT_OK) {
        String item = data.getStringExtra(SecondActivity.EXTRA_ITEM);
        shoppingList.add(item);
        render();
      }
    }
  }

  private void render() {
    for (int i = 0; i < itemFields.size(); i++) {
      if (i < shoppingList.size()) itemFields.get(i).setText(shoppingList.get(i));
      else itemFields.get(i).setText("");
    }
  }

  public void openLocation(View view) {
    String loc = mLocationEditText.getText().toString();
    Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
    Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
    if (intent.resolveActivity(getPackageManager()) != null) {
      startActivity(intent);
    } else {
      Log.d("ImplicitIntents", "Can't handle this intent!");
    }
  }

}
