package com.example.pruebaprospectos.modelos;

import com.example.pruebaprospectos.EvaluarActivity;
import com.example.pruebaprospectos.entidades.EvaluarRequest;
import com.example.pruebaprospectos.entidades.EvaluarRespuesta;
import com.example.pruebaprospectos.servicios.APIinterface;
import com.example.pruebaprospectos.servicios.RetrifitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloEvaluarActivity {

    EvaluarActivity activity;
    public ModeloEvaluarActivity(EvaluarActivity activity){
        this.activity = activity;
    }
    public void evaluarProspecto(int id,String estatus,String observaciones){
        EvaluarRequest evaluarRequest = new EvaluarRequest(estatus,observaciones);
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<EvaluarRespuesta> call = apiInterface.evaluarProspecto(id,evaluarRequest);
        call.enqueue(new Callback<EvaluarRespuesta>() {
            @Override
            public void onResponse(Call<EvaluarRespuesta> call, Response<EvaluarRespuesta> response) {
                EvaluarRespuesta respuesta = (EvaluarRespuesta) response.body();
                activity.respuesta(respuesta);
            }

            @Override
            public void onFailure(Call<EvaluarRespuesta> call, Throwable t) {
                System.out.println("fallo al evaluar");
            }
        });
    }
}
