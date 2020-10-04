package com.rosana.contactosconfirmacion;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nombre;
    private TextInputEditText telefono;
    private TextInputEditText email;
    private TextInputEditText descripcion;
    private DatePicker fecha;

    private String nom;
    private String tel;
    private String em;
    private String descr;
    private String fec;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre      = findViewById(R.id.etNombre);
        telefono    = findViewById(R.id.etTelefono);
        email       = findViewById(R.id.etEmail);
        descripcion = findViewById(R.id.etDescripcion);
        fecha       = findViewById(R.id.dpFecha);

        MaterialButton btnSiguiente = findViewById(R.id.siguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                nom = Objects.requireNonNull(nombre.getText()).toString();
                tel = Objects.requireNonNull(telefono.getText()).toString();
                em = Objects.requireNonNull(email.getText()).toString();
                descr = Objects.requireNonNull(descripcion.getText()).toString();
                fec = getFecha();

                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtra(getResources().getString(R.string.et_nombre), nom);
                i.putExtra(getResources().getString(R.string.et_fecha), fec);
                i.putExtra(getResources().getString(R.string.et_telefono), tel);
                i.putExtra(getResources().getString(R.string.et_email), em);
                i.putExtra(getResources().getString(R.string.et_descripcion), descr);
                startActivity(i);
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        final String nombre = extras.getString(getResources().getString(R.string.et_nombre));
        final String telefono = extras.getString(getResources().getString(R.string.et_telefono));
        final String email = extras.getString(getResources().getString(R.string.et_email));
        final String descripcion = extras.getString(getResources().getString(R.string.et_descripcion));


        this.nombre.setText(nombre);
        this.telefono.setText(telefono);
        this.email.setText(email);
        this.descripcion.setText(descripcion);

    }
    //método para obtener la fecha
    private String getFecha() {
        return "Fecha Nacimiento: " + fecha.getDayOfMonth() + "/" + fecha.getMonth() + "/" + fecha.getYear();
    }

}



