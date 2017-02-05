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
import android.widget.TextView;

/**
 * Clase que representa el tercer fragmento
 * @author guzmle
 */
public class TercerFragment extends Fragment {

    public static String TAG = "tercerFragment";
    private String mensaje;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tercero, container, false);

        return view;
    }


    /**
     * Metodo que se ejecuta cuando el fragmento ya es inicializado
     */
    @Override
    public void onResume() {
        super.onResume();

        TextView label = (TextView) getView().findViewById(R.id.label);
        label.setText(mensaje);


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

        getActivity().getFragmentManager().popBackStack(SegundoFragment.TAG,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}