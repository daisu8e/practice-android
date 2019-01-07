package com.kat2n.practice_android.lesson5.lab2.transitiontest;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ListViewHolder extends RecyclerView.ViewHolder {

  private String image;
  private ImageView imageView;

  public ListViewHolder(@NonNull View itemView) {
    super(itemView);

    imageView = itemView.findViewById(R.id.imageView);

    itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onImageClick(v);
      }
    });
  }

  public void setImage(String image) {
    this.image = image;
    render();
  }

  public void onImageClick(View view) {
    Activity activity = (Activity)itemView.getContext();
    Intent intent = new Intent(activity, SecondActivity.class);
    intent.putExtra("image", image);
    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity, imageView, "imageView");
    activity.startActivity(intent, options.toBundle());
  }

  private void render() {
    Activity activity = (Activity)itemView.getContext();
    int imageId = activity.getResources().getIdentifier(image, "drawable", activity.getPackageName());
    Glide.with(itemView.getContext()).load(imageId).into(imageView);
  }
}
