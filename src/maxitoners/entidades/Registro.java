/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maxitoners.entidades;

import java.sql.Date;

/**
 *
 * @author luism
 */
public class Registro {
    private int id;
    //Antes era idImpresora
    private String modeloImpresora;
    private String marcaImpresora;
    //Antes idCliente
    private String nombreCliente;
    private int numImpresiones;
    private Date fecha;

    public Registro(int id, String modeloImpresora, String marcaImpresora, String nombreCliente, int numImpresiones, Date fecha) {
        this.id = id;
        this.modeloImpresora = modeloImpresora;
        this.marcaImpresora = marcaImpresora;
        this.nombreCliente = nombreCliente;
        this.numImpresiones = numImpresiones;
        this.fecha = fecha;
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumImpresiones() {
        return numImpresiones;
    }

    public void setNumImpresiones(int numImpresiones) {
        this.numImpresiones = numImpresiones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getModeloImpresora() {
        return modeloImpresora;
    }

    public void setModeloImpresora(String modeloImpresora) {
        this.modeloImpresora = modeloImpresora;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getMarcaImpresora() {
        return marcaImpresora;
    }

    public void setMarcaImpresora(String marcaImpresora) {
        this.marcaImpresora = marcaImpresora;
    }

    
    
    
}
