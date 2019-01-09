package com.example.ruchika.gyroscopey;

import android.content.*;
import android.view.*;
import android.app.Activity;
import android.hardware.*;
import android.os.Bundle;
import android.widget.TextView;
import android.net.Uri;

public class screen2 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri number = Uri.parse("tel:911");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}