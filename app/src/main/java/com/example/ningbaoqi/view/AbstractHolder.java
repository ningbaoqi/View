package com.example.ningbaoqi.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class AbstractHolder<T> extends RecyclerView.ViewHolder {
    public AbstractHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T dataModel);
}
