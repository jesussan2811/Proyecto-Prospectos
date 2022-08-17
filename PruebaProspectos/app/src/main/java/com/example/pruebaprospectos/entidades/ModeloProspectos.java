package com.example.pruebaprospectos.entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ModeloProspectos implements Serializable {
    int ID;
    String Nombre="";
    String ApellidoPat="";
    String ApellidoMat="";
    String Calle="";
    String NoCasa="";
    String Colonia="";
    String CP="";
    String Telefono="";
    String RFC="";
    String Estatus="";
    String Observaciones="";

    public ModeloProspectos(){}
    public ModeloProspectos(String Nombre,String ApellidoPat,String ApellidoMat,String Calle,String NoCasa,String Colonia,String CP,String Telefono,String RFC,String Estatus){
        this.Nombre = Nombre;
        this.ApellidoPat = ApellidoPat;
        this.ApellidoMat = ApellidoMat;
        this.Calle = Calle;
        this.NoCasa = NoCasa;
        this.Colonia = Colonia;
        this.CP = CP;
        this.Telefono = Telefono;
        this.RFC = RFC;
        this.Estatus = Estatus;
    }
    public ModeloProspectos(int ID,String Nombre,String ApellidoPat,String ApellidoMat,String Calle,String NoCasa,String Colonia,String CP,String Telefono,String RFC,String Estatus,String Observaciones){
        this.ID = ID;
        this.Nombre = Nombre;
        this.ApellidoPat = ApellidoPat;
        this.ApellidoMat = ApellidoMat;
        this.Calle = Calle;
        this.NoCasa = NoCasa;
        this.Colonia = Colonia;
        this.CP = CP;
        this.Telefono = Telefono;
        this.RFC = RFC;
        this.Estatus = Estatus;
        this.Observaciones = Observaciones;
    }
    public int getID(){
        return ID;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getApellidoPat(){
        return ApellidoPat;
    }
    public String getApellidoMat(){
        return ApellidoMat;
    }
    public String getCalle(){
        return Calle;
    }
    public String getNoCasa(){
        return NoCasa;
    }
    public String getColonia(){
        return Colonia;
    }
    public String getCP(){
        return CP;
    }
    public String getTelefono(){
        return Telefono;
    }
    public String getRFC(){
        return RFC;
    }
    public String getEstatus(){
        return Estatus;
    }
    public String getObservaciones(){
        return Observaciones;
    }
}



