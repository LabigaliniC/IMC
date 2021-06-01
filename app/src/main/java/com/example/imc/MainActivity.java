package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "com.example.imc.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private static final String RESULT_VISIBLE = "RESULT_VISIBLE";
    private TextView showWeight;
    private TextView showHeight;
    private TextView showImc;
    private TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG, "onCreate: -----------------");
        Log.d(TAG, "onCreate: Iniciou");

        TextView showWeight = findViewById(R.id.showWeight);
        TextView showHeight = findViewById(R.id.showHeight);
        TextView showIMC = findViewById(R.id.showIMC);
        TextView showSituation = findViewById(R.id.showSituation);

        Intent intent = getIntent();
        double weight    = intent.getDoubleExtra(secondActivity.EXTRA_WEIGHT, 0);
        double height    = intent.getDoubleExtra(secondActivity.EXTRA_HEIGHT, 0);
        double imc       = intent.getDoubleExtra(secondActivity.EXTRA_IMC, 0);
        String resultImc = intent.getStringExtra(secondActivity.EXTRA_RESULT_IMC);
        String imcFormat = new DecimalFormat("##0.00").format(imc);

        showWeight.setText(Double.toString(weight));
        showHeight.setText(Double.toString(height));
        showIMC.setText(Double.toString(Double.parseDouble(imcFormat)));
        showSituation.setText(resultImc);

        if(savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean(RESULT_VISIBLE);
            if (isVisible){
                showWeight.setVisibility(View.VISIBLE);
                showHeight.setVisibility(View.VISIBLE);
                showIMC.setVisibility(View.VISIBLE);
                showSituation.setVisibility(View.VISIBLE);

            }
        }
    }


    public void launchSecondActivity(View view) {
        Log.d(TAG, "launchSecondActivity: Botão pressionado");
        Intent intent = new Intent(this, secondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
        finish();



    }
}