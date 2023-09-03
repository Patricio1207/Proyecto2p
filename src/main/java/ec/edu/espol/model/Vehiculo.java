/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.util.ArrayList;

/**
 *
 * @author Personal
 */
public class Vehiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String tipoMotor;
    protected int año;
    protected double recorrido;
    protected String color;
    protected String combustible;
    protected double precio;
    protected String tipo;
    
    public Vehiculo(String tipo, String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String combustible, double precio){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    //Se filtrara por tipo de vehiculo
    public static ArrayList<Vehiculo> filter(String valor, ArrayList<Vehiculo> vehiculos) {
        ArrayList<Vehiculo> vehiFilter = new ArrayList<>();
        
        for (Vehiculo vehi : vehiculos) {
            if (!vehi.tipo.equals(valor)) {
                continue;
            }
            vehiFilter.add(vehi);

        }

        return vehiFilter;
    }

    //Se filtrara por el año del vehiculo
    public static ArrayList<Vehiculo> filter(int valorinicial, int valorfinal, ArrayList<Vehiculo> vehiculos) {
        ArrayList<Vehiculo> vehiFilter = new ArrayList<>();

        for (Vehiculo vehi : vehiculos) {
            if (vehi.año > valorfinal || vehi.año < valorinicial) {
                continue;
            }
            vehiFilter.add(vehi);

        }

        return vehiFilter;
    }

    //Se filtrara por el precio o recorrido del vehiculo
    public static ArrayList<Vehiculo> filter(double valorinicial, double valorfinal, ArrayList<Vehiculo> vehiculos, String pro) {
        ArrayList<Vehiculo> vehiFilter = new ArrayList<>();

        if (pro.equals("recorrido")) {
            for (Vehiculo vehi : vehiculos) {
                if (vehi.recorrido > valorfinal || vehi.recorrido < valorinicial) {
                    continue;
                }
                vehiFilter.add(vehi);
            }

        }else{
            for (Vehiculo vehi : vehiculos) {
                if (vehi.precio > valorfinal || vehi.precio < valorinicial) {
                    continue;
                }
                vehiFilter.add(vehi);
            }
        }

        return vehiFilter;
    }

//    public static void removeVehiculo(Vehiculo vehiculo){
//        int indice = Proyecto1p.vehiculos.indexOf(vehiculo);
//        Proyecto1p.vehiculos.remove(vehiculo);
//        
//        Proyecto1p.remove("vehiculos.txt", indice);
//        
//    }
    
//    public static Vehiculo getVehiculo(String placa) {
//        for (Vehiculo vehi : Proyecto1p.vehiculos) {
//            if (placa.equals(vehi.placa)) {
//                return vehi;
//            }
//        }
//        return null;
//    }

    public static boolean existVehiculo(Vehiculo vehiculo, ArrayList<Vehiculo> vehiculos) {
        for (Vehiculo vehi : vehiculos) {

            if (vehi.placa.equals(vehiculo.placa)) {
                return true;
            }
        }
        return false;
    }

//    public void addVehiculo() {
//        Proyecto1p.addVehiculo(this);
//    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public int getAño() {
        return año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public String getColor() {
        return color;
    }

    public String getCombustible() {
        return combustible;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return this.placa.equals(other.placa);
    }

    @Override
    public String toString() {
        return tipo + "," + placa + "," + marca + "," + modelo + "," + tipoMotor + "," + año + ","
                + recorrido + "," + color + "," + combustible + "," + precio;
    }
    
}
