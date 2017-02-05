package com.guzmle.curso.controls;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que posee la definicion del fragmento principal
 *
 * @author guzmle
 */
public class PrincipalFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        List<String> opciones = new ArrayList<>();
        opciones.add("Botones");
        opciones.add("TextFields");
        opciones.add("Spinners");
        opciones.add("RadioButtons");
        opciones.add("CheckBox");
        opciones.add("Otros");

        ListView lista = (ListView) getView().findViewById(R.id.lista);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, opciones);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: navegar(new BotonesFragment()); break;
                    case 1: navegar(new TextFieldsFragment()); break;
                    case 2: navegar(new SpinnerFragment()); break;
                    case 3: navegar(new RadioButtonsFragment()); break;
                    case 4: navegar(new CheckBoxFragment()); break;
                    case 5: navegar(new OtrosFragment()); break;

                    default: navegar(new PrincipalFragment()); break;

                }
            }
        });
    }


    /**
     * Metodo que se encarga de navegar entre fragmentos
     * @param fragment fragmento a navegar
     */
    private void navegar(Fragment fragment){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaccion = fragmentManager.beginTransaction();
        transaccion.replace(R.id.contenedor, fragment);
        transaccion.addToBackStack(null);
        transaccion.commit();

    }
}
