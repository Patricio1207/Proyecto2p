/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.Serializable;

/**
 *
 * @author Personal
 */
public class Auto extends Vehiculo implements Serializable{
    private String vidrios;
    private String transmision;
    
    public Auto(String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String combustible, double precio, String vidrios, String transmision){
        super("Auto",placa,marca,modelo,tipoMotor,año,recorrido,color,combustible,precio);
        this.vidrios = vidrios;
        this.transmision = transmision;
    }
    @Override
    public String toString() {
        return super.toString() +"," + vidrios + "," + transmision;
    }
}
