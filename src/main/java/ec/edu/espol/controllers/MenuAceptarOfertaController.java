/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import archivos.Utilidades;
import ec.edu.espol.avance.App;
import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.Vehiculo;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Patricio Vásquez
 */
public class MenuAceptarOfertaController implements Initializable {


    @FXML
    private VBox vb1;
    @FXML
    private Text tx1;
    @FXML
    private Text tx2;
    @FXML
    private HBox hb1;
    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnAceptarOfertar;
    @FXML
    private TableView<Vehiculo> tbvw;
    @FXML
    private TableColumn<Vehiculo, String> placaColumn;
    @FXML
    private TableColumn<Vehiculo, String> marcaColumn;
    @FXML
    private TableColumn<Vehiculo, String> modeloColumn;
    @FXML
    private TableColumn<Vehiculo, String> tipoMotorColumn;
    @FXML
    private TableColumn<Vehiculo, String> añoColumn;
    @FXML
    private TableColumn<Vehiculo, String> recorridoColumn;
    @FXML
    private TableColumn<Vehiculo, String> colorColumn;
    @FXML
    private TableColumn<Vehiculo, String> combustibleColumn;
    @FXML
    private TableColumn<Vehiculo, String> precioColumn;
    @FXML
    private TableColumn<Vehiculo, String> tipoColumn;
    
    private ArrayList<Oferta> ofertas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ofertas = App.ofertas;
        //vehiculos = App.vehiculos;
        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(10);
        tx1.setText("Revise las ofertas");
        tx2.setText("Presione aceptar oferta");
        hb1.setAlignment(Pos.CENTER);
        btnRegresar.setText("Regresar");
        btnAceptarOfertar.setText("Aceptar Oferta");
        
        placaColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getPlaca()));
        marcaColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMarca()));
        modeloColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getModelo()));
        tipoMotorColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTipoMotor()));
        añoColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getAño())));
        recorridoColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getRecorrido())));
        colorColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getColor()));
        combustibleColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCombustible()));
        precioColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getPrecio())));
        tipoColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getTipo())));
        ArrayList<Vehiculo> vehs = new ArrayList<>();
        for(Oferta of:ofertas){
            vehs.add(of.getVehiculo());
        }
        ObservableList<Vehiculo> vehiculosObservable = FXCollections.observableArrayList(vehs);
        tbvw.setItems(vehiculosObservable);
    }    
    
    @FXML
    private void regresar(ActionEvent event) {
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

    @FXML
    private void aceptarOfertas(ActionEvent event) {
        if(ofertas.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Aceptacion de oferta");
            alert.setContentText("No hay ninguna oferta");
            alert.showAndWait();
        }else{
            Utilidades.enviarConGMail(App.lUs.get(0).getCorreoElectronico(), App.lUs.get(0).getClave(), App.lUs.get(0).getCorreoElectronico(), "Confirmacion de oferta", "Felicidades, el vendedor acaba de confirmar su oferta");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Aceptacion de oferta");
            alert.setContentText("Oferta Aceptada");
            alert.showAndWait();
            ofertas.remove(0);
        
        }
    }

}
