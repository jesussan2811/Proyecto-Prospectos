package com.example.pruebaprospectos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebaprospectos.entidades.EvaluarRespuesta;
import com.example.pruebaprospectos.entidades.ModeloProspectos;
import com.example.pruebaprospectos.modelos.ModeloEvaluarActivity;

public class EvaluarActivity extends AppCompatActivity {
    TextView evNombre;
    TextView evApellidoP;
    TextView evApellidoM;
    TextView evCalle;
    TextView evNoCasa;
    TextView evColonia;
    TextView evCP;
    TextView evTelefono;
    TextView evRFC;

    EditText evObservaciones;

    Button btnRechazar;
    Button btnAceptar;

    ModeloEvaluarActivity modeloEvaluarActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluar);
        modeloEvaluarActivity = new ModeloEvaluarActivity(this);
        evNombre = (TextView)findViewById(R.id.evaNombre);
        evApellidoP = (TextView) findViewById(R.id.evaApellidoPat);
        evApellidoM = (TextView) findViewById(R.id.evaApellidoMat);
        evCalle = (TextView) findViewById(R.id.evaCalle);
        evNoCasa = (TextView) findViewById(R.id.evaNoCasa);
        evColonia = (TextView) findViewById(R.id.evaColonia);
        evCP = (TextView) findViewById(R.id.evaCP);
        evTelefono = (TextView) findViewById(R.id.evaTelefono);
        evRFC = (TextView) findViewById(R.id.evaRFC);

        evObservaciones = (EditText) findViewById(R.id.evaObservaciones);

        btnRechazar = (Button) findViewById(R.id.Rechazado);
        btnAceptar = (Button) findViewById(R.id.Aceptado);

        Intent intent = getIntent();
        ModeloProspectos prospecto = (ModeloProspectos) intent.getSerializableExtra("Prospecto");
        evNombre.setText(prospecto.getNombre());
        evApellidoP.setText(prospecto.getApellidoPat());
        evApellidoM.setText(prospecto.getApellidoMat());
        evCalle.setText(prospecto.getCalle());
        evNoCasa.setText(prospecto.getNoCasa());
        evColonia.setText(prospecto.getColonia());
        evCP.setText(prospecto.getCP());
        evTelefono.setText(prospecto.getTelefono());
        evRFC.setText(prospecto.getRFC());
        evObservaciones.setText(prospecto.getObservaciones());



        btnRechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String observaciones = evObservaciones.getText().toString();
                if(observaciones.length() != 0) {
                    modeloEvaluarActivity.evaluarProspecto(prospecto.getID(), "Rechazado",observaciones);
                    finish();
                }else{
                    Toast.makeText(getBaseContext(),"favor de llenar las observaciones",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String observaciones = evObservaciones.getText().toString();
                modeloEvaluarActivity.evaluarProspecto(prospecto.getID(),"Aceptado", observaciones);
                finish();
            }
        });

    }

    public void respuesta(EvaluarRespuesta respuestaEvaluar){
        Toast.makeText(this,respuestaEvaluar.mensaje,Toast.LENGTH_LONG).show();
    }
}