package com.violet.spannedgridlayoutmanager.extension;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;

import com.violet.spannedgridlayoutmanager.R;

/**
 * {@link androidx.recyclerview.widget.RecyclerView.ItemDecoration} that applies a
 * vertical and horizontal spacing between items of the target
 * {@link androidx.recyclerview.widget.RecyclerView}.
 */
public class SpacingItemDecoration extends ItemDecoration {
    private final ItemSpacingOffsets mItemSpacing;

    public SpacingItemDecoration(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpacingItemDecoration(Context context, AttributeSet attrs, int defStyle) {
        final TypedArray a =
                context.obtainStyledAttributes(attrs, R.styleable.twowayview_SpacingItemDecoration, defStyle, 0);

        final int verticalSpacing =
                Math.max(0, a.getInt(R.styleable.twowayview_SpacingItemDecoration_android_verticalSpacing, 0));
        final int horizontalSpacing =
                Math.max(0, a.getInt(R.styleable.twowayview_SpacingItemDecoration_android_horizontalSpacing, 0));

        a.recycle();

        mItemSpacing = new ItemSpacingOffsets(verticalSpacing, horizontalSpacing);
    }

    public SpacingItemDecoration(int verticalSpacing, int horizontalSpacing) {
        mItemSpacing = new ItemSpacingOffsets(verticalSpacing, horizontalSpacing);
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        mItemSpacing.getItemOffsets(outRect, itemPosition, parent);
    }
}
