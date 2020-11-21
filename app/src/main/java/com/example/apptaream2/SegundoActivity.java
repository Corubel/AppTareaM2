package com.example.apptaream2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {
    private TextView tvnombre;
    private TextView tvfecha;
    private TextView tvtelefono;
    private TextView tvemail;
    private TextView tvdescripcion;
    Button editardatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        tvnombre = (TextView) findViewById(R.id.tvNombre);
        tvfecha = (TextView) findViewById(R.id.tvFecha);
        tvtelefono = (TextView) findViewById(R.id.tvTelefono);
        tvemail = (TextView) findViewById(R.id.tvEmail);
        tvdescripcion = (TextView) findViewById(R.id.tvdescripción);
        editardatos = findViewById(R.id.botoneditar);

        String dato1 = getIntent().getStringExtra("dato1");
        tvnombre.setText(dato1);
        String dato2 = getIntent().getStringExtra("dato2");
        tvfecha.setText("Fecha: " + dato2);
        String dato3 = getIntent().getStringExtra("dato3");
        tvtelefono.setText("Tel: " + dato3);
        String dato4 = getIntent().getStringExtra("dato4");
        tvemail.setText("Email: " + dato4);
        String dato5 = getIntent().getStringExtra("dato5");
        tvdescripcion.setText("Descripción: " + dato5);

        editardatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent et = new Intent(SegundoActivity.this, MainActivity.class);
                startActivity(et);
            }
        });

    }
}