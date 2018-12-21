package com.derrick.park.assignment3_contacts.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.google.gson.Gson;

public class AddContactActivity extends AppCompatActivity {

  public static final String INTENT_EXTRA_NAME = AddContactActivity.class.getSimpleName() + ".extra";
  public static final int INTENT_REQUEST_CODE = 1;

  private EditText nameInput;
  private EditText cellInput;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_contact);

    nameInput = findViewById(R.id.name_input);
    cellInput = findViewById(R.id.cell_input);
  }

  public void clickAddButton(View view) {
    boolean hasError = false;
    if (!checkNameInput()) hasError = true;
    if (!checkCellInput()) hasError = true;
    if (hasError) return;

    Contact contact = new Contact(nameInput.getText().toString(), cellInput.getText().toString());
    Gson gson = new Gson();
    Intent intent = new Intent();
    intent.putExtra(INTENT_EXTRA_NAME, gson.toJson(contact));
    setResult(RESULT_OK, intent);
    finish();
  }



  private boolean checkNameInput() {
    String name = nameInput.getText().toString();

    if (name.isEmpty()) {
      nameInput.setError("Enter your name");
      return false;
    }

    if (name.split(" ").length != 2) {
      nameInput.setError("Enter two words");
      return false;
    }

    return true;
  }

  private boolean checkCellInput() {
    String cell = cellInput.getText().toString();

    if (cell.isEmpty()) {
      cellInput.setError("Enter your phone number");
      return false;
    }

    if (!cell.replace("-", "").matches("\\d{10}")) {
      cellInput.setError("Enter 10 digits");
      return false;
    }

    return true;
  }
}
