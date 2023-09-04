/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import static ec.edu.espol.avance.App.addOffer;
import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.Vehiculo;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Personal
 */
public class MenuOfertarController implements Initializable {

    @FXML
    private TextField txtoferta;
    @FXML
    private Button btnOfertar;
    @FXML
    private Button btnRegresar;
    @FXML
    private Text tx1;
    @FXML
    private Text tx2;
    
    private Vehiculo vehiculo;
    private int ultimoCodigoOferta;
    @FXML
    private Text tx3;
    @FXML
    private Text tx4;
    @FXML
    private Text tx5;
    @FXML
    private Text tx6;
    @FXML
    private Text tx7;
    @FXML
    private Text tx8;
    @FXML
    private Text tx9;
    @FXML
    private Text tx10;
    @FXML
    private ImageView imgv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        tx1.setText("Placa: "+this.vehiculo.getPlaca()); //Quiero agregar las vainas del carro pero no me deja
//        tx2.setText("Marca: "+this.vehiculo.getMarca()); //Si descomentas no te deja pasar sgte pagina
//        tx3.setText("Modelo: "+this.vehiculo.getModelo());
//        tx4.setText("Motor: "+this.vehiculo.getTipoMotor());
//        tx5.setText("Año: "+this.vehiculo.getAño());
//        tx6.setText("Recorrido: "+this.vehiculo.getRecorrido());
//        tx7.setText("Color: "+this.vehiculo.getColor());
//        tx8.setText("Combustible: "+this.vehiculo.getCombustible());
//        tx9.setText("Precio: "+this.vehiculo.getPrecio());
//        tx10.setText("Tipo: "+this.vehiculo.getTipo());
        Image im = new Image("img/auto1.jpeg");
        imgv.setImage(im);
    }    

    @FXML
    private void realizarOferta(ActionEvent event) {
        String precioStr = txtoferta.getText();
        try{
            double precio = Double.parseDouble(precioStr);
            ultimoCodigoOferta++;
            String codigoOferta = String.format("%03d", ultimoCodigoOferta);
            Oferta oferta = new Oferta(vehiculo,precio, codigoOferta);//Creo que le falta this al vehiculo, compruebalo cuando aceptes oferta
            addOffer(oferta);
            Alert a = new Alert(Alert.AlertType.INFORMATION,"La oferta fue realizada con éxito");
            a.show();
        }catch(NumberFormatException e){
            Alert a = new Alert(Alert.AlertType.ERROR,"Debe ingresar un valor númerico");
            a.show();
        }
        txtoferta.setText("");
    }

    @FXML
    private void regresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/avance/MenuVCComprador.fxml"));

            Parent root = loader.load();

            MenuVCCompradorController controlador = loader.getController();

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
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public void setUltimoCodigoOferta(int ultimoCodigoOferta) {
        this.ultimoCodigoOferta = ultimoCodigoOferta;
    }

}
