package com.example.a13466.gsst.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.a13466.gsst.R;

public class UserLoginFragment extends BaseFragment implements View.OnClickListener {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private AutoCompleteTextView mAccount;
    private EditText mPassword;
    private CheckBox mRemember;
    private CheckBox mAutomatic;
    private Button mLoginPageBtn;
    private Button mRegisteredBtn;

    @Override
    protected String getTitletv() {
        return getString(R.string.login);
    }

    @Override
    protected void initView(View itemView) {
        pref = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        editor = pref.edit();
        mAccount = (AutoCompleteTextView) itemView.findViewById(R.id.account);
        mPassword = (EditText) itemView.findViewById(R.id.password);
        mRemember = (CheckBox) itemView.findViewById(R.id.checkbox_Remember);
        mAutomatic = (CheckBox) itemView.findViewById(R.id.checkbox_Automatic);
        mLoginPageBtn = (Button) itemView.findViewById(R.id.btn_loginPage);
        mLoginPageBtn.setOnClickListener(this);
        mRegisteredBtn = (Button) itemView.findViewById(R.id.btn_registered);
        mRegisteredBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_loginPage:
                // TODO 18/04/24

                //startActivity(new Intent(getActivity(), MainActivity.class));
                break;
            case R.id.btn_registered:
                // TODO 18/04/24
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.relativeLayout_fragment,new UserRegisteredFragment());
                ft.commit();
                break;
            default:
                break;
        }
    }
}
