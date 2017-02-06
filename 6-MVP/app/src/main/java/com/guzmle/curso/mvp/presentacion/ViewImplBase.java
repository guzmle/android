package com.guzmle.curso.mvp.presentacion;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.widget.Toast;

import com.guzmle.curso.mvp.R;

/**
 * Clase que hace de vista base
 */
public class ViewImplBase extends Fragment {

    /**
     * Metodo que se encarga de mostrar un mensaje de error
     * @param mensaje mensaje a mostrar
     */
    public void mostrarMensajeError(String mensaje){

        Toast toast = Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT);
        toast.show();
    }


    /**
     * Metodo que se encarga de mostrar un fragmento
     * @param fragment datos del fragmento a mostrar
     */
    public void navegar(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        FragmentTransaction transaccion = fragmentManager.beginTransaction();
        transaccion.replace(R.id.contenedor, fragment);
        transaccion.addToBackStack(null);
        transaccion.commit();
    }


    /**
     * Metodo que se encarga de mostrar un mensaje de exito
     * @param mensaje mensaje a mostrar
     */
    public void mostrarMensajeExito(String mensaje){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(mensaje);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                getActivity().getFragmentManager().popBackStack();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
