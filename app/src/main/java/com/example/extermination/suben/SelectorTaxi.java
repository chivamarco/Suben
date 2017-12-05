package com.example.extermination.suben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class SelectorTaxi extends AppCompatActivity{
    private static final String URL_TAXIS = "http://10.0.0.6/android_login_api/RutasApp/GetTaxis.php";

    List<Taxis> listaRutas;
    RecyclerView recyclerView;
    int idrsel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_taxi);
        TextView TVSel = (TextView)findViewById(R.id.rutasel);
        recyclerView = (RecyclerView) findViewById(R.id.recylcerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        listaRutas = new ArrayList<>();
        cargarRutas();


    }


    private void cargarRutas() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        * */

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_TAXIS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);
                            Log.e("e", response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject ruta = array.getJSONObject(i);

                                //adding the product to product list
                                listaRutas.add(new Taxis(
                                        ruta.getInt("IDtaxista"),
                                        ruta.getString("nombre"),
                                        ruta.getString("telefono"),
                                        ruta.getInt("Activo")


                                ));
                            }

                            //creating adapter object and setting it to recyclerview

                            AdapterTaxi adapter = new AdapterTaxi(SelectorTaxi.this, listaRutas);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }





}
