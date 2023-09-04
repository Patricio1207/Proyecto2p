/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MenuVCVendedorController implements Initializable {

    @FXML
    private Text txMenu;
    @FXML
    private VBox vboxVen;
    @FXML
    private Button btnReg;
    @FXML
    private Button btnOfe;
    @FXML
    private Button btnRegresar;
    @FXML
    private VBox vbMenu;
    @FXML
    private Text txTitulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbMenu.setAlignment(Pos.CENTER);
        vbMenu.setSpacing(10);
        txTitulo.setText("Menú del vendedor");
        txMenu.setText("Escoja la opción que desa realizar");
        vboxVen.setAlignment(Pos.CENTER);
        vboxVen.setSpacing(15);
        btnReg.setText("Registrar un vehículo");
        btnOfe.setText("Aceptar oferta");
        btnRegresar.setText("Regresar");
    }    

    @FXML
    private void registrarVehiculo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/viewRegistroVehiculo.fxml"));
            
            Parent root = loader.load();
            
            ViewRegistroVehiculoController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
//            stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            Stage myStage = (Stage) this.btnReg.getScene().getWindow();
            myStage.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void aceptarOferta(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/MenuAceptarOferta.fxml"));

            Parent root = loader.load();

            MenuAceptarOfertaController controlador = loader.getController();

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
    
}
