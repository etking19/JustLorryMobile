package com.justsupplychain.justlorrymobile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.justsupplychain.justlorrymobile.constants.Constant;

import static android.webkit.URLUtil.isNetworkUrl;
import static com.justsupplychain.justlorrymobile.R.id.webview;

public class MainActivity extends AppCompatActivity {

    private WebView _webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String oneSignalId = getIntent().getStringExtra(Constant.ONE_SIGNAL);

        _webView = (WebView) findViewById(webview);
        _webView.clearCache(true);
        WebSettings webSettings = _webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        _webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                //show webview
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        _webView.setVisibility(View.VISIBLE);
                    }
                }, 1000);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if( isNetworkUrl(url) ) {
                    return false;
                }

                // Otherwise allow the OS to handle it
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity( intent );
                return true;
            }
        });

        _webView.addJavascriptInterface(new WebAppInterface(this), "Android");

        Log.d("signal id", oneSignalId);
        _webView.loadUrl("https://m.justlorry.com/?identifier=" + oneSignalId);
        //webview.loadUrl("http://52.40.249.160/?identifier=" + oneSignalId);
        //webview.loadUrl("http://52.40.249.160/mobile/?identifier=" + oneSignalId);
    }
}
