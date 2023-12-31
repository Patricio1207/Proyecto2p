/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.avance.App;
import static ec.edu.espol.avance.App.validarUsuario;
import ec.edu.espol.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.util.ResourceBundle;
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
public class ViewLoginController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void login(MouseEvent event)
    {    
        String txtUsuario = this.txtUsuario.getText();
        String txtContra = this.txtContra.getText();
        if(validarUsuario(txtUsuario,txtContra)){
            App.uss = txtUsuario;
            App.co = txtContra;
            App.lUs.add(new Usuario(txtUsuario,txtContra));
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/MenuTipoUsuario.fxml"));

                Parent root = loader.load();

                MenuTipoUsuarioController controlador = loader.getController();
                
                controlador.setUser(txtUsuario);

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();


                Stage myStage = (Stage) this.btnLogin.getScene().getWindow();
                myStage.close();
            
            } catch (IOException ex) {
                Logger.getLogger(ViewMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
            
        } catch (Exception ex) {
        ex.printStackTrace();
        }
    }
    
}
