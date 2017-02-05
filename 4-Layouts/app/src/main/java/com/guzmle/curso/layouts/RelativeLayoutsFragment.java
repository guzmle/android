package com.guzmle.curso.layouts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Clase que posee la defincion de la vista que muestra el RelativeLayout
 */
public class RelativeLayoutsFragment extends Fragment
{


    /**
     * Metodo que se ejecuta cuando se crea el view del fragment
     * @param inflater objeto que me permite deserializar el layout
     * @param container contendor padre del fragmento
     * @param savedInstanceState objeto que posee la definicion de instancias anteriores
     * @return vista creada a traves del recurso
     */
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        View view = inflater.inflate( R.layout.layout_relative, container, false );
        return view;
    }
}
