/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
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
public class SupprimerReservationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField idreservation;

    @FXML
    private void BSupprimerReser(ActionEvent event) throws IOException, SQLException {
        Reservation r = new Reservation(Integer.parseInt(idreservation.getText()));
        if (r.exist()==true)
        {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText(null);
        alert.setContentText("Voulez vous vraiment supprimer cette réservation?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) 
        {
            r.supprimerReservation();
        }
        }
        else 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Reservation inexistante",ButtonType.CLOSE);
            alert.showAndWait();
        }
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
