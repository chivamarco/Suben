package com.example.extermination.suben;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button registro = (Button)findViewById(R.id.btnregistro);
        Button fastforward = (Button)findViewById(R.id.button);
    }

    public void avanzar(View view){
        Intent avanza = new Intent(this, LoginActivity2.class);
        startActivity(avanza);
    }
    public void borrame(View view){
        Intent avanza = new Intent(this, MapActivity.class);
        startActivity(avanza);
    }
}
