package com.theme.junky.nativeadslib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;

import com.mynativelib.manager.AdsListenerManager;
import com.mynativelib.manager.ManagerNativeAds;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alin on 9/6/2018.
 */

public class MainActivity extends AppCompatActivity implements AdsListenerManager.NativeListener {
    List<String>flow = Arrays.asList("admob","appnext","facebook");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout containerAds = findViewById(R.id.containerAds);

        ManagerNativeAds managerNativeAds = new ManagerNativeAds(this);
        managerNativeAds.setNameLog("InfoNativeAds");
        managerNativeAds.setListener(this);

        managerNativeAds.initNativeAdmob("ca-app-pub-8562466601970101/9984599253",true);
        //managerNativeAds.iniNativeAppnext("099d058a-6ec5-49bc-a3ec-98caf88a6692",true);
        //managerNativeAds.iniNativeFacebook("833164856890775_838240766383184",true);
        managerNativeAds.showAds(flow,containerAds);
    }


    @Override
    public void loadedNativeAds(String theAd) {
        Log.d("InfoNativeAds","a native has loaded "+theAd);
    }

}
