package com.guzmle.curso.controls;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Clase que posee la definicion del fragmento que muestra los checkbox
 *
 * @author guzmle
 */
public class CheckBoxFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_checks, container, false);

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

                CheckBox leche = (CheckBox) getView().findViewById(R.id.leche);
                CheckBox huevos = (CheckBox) getView().findViewById(R.id.huevos);
                CheckBox azucar = (CheckBox) getView().findViewById(R.id.azucar);
                String mensaje = "Leche: " + leche.isChecked();
                mensaje += "\nEs Huevos: " + huevos.isChecked();
                mensaje += "\nEs Azucar: " + azucar.isChecked();
                Toast toast = Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
