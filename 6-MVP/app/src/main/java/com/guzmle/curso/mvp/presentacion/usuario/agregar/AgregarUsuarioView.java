package com.guzmle.curso.mvp.presentacion.usuario.agregar;

import com.guzmle.curso.mvp.dominio.Usuario;
import com.guzmle.curso.mvp.presentacion.ViewBase;

/**
 * Contrato para la vista que se encarga de agregar usuario
 */
public interface AgregarUsuarioView extends ViewBase{

    /**
     * Metodo que obtiene los datos del usuario que se desea agregar
     */
    Usuario getUsuario();
}
