package com.example.a13466.gsst.activity;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a13466.gsst.R;
import com.example.a13466.gsst.fragment.UserLoginFragment;
import com.example.a13466.gsst.utils.ToastUtil;

public class UserLoginActivity extends BaseActivity {
    private ImageView mBack;
    private TextView mSetInternet;


    @Override
    protected void onAfter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_userlogin;
    }

    @Override
    protected String getLayoutTitle() {
        return "";
    }

    @Override
    protected void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mSetInternet = (TextView) findViewById(R.id.setInternet);
        mBack.setVisibility(View.GONE);
        SharedPreferences prefGuide = this.getSharedPreferences("ToFirst", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorGuide = prefGuide.edit();
        editorGuide.putBoolean("ToMain", false).apply();

    }

    @Override
    protected void initData() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.relativeLayout_fragment,new UserLoginFragment());
        ft.commit();
        mSetInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast(getApplicationContext(),"123");
            }
        });
    }

    /**
     * 正则表达式判断 ip 格式是否正确
     * @param ip 输入的 ip
     * @return
     * ip 的范围是0-255.0-255.0-255.0-255
     */
    private static boolean isIpNo(String ip){
        String IPok = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        if (TextUtils.isEmpty(ip)){
            return false;
        } else {
            return ip.matches(IPok);
        }
    }
}













