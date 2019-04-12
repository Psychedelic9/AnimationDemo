package com.bai.psychedelic.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button mScaleAnimation,mAlphaAnimation,mRotateAnimation,mTranslateAnimation;
    private ImageView mImageView;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScaleAnimation = findViewById(R.id.main_btn_scale);
        mAlphaAnimation = findViewById(R.id.main_btn_alpha);
        mRotateAnimation = findViewById(R.id.main_btn_rotate);
        mTranslateAnimation = findViewById(R.id.main_btn_move);
        mImageView = findViewById(R.id.image_view);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn_scale:
                animation = AnimationUtils.loadAnimation(this,R.anim.scale);
                animation.setFillAfter(false);
                animation.setFillBefore(true);
                mImageView.startAnimation(animation);

                break;
            case R.id.main_btn_alpha:
                animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
//                animation = new AlphaAnimation(1,0);
                animation.setDuration(1000);
                animation.setRepeatMode(Animation.REVERSE);
                animation.setRepeatCount(100);
                mImageView.startAnimation(animation);
                Log.d(TAG, "onClick: main_btn_alpha startAnimation");
                break;
            case R.id.main_btn_rotate:
                animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
                mImageView.startAnimation(animation);
                break;
            case R.id.main_btn_move:
//                TranslateAnimation translateAnimation = new TranslateAnimation(-50,-50,50,50);
//                translateAnimation.setDuration(1000);
//                translateAnimation.setRepeatCount(Animation.INFINITE);
//                translateAnimation.setRepeatMode(Animation.RESTART);
//                mImageView.startAnimation(translateAnimation);
                animation = AnimationUtils.loadAnimation(this,R.anim.translate);
                mImageView.startAnimation(animation);
                break;
            case R.id.main_btn_start_activity:
                Intent intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in,R.anim.rotate);
                break;
        }
        if (animation!=null){
        }
    }
}
