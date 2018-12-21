package com.derrick.park.assignment3_contacts.activities.contact_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.derrick.park.assignment3_contacts.R;

public class DataViewHolder extends RecyclerView.ViewHolder {

  private Data data;
  private TextView nameField;
  private TextView cellField;

  public DataViewHolder(@NonNull View itemView) {
    super(itemView);
    nameField = itemView.findViewById(R.id.name_field);
    cellField = itemView.findViewById(R.id.cell_field);
  }

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
    render();
  }



  private void render() {
    nameField.setText(data.getContact().getName().toString());
    cellField.setText(data.getContact().getCell());
  }
}
