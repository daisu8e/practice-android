package com.example.android.materialme;

class Sport {

  private String title;
  private String info;
  private final int imageResource;
  private String detail;

  public Sport(String title, String info, int imageResource, String detail) {
    this.title = title;
    this.info = info;
    this.imageResource = imageResource;
    this.detail = detail;
  }

  public Sport(String title, String info, int imageResource) {
    this.title = title;
    this.info = info;
    this.imageResource = imageResource;
  }

  public String getTitle() {
    return title;
  }

  public String getInfo() {
    return info;
  }

  public int getImageResource() {
    return imageResource;
  }

  public String getDetail() {
    return detail;
  }

}
