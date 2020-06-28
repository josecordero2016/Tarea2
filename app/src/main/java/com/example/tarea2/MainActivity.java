package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.tarea2.Modelos.Bancos;
import com.example.tarea2.interfaz.retrofit_interfaz;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    private EditText txtUsuario, txtContrasena, txtBancosRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Extrayendo los componentes necesarios
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtContrasena=(EditText)findViewById(R.id.txtContrasena);
        txtBancosRetrofit=(EditText)findViewById(R.id.txtBancosRetrofit);

        // Implementación de retrofit
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://api-uat.kushkipagos.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit_interfaz retrofit_interfaz = rf.create(retrofit_interfaz.class);
        Call<List<Bancos>> call = retrofit_interfaz.getPosts();
        call.enqueue(new Callback<List<Bancos>>() {
            @Override
            public void onResponse(Call<List<Bancos>> call, Response<List<Bancos>> response) {
                //Codigo de respuesta a la petición realizada
                String cod_respuesta = "Código "+response.code();
                String valores ="";
                List<Bancos> lista_bancos = response.body();
                //Almacenando en la lista de tipo Bancos cada uno alojado en el JSON
                for(Bancos banco: lista_bancos){
                    valores+=banco.getName()+"\n";
                }
                //Colocando los bancos extraídos al EditText
                txtBancosRetrofit.setText(valores);
            }

            @Override
            public void onFailure(Call<List<Bancos>> call, Throwable t) {

            }
        });
    }

    public void btnAcceder_Onclick(View view){
        Intent intent = new Intent(MainActivity.this,ActivityResultado.class);
        Bundle b = new Bundle();
        String valores[] = {txtUsuario.getText().toString(),txtContrasena.getText().toString()};
        b.putStringArray("Valores",valores);
        intent.putExtras(b);
        startActivity(intent);
    }


}