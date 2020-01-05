package com.bai.psychedelic.animationdemo;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ListView mListView;
    private ListAdapter adapter;
    private ArrayList<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mList = new ArrayList<>();
        adapter = new ListAdapter(this, mList);
        for (int i = 0; i < 20; i++) {
            mList.add("你看谁呢？" + i);
        }
        mListView = findViewById(R.id.list_view);
        mListView.setAdapter(adapter);
        LayoutAnimationController controller = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        controller.setOrder(LayoutAnimationController.ORDER_RANDOM);
        mListView.setLayoutAnimation(controller);
        mListView.startLayoutAnimation();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("Main2Activity", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {//横屏
            Log.d("Main2Activity", "横屏");
            setContentView(R.layout.activity_main2_land);
            mListView = findViewById(R.id.main_list_land);
            mListView.setAdapter(adapter);
            getRequestedOrientation();
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {//竖屏
            setContentView(R.layout.activity_main2);
            Log.d("Main2Activity", "竖屏");
            mListView = findViewById(R.id.list_view);
            mListView.setAdapter(adapter);
        }
    }
}
