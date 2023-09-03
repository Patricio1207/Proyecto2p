/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.avance;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Personal
 */
public class MenuTipoUsuarioController implements Initializable {

    @FXML
    private VBox vbox22;
    @FXML
    private Text tx1;
    @FXML
    private Button btnVen;
    @FXML
    private Button btnCom;
    @FXML
    private Button btnCC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbox22.setAlignment(Pos.CENTER);
        vbox22.setSpacing(10);
        tx1.setText("Escoja su tipo de usuario o cambie su contraseña");
        btnVen.setText("Vendedor");
        btnCom.setText("Comprador");
        btnCC.setText("Cambiar Contraseña");
    }    

    @FXML
    private void Vendedor(ActionEvent event) {
        try {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuVCVendedor.fxml"));
            Parent root = loader.load();

            MenuVCVendedorController menuController = loader.getController();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Menú Vendedor");
            stage.show();

            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    @FXML
    private void Comprador(ActionEvent event) {
        try {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuVCComprador.fxml"));
            Parent root = loader.load();

            MenuVCCompradorController menuController = loader.getController();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Menú Comprador");
            stage.show();

            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cambiarContraseña(ActionEvent event) {
        try {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuCambiarContraseña.fxml"));
            Parent root = loader.load();

            MenuCambiarContraseñaController menuController = loader.getController();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Cambiar Contraseña");
            stage.show();

            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
