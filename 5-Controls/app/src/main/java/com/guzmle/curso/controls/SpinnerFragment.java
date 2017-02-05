package com.guzmle.curso.controls;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que posee la definicion del fragmento que muestra los Spinners
 *
 * @author guzmle
 */
public class SpinnerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_spinners, container, false);

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


        Spinner spinnerProgramado = (Spinner) getView().findViewById(R.id.spinnerProgramado);

        List<String> opciones = new ArrayList<>();
        opciones.add("Uno");
        opciones.add("Dos");
        opciones.add("Tres");
        opciones.add("Cuatro");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, opciones);
        spinnerProgramado.setAdapter(adaptador);
        spinnerProgramado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String dato = (String) adapterView.getItemAtPosition(i);
                String mensaje = "Seleccionado la opcion " + dato;
                Toast toast = Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        Spinner spinnerRecurso = (Spinner) getView().findViewById(R.id.spinnerRecurso);
        ArrayAdapter<CharSequence> adaptadorRecurso = ArrayAdapter.createFromResource(getActivity(),
                R.array.nombres, android.R.layout.simple_spinner_item);
        adaptadorRecurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRecurso.setAdapter(adaptadorRecurso);



        Spinner spinnerDialog = (Spinner) getView().findViewById(R.id.spinnerDialog);
        ArrayAdapter<String> adaptadorDialog = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, opciones);
        spinnerDialog.setAdapter(adaptadorDialog);

    }
}
