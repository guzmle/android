package com.guzmle.curso.mvp.presentacion;

/**
 * Clase que hace de base para todas las vistas de la aplicacion
 */
public interface ViewBase {

    /**
     * Metodo que se encarga de mostrar un mensaje de error
     * @param mensaje
     */
    void mostrarMensajeError(String mensaje);


    /**
     * Metodo que se encarga de inicializar los componentes de la vista
     */
    void inicializacion();


    /**
     * Metodo que se encarga de mostrar un mensaje de exito
     * @param mensaje mensaje a mostrar
     */
    void mostrarMensajeExito(String mensaje);
}
