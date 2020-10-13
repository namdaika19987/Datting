package com.example.datting.Home;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomItemDecorator extends RecyclerView.ItemDecoration {
    private int space;
    private int space1;

    public CustomItemDecorator(int space, int space1) {
        this.space = space;
        this.space1 = space1;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildLayoutPosition(view) == 1){
            outRect.top = space1 - space;
        }else {
            outRect.top = space;
        }
    }
}
