package com.example.ningbaoqi.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Type2Holder2 extends AbstractHolder1 {
    public ImageView avartar;
    public TextView name;
    public TextView content;

    public Type2Holder2(View itemView) {
        super(itemView);
        avartar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
    }

    @Override
    public void bindHolder(DataModel dataModel) {
        avartar.setBackgroundResource(dataModel.avaterColor);
        name.setText(dataModel.name);
        content.setText(dataModel.content);
    }
}