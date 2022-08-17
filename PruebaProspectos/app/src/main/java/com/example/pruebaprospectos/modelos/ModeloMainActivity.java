package com.example.pruebaprospectos.modelos;

import com.example.pruebaprospectos.EvaluarActivity;
import com.example.pruebaprospectos.MainActivity;
import com.example.pruebaprospectos.entidades.ModeloProspectos;
import com.example.pruebaprospectos.servicios.APIinterface;
import com.example.pruebaprospectos.servicios.RetrifitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloMainActivity {

    MainActivity mainActivity;
    //recibe el contexto del main activity
    public ModeloMainActivity(MainActivity mainActivity){
        this.mainActivity = mainActivity;

    }
    //crear una instacia de retrofit para mandar a llamar el servicio
    public void getLista(){
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<List<ModeloProspectos>> call = apiInterface.getProspectos();
        call.enqueue(new Callback<List<ModeloProspectos>>() {
            //Aqui se obtiene la respuesta del servicio
            @Override
            public void onResponse(Call<List<ModeloProspectos>> call, Response<List<ModeloProspectos>> response) {
                ArrayList<ModeloProspectos> prospectos = new ArrayList<>();
                prospectos = (ArrayList<ModeloProspectos>) response.body();
                //se manda a llamar metodo para mostrar los resultados del servicio
                mainActivity.mostrarProspectos(prospectos);
            }

            @Override
            public void onFailure(Call<List<ModeloProspectos>> call, Throwable t) {
                System.out.println("no funciono");
            }
        });
    }

}
