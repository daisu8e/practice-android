package com.derrick.park.assignment3_contacts.activities.contact_list;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.derrick.park.assignment3_contacts.R;

public class StickyHeaderItemDecoration extends RecyclerView.ItemDecoration {

  private Canvas canvas;
  private Adapter adapter;
  private View stickyHeaderView;
  private View nextStickyHeaderView;

  @Override
  public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

    canvas = c;
    adapter = (Adapter)parent.getAdapter();

    View topChild = parent.getChildAt(0);
    if (topChild == null)  return;

    int topChildPosition = parent.getChildAdapterPosition(topChild);
    if (topChildPosition == RecyclerView.NO_POSITION)  return;

    int headerPosition = 0;
    for (int i = topChildPosition; i > headerPosition; i--) {
      if (((Adapter)parent.getAdapter()).isHeader(i)) {
        headerPosition = i;
        break;
      }
    }

    stickyHeaderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_header, parent, false);
    TextView indexField = stickyHeaderView.findViewById(R.id.index_field);
    Header header = (Header)adapter.getItems().get(headerPosition);
    indexField.setText(header.getIndex());

    int widthSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth(), View.MeasureSpec.EXACTLY);
    int heightSpec = View.MeasureSpec.makeMeasureSpec(parent.getHeight(), View.MeasureSpec.UNSPECIFIED);
    int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec, parent.getPaddingLeft() + parent.getPaddingRight(), stickyHeaderView.getLayoutParams().width);
    int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec, parent.getPaddingTop() + parent.getPaddingBottom(), stickyHeaderView.getLayoutParams().height);
    stickyHeaderView.measure(childWidthSpec, childHeightSpec);
    stickyHeaderView.layout(0, 0, stickyHeaderView.getMeasuredWidth(), stickyHeaderView.getMeasuredHeight());

    nextStickyHeaderView = null;
    int bottom = stickyHeaderView.getBottom();
    for (int i = 0; i < parent.getChildCount(); i++) {
      View child = parent.getChildAt(i);
//      if (child.getTop() <= bottom && bottom < child.getBottom()) {
//        nextStickyHeaderView = child;
//        break;
//      }
      if (child.getBottom() > bottom) {
        if (child.getTop() <= bottom) {
          nextStickyHeaderView = child;
          break;
        }
      }
    }
    if (nextStickyHeaderView == null) return;

    if (adapter.isHeader(parent.getChildAdapterPosition(nextStickyHeaderView))) {
      draw(0, nextStickyHeaderView.getTop() - stickyHeaderView.getHeight());
      return;
    }

    draw(0, 0);
  }

  private void draw(float x, float y) {
    canvas.save();
    canvas.translate(x, y);
    stickyHeaderView.draw(canvas);
    canvas.restore();
  }
}
