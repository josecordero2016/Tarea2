package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Bundle b = this.getIntent().getExtras();
        String valores[] = b.getStringArray("Valores");
        TextView lblResultado = (TextView) findViewById(R.id.lblResultado);
        lblResultado.setText(valores[0]);
    }

}