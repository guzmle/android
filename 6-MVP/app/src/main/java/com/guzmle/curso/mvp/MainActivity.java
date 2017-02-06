package com.guzmle.curso.mvp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guzmle.curso.mvp.presentacion.usuario.listar.ListarUsuarioViewImpl;

/**
 * Clase que posee la definicion de la actividad principal de la aplicacion
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment inicio = new ListarUsuarioViewImpl();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaccion = fragmentManager.beginTransaction();
        transaccion.replace(R.id.contenedor, inicio);
        transaccion.addToBackStack(null);
        transaccion.commit();
    }
}
