package com.derrick.park.assignment3_contacts.activities.contact_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;

import java.util.ArrayList;
import java.util.Collections;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private ArrayList<Contact> contacts;
  private ArrayList<Item> items;

  public Adapter(ArrayList<Contact> contacts) {
    this.contacts = contacts;
    parse();
  }

  @Override
  public int getItemViewType(int position) {
    Item item = items.get(position);
    if (item instanceof Header) return 0;
    else if (item instanceof Data) return 1;
    return -1;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
    View view;
    switch (viewType) {
      case 0:
        view = layoutInflater.inflate(R.layout.list_item_header, viewGroup, false);
        return new HeaderViewHolder(view);
      case 1:
        view = layoutInflater.inflate(R.layout.list_item_data, viewGroup, false);
        return new DataViewHolder(view);
    }
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    Item item = items.get(i);
    if (viewHolder instanceof HeaderViewHolder) {
      ((HeaderViewHolder)viewHolder).setHeader((Header)item);
    } else if (viewHolder instanceof DataViewHolder) {
      ((DataViewHolder)viewHolder).setData((Data)item);
    }
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public void add(Contact contact) {
    contacts.add(contact);
    parse();
    notifyDataSetChanged();
  }



  private void parse() {
    Collections.sort(contacts);
    items = new ArrayList<>();
    String index = "";
    for (Contact contact : contacts) {
      String initial = contact.getName().toString().toLowerCase().substring(0, 1);
      if (!index.equals(initial)) {
        index = initial;
        items.add(new Header(index));
      }
      items.add(new Data(contact));
    }
  }
}
