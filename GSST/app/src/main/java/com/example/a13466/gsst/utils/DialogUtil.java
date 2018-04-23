package com.example.a13466.gsst.utils;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class DialogUtil {

    private static volatile AlertDialog.Builder builder;
    private static AlertDialog dialog;


    public interface OnListener {
        void onAfter(View view);
    }
    public static AlertDialog.Builder showDIYDialog
            (Context context, final int rootLayout, final int[] arg, final OnListener onListener) {
        builder = new AlertDialog.Builder(context);
        final View layout = LayoutInflater.from(context).inflate(rootLayout, null);
        builder.setView(layout).create();
        if (arg != null) {
            for (int i = 0; i < arg.length; i++) {
                layout.findViewById(arg[i]).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        onListener.onAfter(view);
                    }
                });
            }
        }
        return builder;
    }
}
