package com.guzmle.curso.layouts;

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
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que posee la definicion del fragmento inicial
 */
public class ListaFragment extends Fragment{


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

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }


    /**
     * Metodo que se ejecuta luego que la vista se ha inicializado
     */
    @Override
    public void onResume() {
        super.onResume();

        List<String> datos = new ArrayList<>();
        datos.add("Linear Layout");
        datos.add("Table Layout");
        datos.add("Grid Layout");
        datos.add("Relative Layout");
        datos.add("Frame Layout");

        ListView lista = (ListView) getView().findViewById(R.id.lista);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, datos);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0:
                        navegar(new LinearLayoutsFragment());
                        break;
                    case 1:
                        navegar(new TableLayoutsFragment());
                        break;
                    case 2:
                        navegar(new GridLayoutsFragment());
                        break;
                    case 3:
                        navegar(new RelativeLayoutsFragment());
                        break;
                    case 4:
                        navegar(new FrameLayoutsFragment());
                        break;
                    default:
                        navegar(new ListaFragment());

                }

            }
        });
    }


    /**
     * Metodo que posee la logica de navegacion
     * @param fragment fragmento a navegar
     */
    public void navegar(Fragment fragment)
    {
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        FragmentTransaction transaccion = fragmentManager.beginTransaction();
        transaccion.replace(R.id.contenedor, fragment);
        transaccion.addToBackStack(null);
        transaccion.commit();

    }
}
