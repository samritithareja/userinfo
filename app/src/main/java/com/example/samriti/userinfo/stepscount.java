package com.example.samriti.userinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class stepscount extends AppCompatActivity implements SensorEventListener{

        private SensorManager mSensorManager;
        private Sensor mSensor;
        private boolean isSensorPresent = false;
        private TextView mStepsSinceReboot;
        private TextView mCaloriesBurntSinceReboot;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_stepscount);

            ImageView imageView =
                    (ImageView)findViewById(R.id.img);
            final AnimationDrawable myAnim = (AnimationDrawable)imageView.getDrawable();
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myAnim.start();
                }
            });
            mStepsSinceReboot = (TextView) findViewById(R.id.stepssincereboot);
            mCaloriesBurntSinceReboot = (TextView) findViewById(R.id.caloriesburntsincereboot);

            mSensorManager = (SensorManager)
                    this.getSystemService(Context.SENSOR_SERVICE);
            if (mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
                    != null) {
                mSensor =
                        mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
                isSensorPresent = true;
            } else {
                isSensorPresent = false;
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Aw Snap!");
                alertDialogBuilder.setMessage("Step detector/counter sensor not present!");

                alertDialogBuilder.setNeutralButton("Proceed Anyway", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                alertDialogBuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        }

        @Override
        protected void onResume() {
            super.onResume();
            if (isSensorPresent) {
                mSensorManager.registerListener((SensorEventListener) this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }

        @Override
        protected void onPause() {
            super.onPause();
            if (isSensorPresent) {
                mSensorManager.unregisterListener(this);
            }
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            String unit;
            String rawcount = String.valueOf(event.values[0]);
            String actualcount=rawcount.substring(0, rawcount.length()-2);
            float calculatecalories = Float.parseFloat(actualcount)/20; //Algo by Shape Up America!
            String finalcaloriesburnt = String.valueOf(calculatecalories);
            mStepsSinceReboot.setText("Steps: " + actualcount);
            if(calculatecalories<=1000){
                unit = " cal";
            }
            else{
                unit = " kcal";
            }
            mCaloriesBurntSinceReboot.setText("Calories burnt: " + finalcaloriesburnt + unit);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }