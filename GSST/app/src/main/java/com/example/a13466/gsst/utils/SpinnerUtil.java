package com.example.a13466.gsst.utils;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.a13466.gsst.R;

public class SpinnerUtil {

    private static ArrayAdapter<String> adapter;

    public interface OnItemSelected{
        //void onItemSelected(int position);
        void onItemSelected(int position,AdapterView<?> parent);
    }

    /**
     *
     * @param context Context
     * @param spinner id
     * @param datas Spinner填充数据
     * @param listener 监听
     */
    public static void getSpinner (Context context, Spinner spinner,String[] datas,final OnItemSelected listener){
        adapter = new ArrayAdapter<>(context, R.layout.item_spinner,datas);
        adapter.setDropDownViewResource(R.layout.item_spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null) {
                   // listener.onItemSelected(position);
                     listener.onItemSelected(position,parent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
