package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText txtUsuario, txtContrasena;
    private RadioButton rbRetrofit, rbVolley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtContrasena=(EditText)findViewById(R.id.txtContrasena);
        rbRetrofit=(RadioButton)findViewById(R.id.rbRetrofit);
        rbVolley=(RadioButton)findViewById(R.id.rbVolley);
    }

    public void btnAcceder_Onclick(View view){
        if(rbRetrofit.isChecked()){
            Toast.makeText(this,"Retrofit seleccionado",Toast.LENGTH_LONG).show();
        }
        else if(rbVolley.isChecked()){
            Toast.makeText(this,"Volley seleccionado",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Seleccione Retrofit o Volley",Toast.LENGTH_LONG).show();
        }
    }


}