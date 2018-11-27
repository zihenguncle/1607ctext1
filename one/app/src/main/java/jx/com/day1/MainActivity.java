package jx.com.day1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import jx.com.day1.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private int i = 5;
    private TextView time;
    private Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int sj = msg.what;
            time.setText(sj);
        }
    };


    @Override
    protected void intiData() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (i > 0){
                    i--;
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(i);
                    if(i == 0){

                    }
                }
            }
        }.start();
    }

    @Override
    protected void initView() {
        time = findViewById(R.id.time);
    }

    @Override
    protected int getViewById() {
        return R.layout.activity_main;
    }
}
