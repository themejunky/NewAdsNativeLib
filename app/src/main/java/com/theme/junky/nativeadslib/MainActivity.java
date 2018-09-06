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
       // managerNative.iniNativeAppnext("66f95906-de1e-4643-b953-b8bd30524882",true);
       // managerNative.initNativeAdmob("ca-app-pub-8562466601970101/9984599253",true);
        managerNative.iniNativeFacebook(" ",true);


    }


}
