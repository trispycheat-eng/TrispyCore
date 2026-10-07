package com.trispy.core;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    static {
        System.loadLibrary("trispy");
    }

    public static native String getNativeMessage();
    public static native int getNativeVersion();

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        String msg = getNativeMessage();
        int ver = getNativeVersion();

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
        ll.setBackgroundColor(0xFF0A0A0F);

        TextView tv = new TextView(this);
        tv.setText("TRISPY CORE\n\n" +
                   "native says: " + msg + "\n" +
                   "version: v" + (ver / 100) + "." + (ver % 100) + "\n\n" +
                   "libtrispy.so loaded ✓");
        tv.setTextColor(0xFF22C55E);
        tv.setTextSize(20f);
        tv.setGravity(Gravity.CENTER);

        ll.addView(tv);
        setContentView(ll);
    }
}
