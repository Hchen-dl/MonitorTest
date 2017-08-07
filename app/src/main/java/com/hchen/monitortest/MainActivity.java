package com.hchen.monitortest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button start;
    private Button stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent in=getIntent();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.btn_startService);
        stop = (Button) findViewById(R.id.btn_stopService);

        //创建启动Service的Intent,以及Intent属性
        final Intent intent = new Intent();
        intent.setAction("com.hchen.monitortest.monitorApp");
        intent.setPackage("com.hchen.monitortest");
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("monitortest", "点击了按钮");
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("dianjileguanbi", "点击了关闭");
                stopService(intent);
            }
        });
    }

}
