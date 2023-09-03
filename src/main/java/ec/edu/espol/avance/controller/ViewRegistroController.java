/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.avance.controller;

import ec.edu.espol.avance.model.Usuario;
import static ec.edu.espol.avance.App.addUsers;
import static ec.edu.espol.avance.App.readUsers;
import static ec.edu.espol.avance.model.Usuario.añadirUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Patricio Vásquez
 */
public class ViewRegistroController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContra;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public void closeWindows()
    {     
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/viewMenu.fxml"));
            
            Parent root = loader.load();
            
            ViewMenuController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            Stage myStage = (Stage) this.btnRegresar.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ViewMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @FXML
    private void registrarUsuario(MouseEvent event) {
        
        String txtUsuario = this.txtUsuario.getText();
        String txtContra = this.txtContra.getText();
        
        ArrayList<Usuario> usuarios = readUsers();

        boolean usuarioExistente = false;

        // Verificar si el correo ya existe en la lista
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreoElectronico().equals(txtUsuario)) {
                usuarioExistente = true;
                break;
            }
        }

        // Mostrar alerta y agregar usuario al archivo si no existe el correo en la lista
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (usuarioExistente) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Usuario existente");
        } else {
            // Crear un nuevo objeto Usuario con los datos ingresados
            Usuario nuevoUsuario = new Usuario(txtUsuario, txtContra);
            // Agregar el nuevo Usuario al ArrayList
            usuarios.add(nuevoUsuario);
            // Llamar al método para guardar los usuarios en el archivo serializado
            addUsers(usuarios);

            alert.setContentText("Usuario registrado");
        }
        alert.showAndWait(); 
        
    }

    @FXML
    private void regresar(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/viewMenu.fxml"));
            
            Parent root = loader.load();
            
            ViewMenuController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            Stage myStage = (Stage) this.btnRegresar.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ViewMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
