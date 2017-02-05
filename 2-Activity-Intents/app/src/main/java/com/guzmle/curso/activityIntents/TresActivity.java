package com.guzmle.curso.activityIntents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Clase que posee la definicion de la segunda actividad
 */
public class TresActivity extends AppCompatActivity {

    /**
     * Metodo que se ejecuta cuando se crea la actividad
     * @param savedInstanceState objeto que posee estado almacenado
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres);
    }



    /**
     * Metodo que se ejecuta luego que la actividad es inicializada
     */
    @Override
    protected void onResume() {
        super.onResume();

        Intent intento = getIntent();
        Bundle extras = intento.getExtras();
        String mensaje = (String) extras.get("mensaje");

        //Obtengo la instancia del label con el objetivo de mostrar el mensaje enviado por la actividad
        //anterior
        TextView textView = (TextView) findViewById(R.id.label);
        textView.setText(mensaje);


    }

}
