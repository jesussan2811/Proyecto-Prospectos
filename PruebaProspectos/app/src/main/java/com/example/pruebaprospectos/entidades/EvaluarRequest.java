package com.example.pruebaprospectos.entidades;

public class EvaluarRequest {
    public String estatus;
    public String observaciones;
    public EvaluarRequest(String estatus,String observaciones){
        this.estatus = estatus;
        this.observaciones = observaciones;
    }
}
