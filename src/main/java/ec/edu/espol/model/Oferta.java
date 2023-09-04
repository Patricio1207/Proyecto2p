/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;



/**
 *
 * @author Personal
 */
public class Oferta implements Serializable{
    private Usuario usuario;
    private double precio;
    private Vehiculo vehiculo;
    private String codigo;
    
    private static int cod = 0;
    
    public Oferta(Vehiculo vehi, double precio, String codigo){
        this.vehiculo=vehi;
        this.precio=precio;
        this.codigo=codigo;
    }
    public static void removeOfertas(ArrayList<Oferta> ofertas){
        ArrayList<Integer> indices = new ArrayList<>();
        for(Oferta ofe: ofertas){
//            indices.add(Proyecto1p.ofertas.indexOf(ofe));
//            Proyecto1p.ofertas.remove(ofe);
        }
        
        for(Integer indice: indices){
//            Proyecto1p.remove("ofertas.txt", indice);
        }
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setVehiculoo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Oferta(Usuario usuario, double precio, Vehiculo vehiculo) {
        this.usuario = usuario;
        this.precio = precio;
        this.vehiculo = vehiculo;
        //codigo = ++cod;
    }

    public Usuario getComprador() {
        return usuario;
    }

    public double getPrecio() {
        return precio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    public void add(){
//        Proyecto1p.addOferta(this);
    }

    @Override
    public String toString() {
        return codigo + "," + ","+ usuario.getCorreoElectronico()+
                "," + vehiculo.getPlaca() + "," + precio ;
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
        final Oferta other = (Oferta) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }
    
    
}
