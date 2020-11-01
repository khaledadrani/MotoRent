/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Reservation;

/**
 * FXML Controller class
 *
 * @author gamer
 */
public class AjoutReservationController implements Initializable {

    @FXML
    private JFXTextField idclient,mat1,mat2,caution;
    @FXML
    private JFXDatePicker dated,datef;
    @FXML
    private void AjoutReservation(ActionEvent event){
        try
        {String mat=mat1.getText()+"tun"+mat2.getText();
        LocalDate dateDebut=dated.getValue();
        LocalDate dateFin=datef.getValue();
        Reservation r=new Reservation(Integer.parseInt(idclient.getText()),mat,dateDebut,dateFin,Integer.parseInt(caution.getText()));
        r.ajouterReservation();
        r.MAJdispo();
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION," Reservation ajoutée avec succes  ",ButtonType.FINISH);
        alert.showAndWait();
        }
        catch(SQLException ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }
        catch(RuntimeException ex)
        {
             Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }
    }
    @FXML
    private void Annuler(ActionEvent event)  {
    
     idclient.setText("");
     mat1.setText("");
     mat2.setText("");
     caution.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
