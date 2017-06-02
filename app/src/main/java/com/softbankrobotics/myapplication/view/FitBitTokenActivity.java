package com.softbankrobotics.myapplication.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.softbankrobotics.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by henri.lequintrec on 02/06/17.
 */

public class FitBitTokenActivity extends BasicActivity {

    @BindView(R.id.webview)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.token);
        ButterKnife.bind(this);
        webView.setWebViewClient(new CustomWebViewClient());
        webView.loadUrl(getString(R.string.fitbit_auth_url));
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();
    }

    private class CustomWebViewClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("On page started : ", url);
            if(url.startsWith(getString(R.string.fitbit_callback_url))){
                webView.setVisibility(View.INVISIBLE);
                String[] values = url.split("[=&]");
                String token;
                if(values.length >= 2){
                    token = values[1];
                    getRobotApp().setFitBitToken(token);
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
