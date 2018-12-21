package com.derrick.park.assignment3_contacts.activities.contact_list;

import com.derrick.park.assignment3_contacts.models.Contact;

public class Data implements Item {

  private Contact contact;

  public Data(Contact contact) {
    this.contact = contact;
  }

  public Contact getContact() {
    return contact;
  }
}
