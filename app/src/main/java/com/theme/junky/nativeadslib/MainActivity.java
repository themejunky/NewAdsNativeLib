package com.theme.junky.nativeadslib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;


import com.mynativelib.manager.ManagerNative;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alin on 9/6/2018.
 */

public class MainActivity extends AppCompatActivity {
    List<String>flow = Arrays.asList("admob","appnext");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout containerAds = findViewById(R.id.containerAds);

        ManagerNative managerNative = new ManagerNative(this);
        managerNative.setNameLog("TestNativeLog");

        //managerNative.initNativeAdmob("ca-app-pub-8562466601970101/9984599253",true);
        //managerNative.iniNativeAppnext("099d058a-6ec5-49bc-a3ec-98caf88a6692",true);
        managerNative.iniNativeFacebook("833164856890775_838240766383184",true);
        //adsManager.initFacebookNativeAds(containerFacebook, "833164856890775_838240766383184");
        //adsManager.initFacebookNativeAds(containerFacebook, "263700057716193_263734114379454");
        //adsManager.initFacebookNativeAds(containerFacebook, "467576940317585_467577570317522");
        managerNative.showAds(flow,containerAds);
    }


}
