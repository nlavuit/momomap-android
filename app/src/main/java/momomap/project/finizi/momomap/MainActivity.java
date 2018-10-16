package momomap.project.finizi.momomap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //WebView wv = new WebView(this);
        wv = (WebView) findViewById(R.id.webView);
        wv.loadUrl("https://momo.finizi.vn");
        //wv.loadUrl("https://www.google.com/maps");
        //setContentView(wv);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        }, 0);

        wv.getSettings().setJavaScriptEnabled(true);

        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });

        final Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                wv.loadUrl("https://momo.finizi.vn");
            }
        });

        final Button btnGuide = (Button) findViewById(R.id.btnGuide);
        btnGuide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                wv.loadUrl("https://momo.finizi.vn/guide");
            }
        });

        final Button btnInstruction = (Button) findViewById(R.id.btnInstruction);
        btnInstruction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                wv.loadUrl("https://momo.finizi.vn/instruction");
            }
        });
    }
}
