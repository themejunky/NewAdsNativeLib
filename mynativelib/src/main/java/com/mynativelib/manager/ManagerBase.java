package com.mynativelib.manager;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junky2 on 4/19/2018.
 */

public class ManagerBase extends SlaveListener {
    protected int next;
    protected static List<String> addsFlowNative = new ArrayList<>();
    public static String nameLogs="InfoNativeAds";
    public static String nAction="testAction";
    protected View containerNativeView;
    protected  static AdsListenerManager.NativeListener nativeListener;
    protected static boolean isReloaded;


    public interface _Interface {
        void mGoBackFromDisplay();
    }

    @Override
    public void logs(String logs) {
        Log.d(nameLogs, logs);
    }

}
