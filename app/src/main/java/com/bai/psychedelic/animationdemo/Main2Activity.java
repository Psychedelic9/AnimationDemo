package com.bai.psychedelic.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        mListView = findViewById(R.id.list_view);
        for (int i=0;i<20;i++){
            mList.add("傻逼你看谁呢？"+i);
        }
        adapter = new ListAdapter(this,mList);
        mListView.setAdapter(adapter);
        LayoutAnimationController controller = new LayoutAnimationController(AnimationUtils.loadAnimation(this,R.anim.zoom_in));
        controller.setOrder(LayoutAnimationController.ORDER_RANDOM);
        mListView.setLayoutAnimation(controller);
        mListView.startLayoutAnimation();
    }
}
