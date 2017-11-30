package com.example.extermination.suben;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    private String rawMail;
    private String rawPass;
    Boolean mailOK;
    Boolean passOK;
    EditText inMail;
    EditText inPass;
    EditText inName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inMail = (EditText) findViewById(R.id.etinMail);
        inPass = (EditText) findViewById(R.id.etinPass);
        inName = (EditText) findViewById(R.id.etinName);
    }

    public void validate(View v) {
        rawMail = inMail.getText().toString();
        rawPass = inPass.getText().toString();
        Boolean valido = true;
        //Recorrer lista de mails
        if (rawMail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(rawMail).matches()) {
            inMail.setError("Ingresa un correo electrónico válido");
            valido = false;
        } else {
            inMail.setError(null);
            //Toast.makeText(getApplicationContext(),"Mail: "+rawMail+" correcto", Toast.LENGTH_LONG).show();
        }
        if (rawPass.isEmpty() || rawPass.length() < 6 || rawPass.length() > 16) {
            inPass.setError("Ingrese entre 6 y 10 carácteres alfanuméricos");
            valido = false;
        } else {
            inPass.setError(null);
            //Toast.makeText(getApplicationContext(),"Pass: "+rawPass+" correctow", Toast.LENGTH_LONG).show();
        }
        if (valido == true){
                continualog();  }
    }

    public void continualog(){
        Intent avanza = new Intent(this, SelectorRuta.class);
        startActivity(avanza);
    }

}
