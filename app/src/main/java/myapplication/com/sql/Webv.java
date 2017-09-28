package myapplication.com.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class Webv extends AppCompatActivity implements View.OnClickListener {
    private EditText text;
    private AppCompatButton submit;
    private String input;
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        init();
    }
    public void init(){
        text=(EditText)findViewById(R.id.txt);
        submit=(AppCompatButton)findViewById(R.id.sub);
        web=(WebView)findViewById(R.id.web);
        web.setWebViewClient(new MyBrowser());
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        input=text.getText().toString();
        web.getSettings().setLoadsImagesAutomatically(true);
        web.getSettings().setJavaScriptEnabled(true);
        web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web.loadUrl(input);

    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(input);
            return true;
        }
    }
}
