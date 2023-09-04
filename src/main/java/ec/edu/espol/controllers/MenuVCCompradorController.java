/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import ec.edu.espol.avance.App;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static ec.edu.espol.avance.App.filtrarVehiculos;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Personal
 */
public class MenuVCCompradorController implements Initializable {

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
    private ComboBox<String> cbTipo;
    @FXML
    private TextField txAñoMen;
    @FXML
    private TextField txAñoMay;
    @FXML
    private TextField txRecMen;
    @FXML
    private TextField txRecMay;
    @FXML
    private TextField txPreMen;
    @FXML
    private TextField txPreMay;
    @FXML
    private Button btnFiltrar;
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
    
    private ArrayList<Vehiculo> vehiculos;
    
    @FXML
    private Button btnOfertar;
    
    private int ultimoCodigoOferta = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vehiculos = App.vehiculos;
        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(10);
        tx1.setText("Realice una oferta");
        tx2.setText("Busque un vehíuclo y haga clic en la fila y presione Ofertar");
        hb1.setAlignment(Pos.CENTER);
        btnRegresar.setText("Regresar");
        btnOfertar.setText("Ofertar");
        cbTipo.getItems().addAll("Auto","Camioneta","Moto");
        
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
        
        ObservableList<Vehiculo> vehiculosObservable = FXCollections.observableArrayList(vehiculos);
        tbvw.setItems(vehiculosObservable);

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

    @FXML
    private void filtrar(ActionEvent event) {
        vehiculos = App.vehiculos;
        String tipo = cbTipo.getValue();
        try{
            double recInf = Double.parseDouble(txRecMen.getText());
            double recSup = Double.parseDouble(txRecMay.getText());
            int añoInf = Integer.parseInt(txAñoMen.getText());
            int añoSup = Integer.parseInt(txAñoMay.getText());
            double preInf = Double.parseDouble(txPreMen.getText());
            double preSup = Double.parseDouble(txPreMay.getText());
            ArrayList<Vehiculo> vehiculosFiltrados = filtrarVehiculos(tipo,recInf,recSup,añoInf,añoSup,preInf,preSup,vehiculos);
            
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
            ObservableList<Vehiculo> vehiculosObservable = FXCollections.observableArrayList(vehiculosFiltrados);
            tbvw.setItems(vehiculosObservable); // No sirve no se porqué
            
        }catch(NumberFormatException e){
            Alert a = new Alert(Alert.AlertType.ERROR,"Debe ingresar un número todas las casillas");
        }
        
    }

    @FXML
    private void ofertar(ActionEvent event) {
        Vehiculo vS = tbvw.getSelectionModel().getSelectedItem();
        if (vS != null){
            try {
                FXMLLoader loader = new FXMLLoader(MenuOfertarController.class.getResource("/ec/edu/espol/avance/MenuOfertar.fxml"));
                Parent root = loader.load();
                MenuOfertarController controlador = loader.getController();

            // Pasar datos del vehículo y el último código de oferta al controlador de la ventana de oferta
                controlador.setVehiculo(vS);
                controlador.setUltimoCodigoOferta(ultimoCodigoOferta);
                controlador.setTx(vS.getPlaca(), vS.getMarca(), vS.getModelo(), vS.getTipoMotor(), String.valueOf(vS.getAño()), String.valueOf(vS.getRecorrido()), vS.getColor(), vS.getCombustible(), String.valueOf(vS.getPrecio()), vS.getTipo());

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
            
            // Mostrar la ventana de oferta
                stage.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
//            try {
//        
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/MenuOfertarController.fxml"));
//                Parent root = loader.load();
//
//                MenuOfertarController Controller = loader.getController();
//            
//                Controller.setVehiculo(vehiculoSeleccionado);
//                Controller.setUltimoCodigoOferta(ultimoCodigoOferta);
//
//                Stage stage = new Stage();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//
//                ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }

    }
    public void actualizarUltimoCodigoOferta(int nuevoCodigo) {
        ultimoCodigoOferta = nuevoCodigo;
    }
    
    
}
