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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Client;

public class AjoutClientController implements Initializable {

    @FXML
    private JFXTextField TNom, Tprenom, Tadresse, Temail, Ttel, Tcin;
    @FXML
    private JFXDatePicker TDate;

    @FXML
    private void handleBEnregistrer(ActionEvent event) {
         try
        {
        String x=TDate.getValue().toString();
        Client c= new Client(TNom.getText(),Tprenom.getText(),x,Tadresse.getText(),Integer.parseInt(Ttel.getText()),Temail.getText(),Tcin.getText());
       
            c.ajouterClient();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION," Client ajouté avec succes  ",ButtonType.FINISH);
        alert.showAndWait();
        }
        catch(SQLException ex )
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
    
     TNom.setText("");
     Tprenom.setText("");
     Tadresse.setText("");
     Temail.setText("");
     Ttel.setText("");
     Tcin.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
