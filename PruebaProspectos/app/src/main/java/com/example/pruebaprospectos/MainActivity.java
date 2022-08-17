package com.example.pruebaprospectos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pruebaprospectos.entidades.ModeloProspectos;
import com.example.pruebaprospectos.modelos.ModeloMainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvProspectos;
    ArrayList<ModeloProspectos> listProspectos;
    ModeloMainActivity modeloMainActivity;
    FloatingActionButton btnCaptura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modeloMainActivity = new ModeloMainActivity(this);
        listProspectos = new ArrayList<>();
        rvProspectos = findViewById(R.id.recyclerView);
        btnCaptura = (FloatingActionButton) findViewById(R.id.NuevoProspecto);

        /*Ajustar el recyclerview de manera vertical*/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvProspectos.setLayoutManager(linearLayoutManager);

        modeloMainActivity.getLista();

        btnCaptura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(this, CapturaProspectos.class);
                Intent intent = new Intent(getBaseContext(),CapturaProspectos.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        modeloMainActivity.getLista();
    }
    public void mostrarProspectos(ArrayList<ModeloProspectos> prospectos){

        listProspectos  = prospectos;
        AdapterProspectos adapter = new AdapterProspectos(this,listProspectos);
        try {
            rvProspectos.setAdapter(adapter);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    /*public void metodo(){
        ModeloProspectos obj = new ModeloProspectos(1,"jesus","sanchez","guzman","guillermo","1210","vallado","80110","6677475067","SAGJ981128GG1","Enviado","");
        listProspectos.add(obj);
        ModeloProspectos obj2 = new ModeloProspectos(1,"jesus","sanchez","guzman","guillermo","1210","vallado","80110","6677475067","SAGJ981128GG1","Enviado","");
        listProspectos.add(obj2);
    }*/
}