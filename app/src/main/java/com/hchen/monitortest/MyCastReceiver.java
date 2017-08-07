package com.hchen.monitortest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by user on 2017/8/2.
 */

public class MyCastReceiver extends BroadcastReceiver {
    private int STATUS;
    @Override
    public void onReceive(final Context context, Intent intent)
    {
        Log.i("AAAAAA","messagereceived");
        //STATUS=intent.getIntExtra("app_status",1);
        //Log.i("AAAAAA","messagereceived"+STATUS);
        ActivityCollector.finishAll();
        //Intent intent_newactivity = new Intent(context, OpenPeActivity.class);
        //intent_newactivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //context.startActivity(intent);
        Intent myIntent=new Intent(context,OpenPeActivity.class);
        PendingIntent pi=PendingIntent.getActivity(context, 0, myIntent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("程序被打开")
                .setTicker("你又在玩了！")
                .setContentIntent(pi)
                .setSmallIcon(android.R.drawable.ic_lock_idle_charging);
        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(2, builder.build());
    }
}

///*作者：slimhippo
//        链接：http://www.jianshu.com/p/224e2479da18
//        來源：简书
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
