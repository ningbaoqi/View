package com.example.ningbaoqi.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class AbstractHolder1 extends RecyclerView.ViewHolder {
    public AbstractHolder1(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(DataModel dataModel);
}