package com.example.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private Sensor sensor;
    private SensorManager sensorManager;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflamos la vista de los textos
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        // Se crea el administrador del sensor
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Se crea el sensor y el tipo de sensor, que en este caso es el acelerometro
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Se define que se escuche y la velocidad de escucha
        sensorManager.registerListener(this, sensor, sensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textView.setText("X = " + sensorEvent.values[0]);
        textView2.setText("Y = " + sensorEvent.values[1]);
        textView3.setText("Z " + sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}