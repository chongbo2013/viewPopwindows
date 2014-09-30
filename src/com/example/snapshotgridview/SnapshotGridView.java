package com.example.snapshotgridview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;

public class SnapshotGridView extends GridView {

    private static final int MAX_COLUMNS = 5;

    private int mColWidth;

    public SnapshotGridView(Context context) {
        super(context);
    }

    public SnapshotGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SnapshotGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthSize > 0 && mColWidth > 0) {
            int numCols = widthSize / mColWidth;
            widthSize = Math.min(
                    Math.min(numCols, MAX_COLUMNS) * mColWidth,
                    widthSize);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize, widthMode);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setColumnWidth(int columnWidth) {
        mColWidth = columnWidth;
        super.setColumnWidth(columnWidth);
    }
}

