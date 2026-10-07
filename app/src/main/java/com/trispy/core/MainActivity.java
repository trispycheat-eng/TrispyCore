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

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
        ll.setBackgroundColor(0xFF0A0A0F);

        TextView tv = new TextView(this);
        tv.setText("TRISPY CORE\n\nlibtrispy.so loaded");
        tv.setTextColor(0xFF22C55E);
        tv.setTextSize(22f);
        tv.setGravity(Gravity.CENTER);

        ll.addView(tv);
        setContentView(ll);
    }
}
