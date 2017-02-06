package com.guzmle.curso.mvp.presentacion.usuario.modificar;

import com.guzmle.curso.mvp.dominio.Usuario;
import com.guzmle.curso.mvp.presentacion.ViewBase;

/**
 * Contrato para la vista que se encarga de agregar usuario
 */
public interface ModificarUsuarioView extends ViewBase{

    /**
     * Metodo que obtiene los datos del usuario que se desea agregar
     */
    Usuario getUsuario();


    /**
     * Metodo que asigna los valores del usuario para ser guardado
     */
    void setUsuario(Usuario usuario);
}
