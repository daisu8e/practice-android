package com.example.android.materialme;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {

  private ArrayList<Sport> mSportsData;
  private Context mContext;
  private ImageView mSportsImage;

  SportsAdapter(Context context, ArrayList<Sport> sportsData) {
    this.mSportsData = sportsData;
    this.mContext = context;
  }

  @Override
  public SportsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
  }

  @Override
  public void onBindViewHolder(SportsAdapter.ViewHolder holder, int position) {
    Sport currentSport = mSportsData.get(position);
    holder.bindTo(currentSport);
  }

  @Override
  public int getItemCount() {
    return mSportsData.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mTitleText;
    private TextView mInfoText;

    ViewHolder(View itemView) {
      super(itemView);

      mTitleText = itemView.findViewById(R.id.title);
      mInfoText = itemView.findViewById(R.id.subTitle);
      mSportsImage = itemView.findViewById(R.id.sportsImage);

      itemView.setOnClickListener(this);
    }

    void bindTo(Sport currentSport){
      mTitleText.setText(currentSport.getTitle());
      mInfoText.setText(currentSport.getInfo());
      Glide.with(mContext).load(currentSport.getImageResource()).into(mSportsImage);
    }

    @Override
    public void onClick(View v) {
//      Sport currentSport = mSportsData.get(getAdapterPosition());
//      Intent intent = new Intent(mContext, DetailActivity.class);
//      intent.putExtra("title", currentSport.getTitle());
//      intent.putExtra("image_resource", currentSport.getImageResource());
//      mContext.startActivity(intent);

      Sport currentSport = mSportsData.get(getAdapterPosition());
      Intent intent = new Intent(mContext, DetailActivity.class);
      intent.putExtra("title", currentSport.getTitle());
      intent.putExtra("image_resource", currentSport.getImageResource());
      ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity)mContext, mSportsImage, "sportsImage");
      mContext.startActivity(intent, options.toBundle());
    }
  }
}
