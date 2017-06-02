package com.softbankrobotics.myapplication.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;

import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.softbankrobotics.myapplication.R;

import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RobotLifecycleCallbacks {

    @BindView(R.id.webview)
    WebView webView;

    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //QiSDK.register(this, this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setSaveFormData(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setAppCacheEnabled(false);
        String url = "https://www.fitbit.com/oauth2/authorize?response_type=token&client_id=228JV3&redirect_uri=http%3A%2F%2Fnovapps.fr&scope=activity%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight&expires_in=604800";
        webView.clearHistory();
        webView.clearCache(true);
        webView.loadUrl(url);

        webView.setWebViewClient(new MyWebViewClient());
    }

    @Override
    public void onRobotFocusGained(QiContext qiContext) throws ExecutionException {
        try{
            /*Topic topic = TopicBuilder.with(qiContext)
                    .withResource(R.raw.intro)
                    .build();

            Discuss startDiscuss = DiscussBuilder.with(qiContext)
                    .withTopic(topic)
                    .build();

            String startDiscussEnd = startDiscuss.run();
            switch (startDiscussEnd) {
                case "oui":
                    yesAction();
                    break;
                case "non":
                    noAction();
                    break;
            }*/
        }catch (Throwable t){
            t.printStackTrace();
            throw t;
        }
    }

    private void yesAction(){
        System.out.println("Oui");
    }

    private void noAction(){
        System.out.println("Non");
    }

    @Override
    public void onRobotFocusLost() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //QiSDK.unregister(this);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("On page started : ", url);
            String[] values = url.split("[=&]");
            if(values.length >= 2){
                token = values[1];
            }
            System.out.println(token);
        }
    }
}
