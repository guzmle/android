package com.guzmle.curso.activityIntents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Clase que posee la definicion de la actividad principal de la aplicacion
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Metodo que se ejecuta cuando se crea la actividad
     * @param savedInstanceState objeto que posee estado almacenado
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Metodo que se ejecuta luego que la actividad es inicializada
     */
    @Override
    protected void onResume() {
        super.onResume();

        //Obtengo la instancia del boton con el objetivo de manejarlo
        Button button = (Button) findViewById(R.id.boton);

        //Asigno el evento del boton a un metodo que se encargue de gestionar el mismo
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBotonClickListener(view );
            }
        });

    }


    /**
     * Metodo que gestiona el evento click del boton
     * @param view datos del boton
     */
    private void onBotonClickListener(View view){

        //Creo el intento que se posee la informacion de la actividad destino para que android
        //lo coloque en el primer plano
        Intent intento = new Intent(this, DosActivity.class);
        startActivity(intento);
    }
}
