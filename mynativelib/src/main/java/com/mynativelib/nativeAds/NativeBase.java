package com.mynativelib.nativeAds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.mynativelib.R;
import com.mynativelib.manager.ManagerBase;


public class NativeBase extends ManagerBase {
    Context nContext;
    View mAdView;

    View mInflateLayout(int nLayout) {
        LayoutInflater factory = LayoutInflater.from(nContext);
        View DialogInflateView = factory.inflate(nLayout, null);
        return DialogInflateView.findViewById(R.id.nContainer);
    }

    public View getViewNativeAd() {
        return mAdView;
    }
}
