package com.guzmle.curso.mvp.logica;

import com.guzmle.curso.mvp.dominio.Usuario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Clase que se encarga de orquestar la logica de negocio
 */
public class Fachada {


    /**
     * Metodo que consulta la lista de usuarios del sistema
     * @return
     */
    public static List<Usuario> consultarUsuarios() {

        List<Usuario> retorno = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Usuario usuario = new Usuario();
            usuario.setNombre("Nombre " + i);
            usuario.setApellido("Apellido " + i);
            usuario.setCorreo("correo@correo.com");
            usuario.setFechaNacimiento(Calendar.getInstance());
            usuario.setNumeroDocumento("123456789" + i);
            usuario.setSexo( i % 2 == 0 ? 'M' : 'F');
            usuario.setTelefono("+58212555332" + i);
            retorno.add(usuario);
        }
        return retorno;
    }

    public static void agregarUsuario(Usuario usuario) {

    }
}
