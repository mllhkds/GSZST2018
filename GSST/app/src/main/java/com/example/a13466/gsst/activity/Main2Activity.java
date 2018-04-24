package com.example.a13466.gsst.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.a13466.gsst.R;
import com.example.a13466.gsst.utils.ScaleImageUtil;


public class Main2Activity extends AppCompatActivity {


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();


    }

    private void initView() {
        final int[] images = {R.mipmap.show1,R.mipmap.show2,R.mipmap.show3,R.mipmap.show4};
        final ImageView[] imageViews = new ImageView[images.length];
        mViewPager = (ViewPager) findViewById(R.id.ViewPager);
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(imageViews[position]);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ScaleImageUtil scaleImageUtil = new ScaleImageUtil(getApplicationContext());
                scaleImageUtil.setImageResource(images[position]);
                container.addView(scaleImageUtil);
                imageViews[position] = scaleImageUtil;
                return scaleImageUtil;
            }

            @Override
            public int getCount() {
                return imageViews.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
    }


}



