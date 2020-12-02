package com.example.juego21cartas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyCartas;
    private TextView txtSuma;
    public int numero=0;
    public int suma=0;
    private RequestQueue requestQueue;
    private VolleyS myVolley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyCartas = findViewById(R.id.recyCartas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyCartas.setLayoutManager(layoutManager);

        myVolley=VolleyS.getInstance(this.getApplicationContext());
        requestQueue=myVolley.getRequestQueue();

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);

        TextView sumaTotal = findViewById(R.id.txtNum);
}
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                String url = "https://ramiro174.com/api/numero";
                JsonObjectRequest objReqNumeros = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (suma <= 21) {
                            try {
                                numero = response.getInt("numero");
                                suma = suma + numero;
                                txtSuma.setText(String.valueOf(suma));

                                List<Carta> listCartas = new ArrayList<>();
                                listCartas.add(new Carta(numero));
                                Adapter adapterCartas = new Adapter(listCartas);
                                recyCartas.setAdapter(adapterCartas);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("tag", "onErrorResponse: " + error.getMessage());
                    }
                });
                requestQueue.add(objReqNumeros);
                break;
            case R.id.btn2:
                String url2 = "https://ramiro174.com/api/enviar/numero";
                JSONObject objNums = new JSONObject();
                try {
                    objNums.put("nombre", "Nayeli Esquivel");
                    objNums.put("numero", suma);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest objReqPuntaje = new JsonObjectRequest(Request.Method.POST, url2, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("tag", "onErrorResponse: " + error.getMessage());
                    }
                });
                requestQueue.add(objReqPuntaje);
                Toast.makeText(getApplicationContext(), "Resultados enviados!", Toast.LENGTH_LONG).show();
                txtSuma.setText("0");
                numero = 0;
                suma = 0;
                break;
            case R.id.btn3:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ramiro174.com/resultados"));
                startActivity(intent);
                break;
            case R.id.btn4:
                txtSuma.setText("0");
                numero = 0;
                suma = 0;
                break;
        }
    }
}
