package com.example.ningbaoqi.view;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Type1Holder extends AbstractHolder<DataModelOne> {
    public ImageView avartar;
    public TextView name;

    public Type1Holder(View itemView) {
        super(itemView);
        avartar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        itemView.setBackgroundColor(Color.BLACK);
    }

    /**
     * 数据绑定
     *
     * @param model
     */
    @Override
    public void bindHolder(DataModelOne model) {
        avartar.setBackgroundResource(model.avaterColor);
        name.setText(model.name);
    }
}
