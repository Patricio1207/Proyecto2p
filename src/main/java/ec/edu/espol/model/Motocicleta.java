/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

/**
 *
 * @author Personal
 */
public class Motocicleta extends Vehiculo{
    public Motocicleta(String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String combustible, double precio){
        super("M",placa,marca,modelo,tipoMotor,año,recorrido,color,combustible,precio);
    }
}
