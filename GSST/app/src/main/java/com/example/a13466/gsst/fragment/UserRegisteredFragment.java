package com.example.a13466.gsst.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a13466.gsst.R;

public class UserRegisteredFragment extends BaseFragment implements View.OnClickListener {
    private EditText mUser;
    private EditText mPassword1;
    private EditText mPassword2;
    private EditText mPhone;
    private Button mNoBtn;
    private Button mOkBtn;

    @Override
    protected String getTitletv() {
        return getString(R.string.reginster);
    }

    @Override
    protected void initView(View itemView) {
        mUser = (EditText) itemView.findViewById(R.id.User);
        mPassword1 = (EditText) itemView.findViewById(R.id.password_1);
        mPassword2 = (EditText) itemView.findViewById(R.id.password_2);
        mPhone = (EditText) itemView.findViewById(R.id.phone);
        mNoBtn = (Button) itemView.findViewById(R.id.btn_no);
        mNoBtn.setOnClickListener(this);
        mOkBtn = (Button) itemView.findViewById(R.id.btn_ok);
        mOkBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_no:
                // TODO 18/04/24

                replaceLogin();
                break;
            case R.id.btn_ok:
                // TODO 18/04/24

                replaceLogin();
                break;
            default:
                break;
        }
    }

    private void replaceLogin(){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.relativeLayout_fragment,new UserLoginFragment());
        ft.commit();
    }

    /**
     * 判断用户名是否合法
     * @param name 输入的用户名
     * @return
     */
    private static boolean isUserNameNo(String name){
        //由字母数字下划线组成且开头必须是字母，不能少于6位且超过18位
        String NameTo= "[a-zA-Z][a-zA-Z0-9]{5,17}";
        if (TextUtils.isEmpty(name)){
            return false;
        } else {
            return name.matches(NameTo);
        }
    }

    /**
     * 判断两次输入密码是否一致
     * @param pass1 第一次输入的密码
     * @param pass2 第二次输入的密码
     * @return
     */
    private static boolean isPasswordNo(String pass1,String pass2) {
        //由字母数字组成，不能少于6位且超过12位
        String passOk = "[a-zA-Z0-9]{6,12}";
        if (TextUtils.isEmpty(pass1) && TextUtils.isEmpty(pass2)){
            return false;
        } else {
            if (pass2.equals(pass1)){
                return pass1.matches(passOk);
            } else {
                return false;
            }
        }
    }

    /**
     * 判断手机格式是否正确
     * @param tel 传入 EditText输入的内容
     * @return
     * 第一位必定为1，第二位为3、4、5、7、8，其他位置的可以为 0-9
     */
    private static boolean isPhoneNo(String tel){
        //"[1]"代表第1位为数字1，"[34578]"代表第二位可以为其中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String telRegex = "[1][34578]\\d{9}";
        if (TextUtils.isEmpty(tel)){
            return false;
        } else {
            return tel.matches(telRegex);
        }
    }

}
