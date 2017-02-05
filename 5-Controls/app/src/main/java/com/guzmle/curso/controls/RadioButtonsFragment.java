package com.guzmle.curso.controls;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que posee la definicion del fragmento que muestra los Spinners
 *
 * @author guzmle
 */
public class RadioButtonsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_radios, container, false);

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

                RadioButton femenino = (RadioButton) getView().findViewById(R.id.mujer);
                RadioButton casado = (RadioButton) getView().findViewById(R.id.casado);
                String mensaje = "Es Femenino: " + femenino.isChecked();
                mensaje += "\nEs Casado: " + casado.isChecked();
                Toast toast = Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
