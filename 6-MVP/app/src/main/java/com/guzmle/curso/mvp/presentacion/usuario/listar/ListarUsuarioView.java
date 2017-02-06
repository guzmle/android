package com.guzmle.curso.mvp.presentacion.usuario.listar;

import com.guzmle.curso.mvp.dominio.Usuario;
import com.guzmle.curso.mvp.presentacion.ViewBase;

import java.util.List;

/**
 * Contrato para la vista que se encargara de listar los usuarios
 */
public interface ListarUsuarioView extends ViewBase{

    /**
     * Metodo que asigna una lista de usuario a la vista para ser listada
     * @param usuarios lista de usuarios
     */
    void setUsuarios(List<Usuario> usuarios);


    /**
     * Metodo que obtiene el usuario seleccionado
     * @return usuario seleccionado
     */
    Usuario getUsuarioSeleccionado();


    /**
     * Metodo que se encarga de navegar a la vista de modificar usuario
     * @param usuario datos del usuario
     */
    void navegarModificarUsuario(Usuario usuario);
}
