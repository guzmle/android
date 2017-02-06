package com.guzmle.curso.mvp.presentacion.usuario.agregar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
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
public class AgregarUsuarioViewImpl extends ViewImplBase implements AgregarUsuarioView {

    private AgregarUsuarioPresentador presentador;
    private static Calendar fechaSeleccionada;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_usuarios_agregar, container, false);
        presentador = new AgregarUsuarioPresentador(this);

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

        Usuario retorno = new Usuario();
        retorno.setSexo(inputSexo.isChecked() ? 'M' : 'F');
        retorno.setNombre(inputNombre.getText().toString());
        retorno.setApellido(inputApellido.getText().toString());
        retorno.setNumeroDocumento(inputDocumento.getText().toString());
        retorno.setTelefono(inputTelefono.getText().toString());
        retorno.setCorreo(inputCorreo.getText().toString());
        retorno.setFechaNacimiento(fechaSeleccionada);

        return retorno;
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
