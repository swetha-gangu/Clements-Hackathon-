package com.example.ruchika.gyroscopey;
import android.app.Activity;
import android.hardware.*;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import android.content.*;
import android.view.*;

import java.io.IOException;

public class MyActivity extends Activity implements SensorEventListener{
        private SensorManager mgr;
        private Sensor gyro;
        private MediaPlayer mp;
        Context context=this;

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my);
            mgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);
            gyro = mgr.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
            mp = MediaPlayer.create(context, R.raw.beepy);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    mp.release();

                };
            });
        }

        @Override
        protected void onResume() {
            mgr.registerListener(this, gyro, SensorManager.SENSOR_DELAY_GAME);
            super.onResume();
        }

        @Override
        protected void onPause() {
            mgr.unregisterListener(this, gyro);
            super.onPause();
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        public void onSensorChanged(SensorEvent event) {
            if (event.values[0] > 0.1 || event.values[1] > 0.1 || event.values[2] > 0.1 &&!mp.isPlaying()) {
                mp.start();
            }
            else {
                if (mp.isPlaying())
                    mp.stop();
                mp.release();
                mp=MediaPlayer.create(context, R.raw.beepy);
            }
        }
        public void screen2(View v){
            startActivity(new Intent(MyActivity.this, screen2.class));
        }

        public void screen3(View v){
            startActivity(new Intent(MyActivity.this, screen3.class));
        }
    }