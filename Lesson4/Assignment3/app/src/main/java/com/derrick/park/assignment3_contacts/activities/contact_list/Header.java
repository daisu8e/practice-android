package com.derrick.park.assignment3_contacts.activities.contact_list;

public class Header implements Item {

  private String index;

  public Header(String index) {
    this.index = index.toUpperCase();
  }

  public String getIndex() {
    return index;
  }
}
