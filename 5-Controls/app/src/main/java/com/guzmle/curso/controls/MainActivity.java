package com.guzmle.curso.controls;

import android.app.FragmentTransaction;
import android.media.Image;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * Clase que posee la definicion de la actividad principal
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrincipalFragment fragment = new PrincipalFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaccion = fragmentManager.beginTransaction();
        transaccion.replace(R.id.contenedor, fragment);
        transaccion.addToBackStack(null);
        transaccion.commit();

    }
}
