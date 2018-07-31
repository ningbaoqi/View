package com.example.ningbaoqi.view;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Type3Holder extends AbstractHolder<DataModelThree> {
    public ImageView avartar;
    public TextView name;
    public TextView content;
    public ImageView contentImage;

    public Type3Holder(View itemView) {
        super(itemView);
        avartar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        contentImage = itemView.findViewById(R.id.content_image);
        itemView.setBackgroundColor(Color.WHITE);
    }

    @Override
    public void bindHolder(DataModelThree dataModel) {
        avartar.setBackgroundResource(dataModel.avaterColor);
        name.setText(dataModel.name);
        content.setText(dataModel.content);
        contentImage.setBackgroundResource(dataModel.contentColor);
    }
}
