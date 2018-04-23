package com.example.a13466.gsst.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast toast;

    public static void showToast(Context context,String ing){
        Context c = context.getApplicationContext();
        if (toast == null){
            toast = Toast.makeText(c,ing,Toast.LENGTH_SHORT);
        }else {
            toast.setText(ing);
        }
        toast.show();
    }
}
