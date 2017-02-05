package com.curso.guzmle.activitylifecycle;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Clase que posee la definicion de la actividad
 * @author guzmle
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Metodo que se ejecuta cuando se esta creando la actividad
     * @param savedInstanceState Objeto que posee los datos de la actividad si la misma es relanzada
     *                           de lo contrario es null
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Se asigna el recurso xml a la actividad
    }


    /**
     * Metodo que se ejecuta luego de ejecutar el {@link #onCreate} y luego del {@link #onRestart}
     */
    @Override
    protected void onStart() {
        super.onStart();
        mostrarMensaje("onStart()");
    }


    /**
     * Metodo que se ejecuta luego de ejecutar el {@link #onStart} ya a este punto la actividad esta
     * corriendo, tambien se ejecuta si la aplicacion se encuentraba en segundo plano y regresa a
     * primer plano
     */
    @Override
    protected void onResume() {
        super.onResume();
        mostrarMensaje("onResume()");
    }


    /**
     * Metodo que se ejecuta cuando la actividad pasa a segundo plano o esta parcialmente visible
     */
    @Override
    protected void onPause() {
        super.onPause();
        mostrarMensaje("onPause()");
    }


    /**
     * Metodo que se ejecuta si la aplicacion pasa a primer plano nuevamente luego de estar detenida
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        mostrarMensaje("onRestart()");
    }


    /**
     * Metodo que se ejecuta cuando la actividad pasa a segundo plano y por lo general se ejecuta
     * luego del {@link #onPause}, de aqui puede pasar a primer plano por lo que se ejecutara
     * {@link #onRestart}
     */
    @Override
    protected void onStop() {
        super.onStop();
        mostrarMensaje("onStop()");
    }


    /**
     * Metodo que se ejecuta cuando se cierra la activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mostrarMensaje("onDestroy()");
    }


    /**
     * Metodo que muestra un mensaje corto
     * @param mensaje mesaje que se muestra en la pantalla
     */
    private void mostrarMensaje(String mensaje){
        Toast toast = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
        toast.show();

    }
}
