package com.example.pruebaprospectos.servicios;

import com.example.pruebaprospectos.entidades.EvaluarRequest;
import com.example.pruebaprospectos.entidades.EvaluarRespuesta;
import com.example.pruebaprospectos.entidades.ModeloProspectos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIinterface {

    //@Headers("Content-Type: application/json")

    @GET("allProspectos")
    Call<List<ModeloProspectos>>getProspectos();

    @PUT("prospectos/update/{id}")
    Call<EvaluarRespuesta>evaluarProspecto(@Path("id") int id,@Body EvaluarRequest evaluarRequest);

    @POST("/addProspecto")
    Call<ModeloProspectos>postProspecto(@Body ModeloProspectos Prospecto);
}

