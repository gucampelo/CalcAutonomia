package com.estudo.calcautonomia;

import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inConsumoMedio;
    private EditText inLitrosTanque;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inConsumoMedio = findViewById(R.id.inConsumoMedio);
        inConsumoMedio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        inLitrosTanque = findViewById(R.id.inLitrosTanque);
        inLitrosTanque.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtRes = findViewById(R.id.txtRes);
        txtRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());

    }

    private void calc(){
        float inCons = Float.parseFloat(inConsumoMedio.getText().toString());
        float inLitros = Float.parseFloat(inLitrosTanque.getText().toString());

        double autonomiaKm = inCons * inLitros;
        double autonomiaMetros = autonomiaKm * 1000;
        String res = "A autonomia do automóvel é de " + autonomiaMetros + " metros";
        txtRes.setText(res);

    }
}