package com.trispy.core;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    static String loadError = "no error";

    static {
        try {
            System.loadLibrary("trispy");
        } catch (Throwable t) {
            loadError = t.toString();
        }
    }

    public static native String getNativeMessage();
    public static native int getNativeVersion();

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        String msg = "not called";
        String ver = "not called";
        String callErr = "none";

        try {
            msg = getNativeMessage();
            ver = getNativeVersion() + "";
        } catch (Throwable t) {
            callErr = t.toString();
        }

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
        ll.setBackgroundColor(0xFF0A0A0F);

        TextView tv = new TextView(this);
        tv.setText(
            "TRISPY CORE\n\n" +
            "load error: " + loadError + "\n\n" +
            "native msg: " + msg + "\n" +
            "native ver: " + ver + "\n" +
            "call error: " + callErr
        );
        tv.setTextColor(0xFF22C55E);
        tv.setTextSize(16f);
        tv.setPadding(40, 40, 40, 40);
        tv.setGravity(Gravity.CENTER);

        ll.addView(tv);
        setContentView(ll);
    }
}
