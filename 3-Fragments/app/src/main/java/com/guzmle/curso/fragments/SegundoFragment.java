package com.guzmle.curso.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Clase que representa la definicion del segundo fragmento
 * @author guzmle
 */
public class SegundoFragment extends Fragment {


    public static String TAG = "segundoFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        return view;
    }


    /**
     * Metodo que se ejecuta cuando el fragmento ya es inicializado
     */
    @Override
    public void onResume() {
        super.onResume();

        Button boton = (Button) getView().findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBotonClickListener(view);
            }
        });
    }


    /**
     * Metodo que gestiona el evento del boton
     * @param view datos del boton
     */
    private void onBotonClickListener(View view){

        TextInputEditText input = (TextInputEditText) getView().findViewById(R.id.input);
        String mensaje = input.getText().toString();


        TercerFragment fragment = new TercerFragment();
        fragment.setMensaje(mensaje);

        //Inicializo el gestor de fragmentos
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        FragmentTransaction transaccion = fragmentManager.beginTransaction(); //comienzo la transaccion
        transaccion.replace(R.id.contenedor, fragment, TercerFragment.TAG ); //Agrego el fragmento al contenedor
        transaccion.addToBackStack(SegundoFragment.TAG);
        transaccion.commit(); // culmino la transaccion

    }
}