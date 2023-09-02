package ec.edu.espol.avance;

import archivos.manejoArchivos;
import static ec.edu.espol.avance.Usuario.añadirUsuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.control.Alert;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("viewMenu"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) 
    {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        serializar(usuarios);
        launch();
        System.out.println(vehiculos);
        
        
    } 
    
//    private void cargarUsuarios() {
//        ArrayList<Usuario> usuarios = new ArrayList<>();
//        usuarios.add(new Usuario("patovasquez1205@gmail.com", "contraseña123"));
//        usuarios.add(new Usuario("usuario2", "contrasena2"));
//        // Agregar más usuarios según necesites
//    }

    public static void serializar(ArrayList<Usuario> usuarios)
    {   
//        for(Usuario objeto:usuarios){
//            try {
//                FileOutputStream fileOut = new FileOutputStream("usuarios.ser",true);
//                ObjectOutputStream out = new ObjectOutputStream(fileOut);
//                out.writeObject(objeto);
//                out.close();
//                fileOut.close();
//            } catch (IOException e) {
//                System.out.println("No se pudo escribir");
//            }
//        }
        
            //Se serializa la lista
            try {
                FileOutputStream fileOut = new FileOutputStream("usuarios.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(usuarios);
                out.close();
                fileOut.close();
            } catch (IOException e) {
                System.out.println("No se pudo escribir");
            }
    }
    
    public static ArrayList<Usuario> deSerializar(String archivo)
    {
        ArrayList<Usuario> objetos = null;
        String cyc = null;
            try {
                    FileInputStream fileIn = new FileInputStream(archivo);
                    ObjectInputStream in = new ObjectInputStream(fileIn);

                    objetos = (ArrayList<Usuario>)in.readObject();
                    
//                    for(Usuario usuario:objetos){
//                        System.out.println("Correo: "+usuario.getCorreoElectronico()+" - "+"Contraseña: "+usuario.getContrasena());
//                    }

            } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
            }
            catch(IOException ex){
                    ex.printStackTrace();
            }
        return objetos;
    }
    
    public static boolean validarUsuario(String usuario,String contra)
    {
        ArrayList<Usuario> us = deSerializar("usuarios.ser");
        boolean bool = false;
        for(Usuario u:us){
            if(u.getCorreoElectronico().equals(usuario) && u.getClave().equals(contra)){
                bool = true;
            }
        }
        if(bool == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Login");
            alert.setContentText("Usuario Correcto");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Login");
            alert.setContentText("Usuario Incorrecto");
            alert.showAndWait();
        }
        return bool;
    }
    
    public static void addUsers(ArrayList<Usuario> usuarios) {
        try {
            FileOutputStream fileOut = new FileOutputStream("usuarios.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(usuarios);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("No puedo escribir el objeto");
        }
    }
    
    public static ArrayList<Usuario> readUsers() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream("usuarios.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            listaUsuarios = (ArrayList<Usuario>) objectIn.readObject();//Me sale que intento pasar un objeto Usuario a uno ArrayList
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }
    
    public static void addVehiculo(Vehiculo veh){
        vehiculos.add(veh);
        try {
                FileOutputStream fileOut = new FileOutputStream("vehiculos.ser",true);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(veh.toString()+"\n");
                out.close();
                fileOut.close();
            } catch (IOException e) {
                System.out.println("No se pudo escribir");
            }
    }
    
    public static void mostrarVehiculos(String tipo,double recInf,double recSup,int anoInf,int anoSup,double precioInf,double precioSup) {
        ArrayList<Vehiculo> vehic = new ArrayList<>();
        //Primero se deben filtrar los datos

        if (!tipo.equals("")) {
            vehic = Vehiculo.filter(tipo, vehiculos);
        }

        if (recInf > 0 && recSup > 0 && recInf <= recSup) {
            vehic = Vehiculo.filter(recInf, recSup, vehic, "recorrido");
        }
        
        if (anoInf > 0 && anoSup > 0 && anoInf <= anoSup) {
            vehic = Vehiculo.filter(anoInf, anoSup, vehic);
        }
        
        if (precioInf > 0 && precioSup > 0 && precioInf <= precioSup) {
            vehic = Vehiculo.filter(precioInf, precioSup, vehic, "precio");
        }
        
        //Mostrar al usuario
//        for (int i = 0; i < vehic.size(); i++) {
//            System.out.println("Vehiculo" + (i + 1));
//            String tipoVeh = "";
//            if (vehic.get(i).getTipo().equals("A")) {
//                tipoVeh = "Auto";
//            } else if (vehic.get(i).getTipo().equals("C")) {
//                tipoVeh = "Camioneta";
//            } else {
//                tipoVeh = "Moto";
//            }

        System.out.println("placa: " + vehic.get(0).getPlaca()
                    + "\nModelo: " + vehic.get(0).getModelo()
                    + "\nAño: " + vehic.get(0).getAño()
                    + "\nRecordido: " + vehic.get(0).getRecorrido()
                    + "\nPrecio: " + vehic.get(0).getPrecio()
                    + "\nModelo: " + vehic.get(0).getModelo()
                    + "\nTipo: " + tipo);
        
    }
}