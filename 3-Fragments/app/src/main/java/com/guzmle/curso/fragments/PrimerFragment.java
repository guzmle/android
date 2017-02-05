package com.guzmle.curso.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Clase que representa la definicion del primer fragmento
 * @author guzmle
 */
public class PrimerFragment extends Fragment {

    public static String TAG = "primerFragment";


    /**
     * Metodo que se ejecuta cuando se crea el view del fragment
     * @param inflater objeto que me permite deserializar el layout
     * @param container contendor padre del fragmento
     * @param savedInstanceState objeto que posee la definicion de instancias anteriores
     * @return vista creada a traves del recurso
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_primer, container, false);

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

        SegundoFragment fragment = new SegundoFragment();

        //Inicializo el gestor de fragmentos
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        FragmentTransaction transaccion = fragmentManager.beginTransaction(); //comienzo la transaccion
        transaccion.replace(R.id.contenedor, fragment, SegundoFragment.TAG ); //Agrego el fragmento al contenedor
        transaccion.addToBackStack(PrimerFragment.TAG);
        transaccion.commit(); // culmino la transaccion

    }

}
