package vipul.com.webview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends ActionBarActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.yahoo.com");

    }
}
