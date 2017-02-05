package com.guzmle.curso.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


/**
 * clase que representa la actividad principal de la aplicacion
 *
 * @author guzmle
 */
public class MainActivity extends AppCompatActivity {


    /**
     * Metodo que se ejecuta cuando se inicializa la actividad
     *
     * @param savedInstanceState objeto que posee la definicion de instancias anteriores
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Metodo que se ejecuta luego de inicializado la actividad
     */
    @Override
    public void onResume() {
        super.onResume();


        //Inicializo el fragmento
        PrimerFragment fragment = new PrimerFragment();

        //Inicializo el gestor de fragmentos
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaccion = fragmentManager.beginTransaction(); //comienzo la transaccion
        transaccion.replace(R.id.contenedor, fragment, PrimerFragment.TAG); //Agrego el fragmento al contenedor
        transaccion.commit(); // culmino la transaccion
    }


    /**
     * Metodo que sobre escribe el evento cuando se da click al boton atras del dispositivo
     */
    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() > 0) //Si existe aunque sea un fragmento en la pila
            getFragmentManager().popBackStack(PrimerFragment.TAG, -1);
        else
            super.onBackPressed();
    }

}
