package com.example.ningbaoqi.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Type1Holder1 extends AbstractHolder1 {
    public ImageView avartar;
    public TextView name;

    public Type1Holder1(View itemView) {
        super(itemView);
        avartar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
    }

    /**
     * 数据绑定
     *
     * @param model
     */
    @Override
    public void bindHolder(DataModel model) {
        avartar.setBackgroundResource(model.avaterColor);
        name.setText(model.name);
    }
}
