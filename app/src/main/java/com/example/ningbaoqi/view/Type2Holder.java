package com.example.ningbaoqi.view;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Type2Holder extends AbstractHolder<DataModelTwo> {
    public ImageView avartar;
    public TextView name;
    public TextView content;

    public Type2Holder(View itemView) {
        super(itemView);
        avartar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void bindHolder(DataModelTwo dataModel) {
        avartar.setBackgroundResource(dataModel.avaterColor);
        name.setText(dataModel.name);
        content.setText(dataModel.content);
    }
}
