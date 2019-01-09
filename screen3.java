package com.example.ruchika.gyroscopey;

import android.content.*;
import android.view.*;
import android.app.Activity;
import android.hardware.*;
import android.os.Bundle;
import android.widget.TextView;
import android.net.Uri;

/**
 * Created by Ruchika on 5/14/2016.
 */
public class screen3 extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri webpage = Uri.parse("http://www.maps.google.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
