/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.avance.controller;

import static ec.edu.espol.avance.App.mostrarVehiculos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Patricio Vásquez
 */
public class ViewBuscarVehiculoController implements Initializable {

    @FXML
    private ChoiceBox<String> cboxTipo;
    @FXML
    private TextField txtRecInf;
    @FXML
    private TextField txtRecSup;
    @FXML
    private TextField txtAnoInf;
    @FXML
    private TextField txtAnoSup;
    @FXML
    private TextField txtPrecioInf;
    @FXML
    private TextField txtPrecioSup;
    @FXML
    private Button btnFiltrar;
    @FXML
    private Button btnRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboxTipo.getItems().addAll("Auto","Camioneta","Moto");
        cboxTipo.setOnAction(actionEvent -> cboxTipo.getValue());
    }    

    public void closeWindows()
    {     
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/viewMenuVC.fxml"));
            
            Parent root = loader.load();
            
            ViewMenuVCController controlador = loader.getController();
            
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
    private void filtrar(ActionEvent event) {
        String cboxTipo = this.cboxTipo.getValue();
        double txtRecInf = Double.parseDouble(this.txtRecInf.getText());
        double txtRecSup = Double.parseDouble(this.txtRecSup.getText());
        int txtAnoInf = Integer.parseInt(this.txtAnoInf.getText());
        int txtAnoSup = Integer.parseInt(this.txtAnoSup.getText());
        double txtPrecioInf = Double.parseDouble(this.txtPrecioInf.getText());
        double txtPrecioSup = Double.parseDouble(this.txtPrecioSup.getText());
        
        mostrarVehiculos(cboxTipo,txtRecInf,txtRecSup,txtAnoInf,txtAnoSup,txtPrecioInf,txtPrecioSup);
    }

    @FXML
    private void regresar(ActionEvent event) {
    }
    
}
