package com.derrick.park.assignment3_contacts.activities.contact_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.derrick.park.assignment3_contacts.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

  private Header header;
  private TextView indexField;

  public HeaderViewHolder(@NonNull View itemView) {
    super(itemView);
    indexField = itemView.findViewById(R.id.index_field);
  }

  public Header getHeader() {
    return header;
  }

  public void setHeader(Header header) {
    this.header = header;
    render();
  }



  private void render() {
    indexField.setText(header.getIndex());
  }
}
