/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent;

import Config.config;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import model.Client;
import model.Vehicule;
import sun.awt.IconInfo;

/**
 * FXML Controller class
 *
 * @author gamer
 */
public class SupprimerVehiculController implements Initializable {

    
    @FXML
    private JFXTextField mat1,mat2;
    
    @FXML
    private void SupprimerVehicule (ActionEvent event) throws SQLException  {
        String mat = mat1.getText() + "tun" + mat2.getText();
        Vehicule v=new Vehicule(mat);
        if (v.exist()==true)
        {        
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("CONFIRMATION");
                    alert.setHeaderText(null);
                    alert.setContentText("Voulez vous vraiment supprimer ce véhicule?");
                    Optional <ButtonType> result= alert.showAndWait();
                    if (result.get()== ButtonType.OK)
                    {v.supprimerVehicul();
                    
                    }
        }      
        else 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Ce vehicule n'existe pas ",ButtonType.CLOSE);
            alert.showAndWait();
            
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
