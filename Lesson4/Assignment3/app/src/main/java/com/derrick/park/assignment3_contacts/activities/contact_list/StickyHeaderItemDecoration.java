package com.derrick.park.assignment3_contacts.activities.contact_list;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.derrick.park.assignment3_contacts.R;

public class StickyHeaderItemDecoration extends RecyclerView.ItemDecoration {

  private Canvas canvas;
  private RecyclerView recyclerView;
  private Adapter adapter;
  private int currentHeaderPosition;
  private View stickyHeaderView;
  private View nextHeaderView;

  @Override
  public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

    canvas = c;
    recyclerView = parent;
    adapter = (Adapter)parent.getAdapter();
    currentHeaderPosition = findCurrentHeaderPosition();
    stickyHeaderView = makeStickyHeaderView();
    nextHeaderView = findNextHeaderView();

    if (nextHeaderView.getTop() <= stickyHeaderView.getBottom() && stickyHeaderView.getBottom() < nextHeaderView.getBottom()) {
      draw(0, nextHeaderView.getTop() - stickyHeaderView.getHeight());
    } else {
      draw(0, 0);
    }
  }



  private int findCurrentHeaderPosition() {
    View topChild = recyclerView.getChildAt(0);
    if (topChild == null) return RecyclerView.NO_POSITION;

    int topChildPosition = recyclerView.getChildAdapterPosition(topChild);
    if (topChildPosition == RecyclerView.NO_POSITION) return RecyclerView.NO_POSITION;

    for (int i = topChildPosition; i >= 0; i--) {
      if (adapter.isHeader(i)) return i;
    }

    return RecyclerView.NO_POSITION;
  }

  private View findNextHeaderView() {
    for (int i = 0; i < recyclerView.getChildCount(); i++) {
      View child = recyclerView.getChildAt(i);
      int position = recyclerView.getChildAdapterPosition(child);
      if (adapter.isHeader(position)) return child;
    }
    return null;
  }

  private View makeStickyHeaderView() {
    View stickyHeaderView = LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.list_item_header, recyclerView, false);

    TextView indexField = stickyHeaderView.findViewById(R.id.index_field);
    Header header = (Header)adapter.getItems().get(currentHeaderPosition);
    indexField.setText(header.getIndex());

    int widthSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), View.MeasureSpec.EXACTLY);
    int heightSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), View.MeasureSpec.UNSPECIFIED);
    int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec, recyclerView.getPaddingLeft() + recyclerView.getPaddingRight(), stickyHeaderView.getLayoutParams().width);
    int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec, recyclerView.getPaddingTop() + recyclerView.getPaddingBottom(), stickyHeaderView.getLayoutParams().height);
    stickyHeaderView.measure(childWidthSpec, childHeightSpec);
    stickyHeaderView.layout(0, 0, stickyHeaderView.getMeasuredWidth(), stickyHeaderView.getMeasuredHeight());

    return stickyHeaderView;
  }

  private void draw(float x, float y) {
    canvas.save();
    canvas.translate(x, y);
    stickyHeaderView.draw(canvas);
    canvas.restore();
  }
}
