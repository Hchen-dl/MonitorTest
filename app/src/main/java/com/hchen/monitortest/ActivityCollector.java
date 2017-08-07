package com.hchen.monitortest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/8/4.
 */

public class ActivityCollector {
    private static List<Activity> activities=new ArrayList<>();
    public static void addActivity(Activity activity)
    {
        activities.add(activity);
    }
    public static void remove(Activity activity)
    {
        activities.remove(activity);
    }
    public static void finishAll()
    {
        for(Activity activity:activities)
        {
            if(!activity.isFinishing())
            {
                activity.finish();
            }
        }
    }
}
