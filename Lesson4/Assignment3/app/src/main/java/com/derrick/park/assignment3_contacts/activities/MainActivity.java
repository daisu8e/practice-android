package com.derrick.park.assignment3_contacts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.activities.contact_list.Adapter;
import com.derrick.park.assignment3_contacts.activities.contact_list.StickyHeaderItemDecoration;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.derrick.park.assignment3_contacts.models.ContactList;
import com.derrick.park.assignment3_contacts.network.ContactClient;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = MainActivity.class.getSimpleName();

  private RecyclerView contactList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    Call<ContactList> call = ContactClient.getContacts(10);
    call.enqueue(new Callback<ContactList>() {
      @Override
      public void onResponse(Call<ContactList> call, Response<ContactList> response) {
        if (response.isSuccessful()) {
          render(response.body().getContacts());
        }
      }

      @Override
      public void onFailure(Call<ContactList> call, Throwable t) {
        Log.e(TAG, "failed");
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_add:
        Intent intent = new Intent(getApplicationContext(), AddContactActivity.class);
        startActivityForResult(intent, AddContactActivity.INTENT_REQUEST_CODE);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == AddContactActivity.INTENT_REQUEST_CODE) {
      if (resultCode == RESULT_OK) {
        Gson gson = new Gson();
        String json = data.getStringExtra(AddContactActivity.INTENT_EXTRA_NAME);
        render(gson.fromJson(json, Contact.class));
      }
    }
  }


  private void render(ArrayList<Contact> contacts) {
    contactList = findViewById(R.id.contact_list);
    contactList.setLayoutManager(new LinearLayoutManager(this));
    contactList.setAdapter(new Adapter(contacts));
    contactList.addItemDecoration(new StickyHeaderItemDecoration());
  }

  private void render(Contact contact) {
    Adapter adapter = (Adapter)contactList.getAdapter();
    adapter.add(contact);
  }
}
