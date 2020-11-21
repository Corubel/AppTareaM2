    package com.example.apptaream2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

    public class MainActivity extends AppCompatActivity {
    private EditText etnombre;
    EditText fecha;
    private EditText ettelefono;
    private EditText etemail;
    private EditText etdescripcion;
    Button siguiente;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnombre = findViewById(R.id.nombreCompleto);
        fecha = findViewById(R.id.fechaNacimiento);
        ettelefono = findViewById(R.id.telefono);
        etemail = findViewById(R.id.email);
        etdescripcion = findViewById(R.id.descripcion);
        siguiente = findViewById(R.id.botonsiguiente);

        Calendar calendario = Calendar.getInstance();
        final int año = calendario.get(Calendar.YEAR);
        final int mes = calendario.get(Calendar.MONTH);
        final int dia = calendario.get(Calendar.DAY_OF_MONTH);

        //PIKER DE FECHA
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog pickerdeFecha = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        fecha.setText(date);

                    }
                },año,mes,dia);
                pickerdeFecha.show();
            }
        });
        //BOTON SIGUIENTE
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(MainActivity.this, SegundoActivity.class);
                s.putExtra("dato1", etnombre.getText().toString());
                s.putExtra("dato2", fecha.getText().toString());
                s.putExtra("dato3", ettelefono.getText().toString());
                s.putExtra("dato4", etemail.getText().toString());
                s.putExtra("dato5", etdescripcion.getText().toString());
                startActivity(s);

            }
        });


    }
}