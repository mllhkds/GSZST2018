package com.example.a13466.gsst.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a13466.gsst.R;

public abstract class BaseFragment extends Fragment {
    private Context mcontext;
    private TextView mTitle;
    private String mBasUrl;
    public static  String TAG = "";

    private void getBaseContent() {
        this.mcontext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        getBaseContent();
        initView(view);
        Log.d(TAG, "onCreateView: 123");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTitle = (TextView) getActivity().findViewById(R.id.title);
        mTitle.setText(getTitletv());
        TAG = getTitletv();
        getIP();
        initData();
    }

    protected abstract String getTitletv();

    protected abstract void initView(View itemView);

    protected abstract void initData();

    protected abstract int getLayoutId();

    public void getIP() {
        SharedPreferences sh = getActivity().getSharedPreferences("ipset", 0);
        mBasUrl = "http://" + sh.getString("ip", getString(R.string.default_ip)) + ":" + 8080
                + "/transportservice/type/jason/action/";
    }
    /**
     * 碎片出栈
     */
    public void fragmentPopBackStack(){
        getFragmentManager().popBackStackImmediate();
    }

    /**
     * 通过add添加碎片
     * @param hideFragment 被覆盖的碎片
     * @param addFragment 增加的碎片
     * @param bundle 给增加碎片绑定的数据
     */
    public void addFragment(Fragment hideFragment, Fragment addFragment, Bundle bundle) {
        addFragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(hideFragment);
        transaction.add(R.id.fragment_home,addFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
