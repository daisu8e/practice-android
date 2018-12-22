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

  public static final int VIEW_TYPE_HEADER = 0;
  public static final int VIEW_TYPE_DATA = 1;
  public static final int VIEW_TYPE_UNKNOWN = -1;

  private ArrayList<Contact> contacts;
  private ArrayList<Item> items;

  public Adapter(ArrayList<Contact> contacts) {
    this.contacts = contacts;
    parse();
  }

  @Override
  public int getItemViewType(int position) {
    Item item = items.get(position);
    if (item instanceof Header) return VIEW_TYPE_HEADER;
    else if (item instanceof Data) return VIEW_TYPE_DATA;
    return VIEW_TYPE_UNKNOWN;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
    View view;
    switch (viewType) {
      case VIEW_TYPE_HEADER:
        view = layoutInflater.inflate(R.layout.list_item_header, viewGroup, false);
        return new HeaderViewHolder(view);
      case VIEW_TYPE_DATA:
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

  public boolean isHeader(int position) {
    return getItemViewType(position) == VIEW_TYPE_HEADER;
  }

  public ArrayList<Item> getItems() {
    return items;
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
