package com.derrick.park.assignment3_contacts.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact implements Comparable<Contact> {
  @SerializedName("gender")
  @Expose
  private String gender;
  @SerializedName("name")
  @Expose
  private Name name;
  @SerializedName("location")
  @Expose
  private Location location;
  @SerializedName("email")
  @Expose
  private String email;
  @SerializedName("cell")
  @Expose
  private String cell;

  public Contact(String name, String cell) {
    this.name = new Name(name);
    this.cell = cell;
  }

  public String getGender() {
    return gender;
  }

  public Name getName() {
    return name;
  }

  public Location getLocation() {
    return location;
  }

  public String getEmail() {
    return email;
  }

  public String getCell() {
    return cell;
  }

  @Override
  public String toString() {
    return String.format("%n%s%n%s%n%s%n%s", name, location, email, cell);
  }

  @Override
  public int compareTo(@NonNull Contact that) {
    return this.name.toString().toLowerCase().compareTo(that.name.toString().toLowerCase());
  }

  /**
   * Name {first: , last: }
   */
  public class Name {
    @SerializedName("first")
    @Expose
    private String first;
    @SerializedName("last")
    @Expose
    private String last;

    public Name(String name) {
      String[] names = name.split(" ");
      this.first = names[0];
      this.last = names[1];
    }

    public String getFirst() {
      return first;
    }

    public String getLast() {
      return last;
    }

    @Override
    public String toString() {
      return first + " " + last;
    }
  }

  /**
   * Location {street: , city: , state: , postcode: }
   */
  public class Location {
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String province;
    @SerializedName("postcode")
    @Expose
    private String postcode;

    public String getStreet() {
      return street;
    }

    public String getCity() {
      return city;
    }

    public String getProvince() {
      return province;
    }

    public String getPostcode() {
      return postcode;
    }

    @Override
    public String toString() {
      return street + ", " + city + ", " + province + " Canada " + postcode;
    }
  }
}

