package com.guzmle.curso.activityIntents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Clase que posee la definicion de la segunda actividad
 */
public class DosActivity extends AppCompatActivity {

    /**
     * Metodo que se ejecuta cuando se crea la actividad
     * @param savedInstanceState objeto que posee estado almacenado
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);
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

        //Extraigo el valor ingresado por el usuario en textbox
        TextInputEditText input = (TextInputEditText) findViewById(R.id.input);
        String mensaje = input.getText().toString();

        //Creo el intento que se posee la informacion de la actividad destino para que android
        //lo coloque en el primer plano
        Intent intento = new Intent(this, TresActivity.class);

        //Coloco el mensaje para que la proxima activdad lo extraiga
        intento.putExtra("mensaje", mensaje);


        //inicio la actividad
        startActivity(intento);
    }
}
