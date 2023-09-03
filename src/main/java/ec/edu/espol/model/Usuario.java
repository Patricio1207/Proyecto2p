/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Patricio Vásquez
 */
public class Usuario implements Serializable{
    protected String nombres;
    protected String apellidos;
    protected String organizacion;
    protected String correoElectronico;
    protected String clave;
    
    public Usuario(String nombres, String apellidos, String organizacion, String correo, String clave){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correoElectronico = correo;
        this.clave = clave;
    }
    
    public Usuario(String correoElectronico, String clave) {
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getClave() {
        return clave;
    }
    
    public static void añadirUsuario(ArrayList<Usuario> usuarios,String cE,String cn){
        usuarios.add(new Usuario(cE,cn));
    }

    @Override
    public String toString() {
        return "Usuario{" + "correoElectronico=" + correoElectronico + ", contrasena=" + clave + '}';
    }
    
    
}
