/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maxitoners.entidades;

/**
 *
 * @author luism
 */
public class Impresora {
    private int id;
    //Sera lo mismo que id???
    private String numeroSerie;
    private String marca;
    private String modelo;

    public Impresora(int id, String numeroSerie, String marca, String modelo) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
