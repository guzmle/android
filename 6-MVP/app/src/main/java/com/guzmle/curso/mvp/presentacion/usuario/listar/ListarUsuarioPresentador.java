package com.guzmle.curso.mvp.presentacion.usuario.listar;

import com.guzmle.curso.mvp.dominio.Usuario;
import com.guzmle.curso.mvp.logica.Fachada;
import com.guzmle.curso.mvp.presentacion.PresentadorBase;
import com.guzmle.curso.mvp.utilidades.Session;

import java.util.List;

/**
 * Clase que hace de presentador para la vista que se encarga de listar usuarios
 */
public class ListarUsuarioPresentador extends PresentadorBase {

    private final ListarUsuarioView view;

    /**
     * constructor de la clase donde se le asigna la vista
     * @param view objeto que posee la definicion de la vista
     */
    public ListarUsuarioPresentador(ListarUsuarioView view) {
        this.view = view;
    }


    /**
     * Metodo que realiza las operaciones para mostrar la vista que se encarga de modificar el usuario
     */
    public void irModificarUsuario() {
        Usuario usuario = view.getUsuarioSeleccionado();
        if(usuario == null)
            view.mostrarMensajeError("Debe Seleccionar los datos de un usuario");
        else{
            Session.put("usuarioModificar", usuario);
            view.navegarModificarUsuario(usuario);

        }
    }


    @Override
    public void init() {
        List<Usuario> lista = Fachada.consultarUsuarios();
        view.setUsuarios(lista);
        view.inicializacion();
    }
}
