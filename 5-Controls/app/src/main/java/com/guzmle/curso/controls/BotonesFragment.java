package com.guzmle.curso.controls;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que posee la definicion del fragmento principal
 *
 * @author guzmle
 */
public class BotonesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_botones, container, false);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        inicializacion();
    }


    /**
     * Metodo que se encarga de la inicializacion de los componentes de la vista
     */
    private void inicializacion(){

        Button boton = (Button) getView().findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje = "Presionado el boton simple";
                Toast toast = Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        ImageButton botonImagen = (ImageButton) getView().findViewById(R.id.botonImagen);
        botonImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje = "Presionado el boton con imagen";
                Toast toast = Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        Button botonImagenTexto = (Button) getView().findViewById(R.id.botonImagenTexto);
        botonImagenTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje = "Presionado el boton con imagen y con texto";
                Toast toast = Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        Button botonImagenTexto2 = (Button) getView().findViewById(R.id.botonImagenTexto2);
        botonImagenTexto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje = "Presionado el boton con imagen y con texto 2";
                Toast toast = Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        Button botonSinBorde = (Button) getView().findViewById(R.id.botonSinBorde);
        botonSinBorde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje = "Presionado el boton sin bordes";
                Toast toast = Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
