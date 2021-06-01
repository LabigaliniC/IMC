package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class secondActivity extends AppCompatActivity {

    public static final String EXTRA_IMC = "com.example.imc.imc;";
    public static final String EXTRA_WEIGHT = "com.example.imc.peso;";
    public static final String EXTRA_HEIGHT = "com.example.imc.altura;";
    public static final String EXTRA_RESULT_IMC = "com.example.imc.resultImc;";

    private EditText editWeight;
    private EditText editHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.editWeight);
    }

    public void calculateIMC(View view) {
        double peso = Double.parseDouble(editWeight.getText().toString());
        double altura = Double.parseDouble(editHeight.getText().toString());
        double imc;

        imc = peso / (altura * altura);

        String resultImc;
        if (imc < 17) resultImc = "Muito abaixo do peso";
        else if (imc < 18.50) resultImc = "Abaixo do peso";
        else if (imc < 25) resultImc = "Peso Normal";
        else if (imc < 30) resultImc = "Acima do Peso";
        else if (imc < 35) resultImc = "Obesidade I";
        else if (imc < 40) resultImc = "Obesidade II (severa)";
        else resultImc = "Obesidade III (mórbida)";


        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_HEIGHT, altura);
        intent.putExtra(EXTRA_WEIGHT, peso);
        intent.putExtra(EXTRA_IMC, imc);
        intent.putExtra(EXTRA_RESULT_IMC, resultImc);
        startActivity(intent);
    }

}

