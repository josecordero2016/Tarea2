package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class ActivityResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Bundle b = this.getIntent().getExtras();
        final String valores[] = b.getStringArray("Valores");
        final TextView lblResultado = (TextView)findViewById(R.id.lblResultado);
        //Implementación de volley
        RequestQueue cola = Volley.newRequestQueue(this);
        StringRequest peticion = new StringRequest(Request.Method.GET, "http://uealecpeterson.net/ws/login.php?usr="+valores[0]+"&pass="+valores[1], new Response.Listener<String>() {
            @Override
            public void onResponse(String respuesta_ws) {
                lblResultado.setText(respuesta_ws);
            }
        }, new
                Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError e) {
                        Toast.makeText(getApplicationContext(),"Error, "+e,Toast.LENGTH_LONG).show();;
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        cola.add(peticion);
    }

}