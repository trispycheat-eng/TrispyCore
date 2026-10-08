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

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
        ll.setBackgroundColor(0xFF0A0A0F);

        TextView tv = new TextView(this);
        tv.setText("TRISPY v3\n\n" +
                   "load: " + loadError + "\n\n" +
                   "if loaded inside FF:\n" +
                   "  → /sdcard/trispy_dump.txt");
        tv.setTextColor(0xFF22C55E);
        tv.setTextSize(16f);
        tv.setPadding(40, 40, 40, 40);
        tv.setGravity(Gravity.CENTER);

        ll.addView(tv);
        setContentView(ll);
    }
}
