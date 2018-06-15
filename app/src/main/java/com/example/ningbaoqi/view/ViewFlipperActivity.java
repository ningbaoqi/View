package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends AppCompatActivity {
    private int[] resID = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewflipper);
        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.viewPager);
        for (int i = 0; i < resID.length; i++) {
            flipper.addView(getImageView(resID[i]));
        }
        flipper.setInAnimation(this, R.anim.anim_in);
        flipper.setOutAnimation(this, R.anim.anim_out);
        flipper.setFlipInterval(2000);
        flipper.startFlipping();
//        flipper.showNext();
//        flipper.showPrevious();
    }

    private ImageView getImageView(int i) {
        ImageView ima = new ImageView(this);
        ima.setBackgroundResource(i);
        return ima;
    }
}
