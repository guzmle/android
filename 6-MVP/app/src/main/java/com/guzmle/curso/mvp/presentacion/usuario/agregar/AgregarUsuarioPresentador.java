package com.guzmle.curso.mvp.presentacion.usuario.agregar;

import com.guzmle.curso.mvp.dominio.Usuario;
import com.guzmle.curso.mvp.logica.Fachada;
import com.guzmle.curso.mvp.presentacion.PresentadorBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que hace de presentaodr para la vista que se encarga de agregar los datos de un usuario
 */
public class AgregarUsuarioPresentador extends PresentadorBase{

    private AgregarUsuarioView view;


    /**
     * Constructor de la clase
     * @param view objeto con la definicion de la vista
     */
    public AgregarUsuarioPresentador(AgregarUsuarioView view) {
        this.view = view;
    }


    @Override
    public void init() {
        view.inicializacion();
    }


    /**
     * Metodo que realiza las operaciones para guardar los datos del usuario
     */
    public void guardarDatos() {

        try
        {
            Usuario usuario = view.getUsuario();
            if(usuario.getNombre() == null || usuario.getNombre().isEmpty())
                view.mostrarMensajeError("Debe ingresar un nombre");
            else if(usuario.getApellido() == null || usuario.getApellido().isEmpty())
                view.mostrarMensajeError("Debe ingresar un apellido");
            else if(usuario.getCorreo() == null || usuario.getApellido().isEmpty())
                view.mostrarMensajeError("Debe ingresar un correo valido");
            else if(usuario.getTelefono() == null || usuario.getTelefono().isEmpty())
                view.mostrarMensajeError("Debe ingresar un telefono valido");
            else if(usuario.getFechaNacimiento() == null)
                view.mostrarMensajeError("Debe ingresar una fecha de nacimiento valido");
            else{
                Fachada.agregarUsuario(usuario);
                view.mostrarMensajeExito("Se ha guardado exitosamente los datos del usuario");

            }
        }
        catch (Exception e)
        {

        }
    }
}
