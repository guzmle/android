package com.guzmle.curso.mvp.presentacion.usuario.modificar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

import com.guzmle.curso.mvp.R;
import com.guzmle.curso.mvp.dominio.Usuario;
import com.guzmle.curso.mvp.presentacion.ViewImplBase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Clase que implementa la vista que agrega los datos de un usuario
 */
public class ModificarUsuarioViewImpl extends ViewImplBase implements ModificarUsuarioView {

    private ModificarUsuarioPresentador presentador;
    private static Calendar fechaSeleccionada;
    Usuario usuario;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_usuarios_agregar, container, false);
        presentador = new ModificarUsuarioPresentador(this);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        presentador.init();
    }


    @Override
    public void inicializacion(){
        View boton = getView().findViewById(R.id.botonAgregar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presentador.guardarDatos();
            }
        });

        final View fecha = getView().findViewById(R.id.fecha);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CalendarioPickerFragment newFragment = new CalendarioPickerFragment();
                newFragment.setInput((TextView) fecha);
                newFragment.show(getActivity().getFragmentManager(), "calendario");
            }
        });
    }


    @Override
    public Usuario getUsuario() {

        TextInputEditText inputNombre = (TextInputEditText) getView().findViewById(R.id.nombre);
        TextInputEditText inputApellido = (TextInputEditText) getView().findViewById(R.id.apellido);
        TextInputEditText inputDocumento = (TextInputEditText) getView().findViewById(R.id.numeroDocumento);
        TextInputEditText inputTelefono = (TextInputEditText) getView().findViewById(R.id.telefono);
        TextInputEditText inputCorreo = (TextInputEditText) getView().findViewById(R.id.correo);
        RadioButton inputSexo = (RadioButton) getView().findViewById(R.id.masculino);

        usuario.setSexo(inputSexo.isChecked() ? 'M' : 'F');
        usuario.setNombre(inputNombre.getText().toString());
        usuario.setApellido(inputApellido.getText().toString());
        usuario.setNumeroDocumento(inputDocumento.getText().toString());
        usuario.setTelefono(inputTelefono.getText().toString());
        usuario.setCorreo(inputCorreo.getText().toString());
        usuario.setFechaNacimiento(fechaSeleccionada);

        return usuario;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;

        TextInputEditText inputNombre = (TextInputEditText) getView().findViewById(R.id.nombre);
        TextInputEditText inputApellido = (TextInputEditText) getView().findViewById(R.id.apellido);
        TextInputEditText inputDocumento = (TextInputEditText) getView().findViewById(R.id.numeroDocumento);
        TextInputEditText inputTelefono = (TextInputEditText) getView().findViewById(R.id.telefono);
        TextInputEditText inputCorreo = (TextInputEditText) getView().findViewById(R.id.correo);
        RadioButton inputSexo = (RadioButton) getView().findViewById(R.id.masculino);

        inputSexo.setChecked(usuario.getSexo() == 'M');
        inputNombre.setText(usuario.getNombre());
        inputApellido.setText(usuario.getApellido());
        inputDocumento.setText(usuario.getNumeroDocumento());
        inputTelefono.setText(usuario.getTelefono());
        inputCorreo.setText(usuario.getCorreo());

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final TextView fecha = (TextView) getView().findViewById(R.id.fecha);
        fechaSeleccionada = usuario.getFechaNacimiento();
        fecha.setText(format.format(usuario.getFechaNacimiento().getTime()));
    }


    /**
     * Clase que me permite definir las propiedades del calendario
     */
    public static class CalendarioPickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        private TextView input;


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            return new DatePickerDialog(getActivity(), this, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        }

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            fechaSeleccionada = Calendar.getInstance();
            fechaSeleccionada.set(Calendar.DAY_OF_MONTH, day);
            fechaSeleccionada.set(Calendar.MONTH, month);
            fechaSeleccionada.set(Calendar.YEAR, year);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            input.setText(format.format(fechaSeleccionada.getTime()));

        }

        public void setInput(TextView input) {
            this.input = input;
        }
    }
}
