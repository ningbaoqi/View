package com.example.ningbaoqi.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Type3Holder3 extends AbstractHolder1 {
    public ImageView avartar;
    public TextView name;
    public TextView content;
    public ImageView contentImage;

    public Type3Holder3(View itemView) {
        super(itemView);
        avartar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        contentImage = itemView.findViewById(R.id.content_image);
    }

    @Override
    public void bindHolder(DataModel dataModel) {
        avartar.setBackgroundResource(dataModel.avaterColor);
        name.setText(dataModel.name);
        content.setText(dataModel.content);
        contentImage.setBackgroundResource(dataModel.contentColor);
    }
}
