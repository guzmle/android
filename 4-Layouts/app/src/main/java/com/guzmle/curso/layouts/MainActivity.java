package com.guzmle.curso.layouts;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navegar(new ListaFragment());
    }

    /**
     * Metodo que posee la logica de navegacion
     * @param fragment fragmento a navegar
     */
    public void navegar(Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaccion = fragmentManager.beginTransaction();
        transaccion.replace(R.id.contenedor, fragment);
        transaccion.addToBackStack(null);
        transaccion.commit();

    }
}
