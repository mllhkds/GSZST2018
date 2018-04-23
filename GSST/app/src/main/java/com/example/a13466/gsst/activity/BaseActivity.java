package com.example.a13466.gsst.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a13466.gsst.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected TextView mTitleTV;
    protected String mBasUrl;
    public static  String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        getIP();
        initView();
        setLayoutTitle();
        initData();
    }

    private void getIP(){
        SharedPreferences sh = getSharedPreferences("ipset", 0);
        mBasUrl = "http://" + sh.getString("ip", getString(R.string.default_ip)) + ":" + 8080
                + "/transportservice/type/jason/action/";
    }

    private void setLayoutTitle(){
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_actionbar);
        ImageView imageView = (ImageView) layout.findViewById(R.id.back);
        mTitleTV = (TextView) layout.findViewById(R.id.title);
        if (mTitleTV.getText().toString().isEmpty()){
            mTitleTV.setText(getLayoutTitle());
        }
        TAG = getLayoutTitle();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAfter();
            }
        });
    }

    public void replaceFragment(Fragment fragment,boolean backstack){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_home,fragment);
        if (backstack){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
    protected abstract void onAfter();
    protected abstract int getLayoutId();
    protected abstract String getLayoutTitle();
    protected abstract void initView();
    protected abstract void initData();

}
