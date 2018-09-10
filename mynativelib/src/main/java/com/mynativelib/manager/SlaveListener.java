package com.mynativelib.manager;

import android.util.Log;

/**
 * Created by Junky2 on 4/19/2018.
 */

public  class SlaveListener implements AdsListenerManager.NativeListener, AdsListenerManager.ListenerLogs {
    @Override
    public void logs(String logs) {}

    @Override
    public void loadedNativeAds(String theAd) {
        //Log.d("InfoNativeAds","a native has loaded "+theAd);
    }
}
