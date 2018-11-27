package jx.com.day1.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewById());
        initView();
        intiData();
    }

    protected abstract void intiData();

    protected abstract void initView();

    protected abstract int getViewById();
}
