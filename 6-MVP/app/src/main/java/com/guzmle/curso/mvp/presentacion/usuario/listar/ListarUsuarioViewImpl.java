package com.guzmle.curso.mvp.presentacion.usuario.listar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.guzmle.curso.mvp.R;
import com.guzmle.curso.mvp.dominio.Usuario;
import com.guzmle.curso.mvp.presentacion.ViewImplBase;
import com.guzmle.curso.mvp.presentacion.usuario.agregar.AgregarUsuarioViewImpl;
import com.guzmle.curso.mvp.presentacion.usuario.modificar.ModificarUsuarioViewImpl;

import java.util.List;

/**
 * Clase que implementa el contrato de la vista que se encarga de listar los usuarios
 */
public class ListarUsuarioViewImpl extends ViewImplBase implements ListarUsuarioView {

    ListarUsuarioPresentador presentador;
    private int positionSelected;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_usuarios_listar, container, false);
        presentador = new ListarUsuarioPresentador(this);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        presentador.init();
    }


    @Override
    public void inicializacion(){

        final ListView lista = (ListView) getView().findViewById(R.id.lista);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                positionSelected = i;
                presentador.irModificarUsuario();
            }
        });

        FloatingActionButton boton = (FloatingActionButton) getView().findViewById(R.id.floatBoton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navegar(new AgregarUsuarioViewImpl());
            }
        });

    }


    @Override
    public void setUsuarios(List<Usuario> usuarios) {

        ListView lista = (ListView) getView().findViewById(R.id.lista);
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(getActivity(),
                android.R.layout.simple_list_item_1, usuarios);
        lista.setAdapter(adapter);

    }


    @Override
    public Usuario getUsuarioSeleccionado() {
        ListView lista = (ListView) getView().findViewById(R.id.lista);
        Usuario usuario = (Usuario) lista.getItemAtPosition(positionSelected);

        return usuario;
    }


    @Override
    public void navegarModificarUsuario(Usuario usuario) {
        navegar(new ModificarUsuarioViewImpl());

    }
}
