package com.guzmle.curso.controls;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Clase que posee la definicion del fragmento que muestra los text fields
 *
 * @author guzmle
 */
public class OtrosFragment extends Fragment {

    private static Calendar horaSeleccionada;
    private static Calendar fechaSeleccionada;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_otros, container, false);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        inicializacion();
    }


    /**
     * Metodo que se encarga de la inicializacion de los componentes de la vista
     */
    private void inicializacion() {


        View mostrarReloj = getView().findViewById(R.id.mostrarReloj);
        mostrarReloj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment newFragment = new RelojPickerFragment();
                newFragment.show(getActivity().getFragmentManager(), "timePicker");
            }
        });

        View mostrarCalendario = getView().findViewById(R.id.mostrarCalendario);
        mostrarCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment newFragment = new CalendarioPickerFragment();
                newFragment.show(getActivity().getFragmentManager(), "calendario");
            }
        });


        View boton = getView().findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

                StringBuilder mensaje = new StringBuilder();
                if(horaSeleccionada != null)
                {
                    mensaje.append("Hora Seleccionada: ");
                    mensaje.append(formatoHora.format(horaSeleccionada.getTime()));
                }
                if(fechaSeleccionada != null)
                {
                    mensaje.append("\nFecha Seleccionada: ");
                    mensaje.append(formatoFecha.format(fechaSeleccionada.getTime()));
                }

                Toast toast = Toast.makeText(getActivity(), mensaje.toString(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }


    /**
     * Clase que me permite definir las propiedades del reloj
     */
    public static class RelojPickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {


            //Inicializamos el reloj con la hora deseada
            return new TimePickerDialog(getActivity(), this, 0, 0,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            horaSeleccionada = Calendar.getInstance();
            horaSeleccionada.set(Calendar.HOUR, hourOfDay);
            horaSeleccionada.set(Calendar.MINUTE, minute);
        }
    }


    /**
     * Clase que me permite definir las propiedades del calendario
     */
    public static class CalendarioPickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
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

        }
    }
}