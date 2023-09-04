/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Usuario;
import static ec.edu.espol.avance.App.addUsers;
import static ec.edu.espol.avance.App.readUsers;
import static ec.edu.espol.avance.App.validarUsuario;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Personal
 */
public class MenuCambiarContraseñaController implements Initializable {

    @FXML
    private Text txUser;
    @FXML
    private TextField txContr;
    @FXML
    private TextField tsContraN;
    @FXML
    private Button btncambiar;
    @FXML
    private Button btnSalir;
    
    private String user;
    @FXML
    private Button btnRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSalir.setVisible(false);
    }    

    @FXML
    private void cambiarContraseña(ActionEvent event) {
        System.out.println("u"+user);
        String cont = txContr.getText();
        String contn = tsContraN.getText();
        ArrayList<Usuario> usuarios = readUsers();
        ArrayList<Usuario> usuariosNuevos = new ArrayList<>();
        if(validarUsuario(user,cont)){
            for(Usuario u:usuarios){
                if(!(u.getCorreoElectronico().equals(user)&&u.getClave().equals(cont))){
                    usuariosNuevos.add(u);
                }
            }
            Usuario nuevoUsuario = new Usuario(user, contn);
            usuariosNuevos.add(nuevoUsuario);
            // Llamar al método para guardar los usuarios en el archivo serializado
            addUsers(usuariosNuevos);
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Contraseña cambiada");
            a.show();
            btnRegresar.setVisible(false);
            btnSalir.setVisible(true);
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR,"El usuario o contraseña son incorrectos");
            a.show();
        }
        txContr.clear();
        tsContraN.clear();
    }

    @FXML
    private void salir(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/ViewMenu.fxml"));

            Parent root = loader.load();

            ViewMenuController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();


            Stage myStage = (Stage) this.btnSalir.getScene().getWindow();
            myStage.close();
            
        } catch (Exception ex) {
        ex.printStackTrace();
        }
    }
    
    public void setUser(String u) {
        this.user = u;
    }

    @FXML
    private void regresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/MenuTipoUsuario.fxml"));

            Parent root = loader.load();

            MenuTipoUsuarioController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();


            Stage myStage = (Stage) this.btnRegresar.getScene().getWindow();
            myStage.close();
            
        } catch (Exception ex) {
        ex.printStackTrace();
        }
    }
    public void setTx(String a){
        txUser.setText(a);
    }

    
}

