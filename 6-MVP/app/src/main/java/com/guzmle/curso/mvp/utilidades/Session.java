package com.guzmle.curso.mvp.utilidades;

import java.util.HashMap;
import java.util.Objects;

/**
 * Clase que hace de Registro en la aplicacion
 */
public class Session {
    private static HashMap<String, Object> datos;

    static {
        datos = new HashMap<>();
    }


    /**
     * Metodo que obtiene un dato guardado en session
     * @param id identificador del dato
     * @return dato almacenado
     */
    public static Object get(String id) {
        return datos.get(id);
    }


    /**
     * Metodo que agrega un dato a la session
     * @param id identificador del objeto
     * @param object objeto almacenado
     */
    public static void put(String id, Object object) {
        datos.put(id, object);
    }
}
