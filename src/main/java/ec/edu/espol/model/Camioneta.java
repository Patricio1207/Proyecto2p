/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

/**
 *
 * @author Personal
 */
public class Camioneta extends Vehiculo {
    private String vidrios;
    private String transmision;
    private String traccion;
    
    public Camioneta(String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String combustible, double precio, String vidrios, String transmision, String traccion){
        super("C",placa,marca,modelo,tipoMotor,año,recorrido,color,combustible,precio);
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.traccion = traccion;
    }
    @Override
    public String toString() {
        return super.toString() + "," + vidrios + "," + transmision + "," + traccion;
    }
}
