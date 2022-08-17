package com.example.pruebaprospectos.modelos;

import com.example.pruebaprospectos.CapturaProspectos;
import com.example.pruebaprospectos.entidades.ModeloProspectos;
import com.example.pruebaprospectos.servicios.APIinterface;
import com.example.pruebaprospectos.servicios.RetrifitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloCapturarProspectos {
    CapturaProspectos activity;
    public ModeloCapturarProspectos(CapturaProspectos activity){
        this.activity = activity;
    }
    public void postProspecto(ModeloProspectos prospecto){
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<ModeloProspectos> call = apiInterface.postProspecto(prospecto);
        call.enqueue(new Callback<ModeloProspectos>() {
            @Override
            public void onResponse(Call<ModeloProspectos> call, Response<ModeloProspectos> response) {
                ModeloProspectos respuesta = (ModeloProspectos) response.body();
                if(respuesta != null)
                    activity.mostrarRespuesta("se ha dado de alta");
                else
                    activity.mostrarRespuesta("no se dio de alta");

            }

            @Override
            public void onFailure(Call<ModeloProspectos> call, Throwable t) {
                System.out.println("fallo al Capturar");
            }
        });
    }
}
