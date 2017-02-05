package com.guzmle.curso.controls;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que posee la definicion del fragmento que muestra los text fields
 *
 * @author guzmle
 */
public class TextFieldsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_textfields, container, false);

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


        AutoCompleteTextView autoComplete = (AutoCompleteTextView) getView().findViewById(R.id.autocompletar);

        List<String> opciones = new ArrayList<>();
        opciones.add("Uno");
        opciones.add("Dos");
        opciones.add("Tres");
        opciones.add("Cuatro");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, opciones);
        autoComplete.setAdapter(adaptador);

        EditText textboxImeAction = (EditText) getView().findViewById(R.id.editActionIme);


        //Asigno el evento del boton enter al textbox
        textboxImeAction.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                boolean retorno = false;

                if (id == EditorInfo.IME_ACTION_SEND) {

                    String textoIngresado = textView.getText().toString();
                    String mensaje = "Accion del boton enter del teclado " + textoIngresado;
                    Toast toast = Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT);
                    toast.show();
                    retorno = true;
                }

                return retorno;
            }
        });
    }
}
