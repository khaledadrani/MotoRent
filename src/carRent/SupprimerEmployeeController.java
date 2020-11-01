/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Employee;

/**
 * FXML Controller class
 *
 * @author gamer
 */
public class SupprimerEmployeeController implements Initializable {

    @FXML
    private JFXTextField idemp;

    @FXML
    private void SupprimerEmp(ActionEvent event) throws SQLException {
        Employee e = new Employee(Integer.parseInt(idemp.getText()));
        if (e.exist())
        {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText(null);
        alert.setContentText("Voulez vous vraiment supprimer cet employé?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            e.supprimerEmployee();
        }
        }
        else 
        {
        Alert alert = new Alert(Alert.AlertType.ERROR,"Empolyé inexistant",ButtonType.CLOSE);
            alert.showAndWait();
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
