package com.justsupplychain.justlorrymobile;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by Denell Wong on 12/10/2016.
 */

public class WebAppInterface {
    Context mContext;

    WebAppInterface(Context c){
        this.mContext = c;
    }

    @JavascriptInterface
    public void StartGpsTracking(String userId){
        //TODO: start send tracking to server
        Log.d("test", "tracking start: " + userId);
    }
}
