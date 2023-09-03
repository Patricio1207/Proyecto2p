/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.avance.App;
import ec.edu.espol.model.Auto;
import static ec.edu.espol.model.Vehiculo.existVehiculo;
import static ec.edu.espol.avance.App.addVehiculo;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Patricio Vásquez
 */
public class ViewRegistroVehiculoController implements Initializable {

    @FXML
    private ChoiceBox<String> cboxTipo;
    @FXML
    private TextField txtPlaca;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtColor;
    @FXML
    private TextField txtRecorrido;
    @FXML
    private TextField txtCombustible;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtMotor;
    @FXML
    private TextField txtVidrios;
    @FXML
    private TextField txtAno;
    @FXML
    private TextField txtTransmision;
    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnRegistrarV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboxTipo.getItems().addAll("Auto","Camioneta","Moto");
        cboxTipo.setOnAction(actionEvent -> cboxTipo.getValue());
        
    } 
    
//    public void closeWindows()
//    {     
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewMenuVC.fxml"));
//            
//            Parent root = loader.load();
//            
//            ViewMenuVCController controlador = loader.getController();
//            
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            
//            stage.setScene(scene);
//            stage.show();
//            
//            Stage myStage = (Stage) this.btnRegresar.getScene().getWindow();
//            myStage.close();
//            
//        } catch (IOException ex) {
//            Logger.getLogger(ViewMenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }   
//    }

    @FXML
    private void registrarVehiculo(MouseEvent event) {
        String cboxTipo = this.cboxTipo.getValue();
        String txtPlaca = this.txtPlaca.getText();
        String txtMarca = this.txtMarca.getText();
        String txtModelo = this.txtModelo.getText();
        String txtColor = this.txtColor.getText();
        double txtRecorrido = Double.parseDouble(this.txtRecorrido.getText());
        String txtCombustible = this.txtCombustible.getText();
        double txtPrecio = Double.parseDouble(this.txtPrecio.getText());
        String txtMotor = this.txtMotor.getText();
        String txtVidrios = this.txtVidrios.getText();
        int txtAno = Integer.parseInt(this.txtAno.getText());
        String txtTransmision = this.txtTransmision.getText();
        
        Auto a = new Auto(txtPlaca,txtMarca,txtModelo,txtMotor,txtAno,txtRecorrido,txtColor,txtCombustible,txtPrecio,txtVidrios,txtTransmision);
        
        if(!existVehiculo(a,App.vehiculos)){
            addVehiculo(a);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Registrar Vehiculo");
            alert.setContentText("Vehiculo registrado existosamente");
            alert.showAndWait();
            
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Registrar Vehiculo");
            alert.setContentText("Vehiculo ya esta registrado");
            alert.showAndWait();
        }
    }

    @FXML
    private void regresar(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/MenuVCVendedor.fxml"));

            Parent root = loader.load();

            MenuVCVendedorController controlador = loader.getController();

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
