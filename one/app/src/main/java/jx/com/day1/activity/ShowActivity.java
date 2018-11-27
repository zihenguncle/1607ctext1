package jx.com.day1.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import jx.com.day1.R;
import jx.com.day1.base.BaseActivity;
import jx.com.day1.bean.NewBean;
import jx.com.day1.util.NetUtil;

/**
 * @author ziheng
 */
public class ShowActivity extends BaseActivity {


    private ListView listView;
    private ViewPager viewPager;


    @Override
    protected void intiData() {
        NetUtil.getInstance().getload("http://www.zhaoapi.cn/product/getProductDetail?pid=1", NewBean.class, new NetUtil.CallBack<NewBean>() {
            @Override
            public void getload(NewBean bean) {

            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getViewById() {
        return R.layout.activity_show;
    }
}
