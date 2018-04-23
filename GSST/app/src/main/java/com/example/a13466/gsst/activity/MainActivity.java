package com.example.a13466.gsst.activity;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a13466.gsst.R;
import com.example.a13466.gsst.adapter.MenuListAdapter;
import com.example.a13466.gsst.been.Drawer;
import com.example.a13466.gsst.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ListView mDrawerListView;
    private List<Drawer> mlist;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onAfter() {
        mDrawerLayout.openDrawer(Gravity.START);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected String getLayoutTitle() {
        return "First";
    }

    @Override
    protected void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mlist = new ArrayList<>();
        mDrawerListView = (ListView) findViewById(R.id.listView_drawer);
    }

    @Override
    protected void initData() {
        mDrawerLayout.setScrimColor(Color.argb(1,0,0,0));//抽屉拉出后主页面不遮挡（透明）
        prepareListView();
        setListViewListener();
        setAnimationDrawer();
    }

    private void setAnimationDrawer() {
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //这里是写动画的
                View content = mDrawerLayout.getChildAt(0);
                int offset = (int) (drawerView.getWidth() * slideOffset);
                content.setTranslationX(+offset);
                //+为左边，-为右边
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //这里是写打开
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                //这里关闭
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                //菜单切换状态变化时回调的方法
            }
        });
    }

    private long timesize = 0;
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - timesize < 2000)){
            finish();
        } else {
            ToastUtil.showToast(this,"再按一次退出");
            timesize = System.currentTimeMillis();
        }
    }

    private void prepareListView() {
        String[] contents = getResources().getStringArray(R.array.menu_content);
        for (int i = 0; i < contents.length; i++) {
            mlist.add(new Drawer(contents[i]));
        }
        MenuListAdapter adapterListView = new MenuListAdapter(this, mlist);
        mDrawerListView.setAdapter(adapterListView);
    }

    private void setListViewListener() {
        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    case 1:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    case 2:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    case 3:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    case 4:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    case 5:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    case 6:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    case 7:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    case 8:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    case 9:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    case 10:
                        ToastUtil.showToast(MainActivity.this, (position + 1) + "");
                        break;
                    default:
                        break;
                }
                mDrawerLayout.closeDrawer(Gravity.START);
            }
        });
    }
}
