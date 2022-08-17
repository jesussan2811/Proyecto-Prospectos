package com.example.pruebaprospectos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pruebaprospectos.entidades.ModeloProspectos;
import com.example.pruebaprospectos.modelos.ModeloCapturarProspectos;

public class CapturaProspectos extends AppCompatActivity {

    EditText nvoNombre;
    EditText nvoApellidoP;
    EditText nvoApellidoM;
    EditText nvoCalle;
    EditText nvoNoCasa;
    EditText nvoColonia;
    EditText nvoCP;
    EditText nvoTelefono;
    EditText nvoRFC;
    Button btnEnviar;
    Button btnSalir;

    ModeloCapturarProspectos modeloCapturarProspectos;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura_prospectos);

        nvoNombre = (EditText)findViewById(R.id.CapNombre);
        nvoApellidoP = (EditText)findViewById(R.id.CapApellidoPat);
        nvoApellidoM = (EditText)findViewById(R.id.CapApellidoMat);
        nvoCalle = (EditText)findViewById(R.id.CapCalle);
        nvoNoCasa = (EditText)findViewById(R.id.CapNoCasa);
        nvoColonia = (EditText)findViewById(R.id.CapColonia);
        nvoCP = (EditText)findViewById(R.id.CapCP);
        nvoTelefono = (EditText)findViewById(R.id.CapTelefono);
        nvoRFC = (EditText)findViewById(R.id.CapRFC);
        btnSalir = (Button) findViewById(R.id.CapSalir);
        btnEnviar = (Button) findViewById(R.id.CapEnviar);

        modeloCapturarProspectos = new ModeloCapturarProspectos(this);
        builder = new AlertDialog.Builder(this);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = nvoNombre.getText().toString();
                String apellidoP = nvoApellidoP.getText().toString();
                String apellidoM = nvoApellidoM.getText().toString();
                String calle = nvoCalle.getText().toString();
                String noCasa = nvoNoCasa.getText().toString();
                String colonia = nvoColonia.getText().toString();
                String cp = nvoCP.getText().toString();
                String telefono = nvoTelefono.getText().toString();
                String rfc = nvoRFC.getText().toString();
                String estatus = "ENVIADO";

                ModeloProspectos prospectoNuevo = new ModeloProspectos(nombre,apellidoP,apellidoM,calle,noCasa,colonia,cp,telefono,rfc,estatus);
                if(validarcampos(prospectoNuevo)){
                    modeloCapturarProspectos.postProspecto(prospectoNuevo);
                }else{
                    Toast.makeText(getBaseContext(),"Llena todos los campos Obligatorios",Toast.LENGTH_LONG).show();

                }


            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:

                                break;
                        }
                    }
                };


                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });
    }

    public boolean validarcampos(ModeloProspectos prospecto){
        boolean valido = true;

        if(prospecto.getNombre().length() == 0)
            valido = false;
        if(prospecto.getApellidoPat().length() == 0)
            valido = false;
        if(prospecto.getCalle().length() == 0)
            valido = false;
        if(prospecto.getNoCasa().length() == 0)
            valido = false;
        if(prospecto.getColonia().length() == 0)
            valido = false;
        if(prospecto.getCP().length() == 0)
            valido = false;
        if(prospecto.getTelefono().length() < 10)
            valido = false;
        if(prospecto.getRFC().length() < 13)
            valido = false;

        return valido;
    }

    public void mostrarRespuesta(String respuesta){
        Toast.makeText(this,respuesta,Toast.LENGTH_LONG).show();
        if(respuesta.compareTo("se ha dado de alta") == 0)
        {
            finish();
        }
    }
}