package com.mynativelib.manager;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.mynativelib.nativeAds.AdmobNativeAds;
import com.mynativelib.nativeAds.AppnextNativeAds;
import com.mynativelib.nativeAds.FacebookNativeAds;

import java.util.Calendar;
import java.util.List;

public class ManagerNativeAds extends ManagerBase {
    protected Context mContext;
    private AdmobNativeAds admobNativeAds;
    private AppnextNativeAds appnextNativeAds;
    private FacebookNativeAds facebookNativeAds;
    private static ManagerNativeAds instance = null;

    private View mChoosenAd = null;

    private boolean wasShown = false;
    public ViewGroup nContainer;
    private AdsListenerManager.NativeListener listenerNative;

    public ManagerNativeAds(Context nContext) {
        this.mContext = nContext;
    }

    public void initNativeAdmob(String keyAdmob,boolean newInstance) {
        if (newInstance) {
            admobNativeAds = new AdmobNativeAds(mContext, keyAdmob, this, listenerNative);
        } else {
            admobNativeAds = AdmobNativeAds.getInstance(mContext, keyAdmob, this, listenerNative);
        }
    }

    public void iniNativeAppnext( String keyAppnext, boolean newInstance) {
        if (newInstance) {
            appnextNativeAds = new AppnextNativeAds(mContext, keyAppnext, this, listenerNative);
        } else {
            appnextNativeAds = AppnextNativeAds.getInstance(mContext, keyAppnext, this, listenerNative);
        }
    }

    public void iniNativeFacebook(String keyFacebook,boolean newInstance) {
        if (newInstance) {
            facebookNativeAds = new FacebookNativeAds(mContext, keyFacebook, this, listenerNative);
        } else {
            facebookNativeAds = FacebookNativeAds.getmInstance(mContext, keyFacebook, this, listenerNative);
        }

    }

    public void setListener(AdsListenerManager.NativeListener listenerNative){
        this.listenerNative = listenerNative;
    }

    private synchronized void runAdds_Part2Native_Test() {
        wasShown = false;
        next++;
        if (next < addsFlowNative.size()) {
            Log.d(nameLogs, "addsFlowNative.get(next) "+addsFlowNative.get(next) );
            if (addsFlowNative.get(next).equals(ConstantsAds.ADMOB)) {
                Log.d(nameLogs, "AdmobNativeAds: 1" );
                if (admobNativeAds != null && admobNativeAds.getViewNativeAd() != null) {
                    Log.d(nameLogs, "AdmobNativeAds: 2" );
                    wasShown = true;
                    mChoosenAd = admobNativeAds.getViewNativeAd();
                    Log.d(nameLogs, "AdmobNativeAds: 3" );
                } else {
                    Log.d(nameLogs, "AdmobNativeAds: 4" );
                    runAdds_Part2Native_Test();
                }
            } else if (addsFlowNative.get(next).equals(ConstantsAds.APPNEXT)) {
                Log.d(nameLogs, "AppnextNativeAds: 1" );
                if (appnextNativeAds != null && appnextNativeAds.getViewNativeAd() != null) {
                    Log.d(nameLogs, "AppnextNativeAds: 2" );
                    wasShown = true;
                    mChoosenAd = appnextNativeAds.getViewNativeAd();
                    Log.d(nameLogs, "AppnextNativeAds: 3" );
                } else {
                    Log.d(nameLogs, "AppnextNativeAds: 4" );
                    runAdds_Part2Native_Test();
                }
            } else if (addsFlowNative.get(next).equals(ConstantsAds.FACEBOOK)) {
                Log.d(nameLogs, "FacebookNativeAds2: 1" );
                if (facebookNativeAds != null && facebookNativeAds.getViewNativeAd() != null) {
                    Log.d(nameLogs, "FacebookNativeAds2: 2" );
                    wasShown = true;
                    mChoosenAd = facebookNativeAds.getViewNativeAd();
                    Log.d(nameLogs, "FacebookNativeAds2: 3" );
                }
                else {
                    Log.d(nameLogs, "FacebookNativeAds2: 4" );
                    runAdds_Part2Native_Test();
                }
            }
            else {
                Log.d(nameLogs, "NativeAds: none" );
                runAdds_Part2Native_Test();
            }

        }
    }

    public void showAds(final List<String> nFlow, final ViewGroup nContainer) {
        this.nContainer = nContainer;
        mChoosenAd = null;
        next = -1;
        //Log.d(nameLogs, "Native Ads showAds: 1" );
        if (((appnextNativeAds!=null &&appnextNativeAds.getViewNativeAd() != null) ||
                (admobNativeAds!=null && admobNativeAds.getViewNativeAd() != null) ||
                (facebookNativeAds!=null && facebookNativeAds.getViewNativeAd() != null)) &&
                (nFlow != null && nFlow.size() > 0)) {
            Log.d(nameLogs, "Native Ads showAds: 2" );
            addsFlowNative = nFlow;
            Log.d(nameLogs, "Native Ads showAds: 3" );
            runAdds_Part2Native_Test();

            if(mChoosenAd==null){
                Log.d(nameLogs, "Native Ads showAds: mChoosenAd este null" );
            }else if(nContainer==null){
                Log.d(nameLogs, "Native Ads showAds: nContainer este null" );
            }

            Log.d(nameLogs, "Native Ads showAds: 4" );
            if (mChoosenAd!=null && nContainer!=null) {
                nContainer.removeAllViews();
                nContainer.addView(mChoosenAd);
                Log.d(nameLogs, "Native Ads showAds: 5" );
            } else {
                Log.d("loop","nasoale "+ Calendar.getInstance().getTime());
            }
        } else if (nContainer!=null) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showAds(nFlow,nContainer);
                }
            }, 250);
        }
        else {
            Log.d(nameLogs, "Native Ads showAds: 7" );
            Log.d(nameLogs,"nasoale ");
        }



    }


    public void setNameLog(String logName){
        nameLogs = logName;
    }


}
