/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.Employee;

/**
 * FXML Controller class
 *
 * @author gamer
 */
public class AjouterEmployeeController implements Initializable {

    @FXML
    private JFXTextField TNom, Tprenom, Tadresse, Temail, Tnum, Tcin;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXPasswordField Tmdp;

    @FXML
    private Button BAjout;

    @FXML
    private void handleBAjout(ActionEvent event)  {
        try{
        String x = date.getValue().toString();
        Employee e = new Employee(Tmdp.getText(), TNom.getText(), Tprenom.getText(), x, Tadresse.getText(), Integer.parseInt(Tnum.getText()), Temail.getText(), Tcin.getText());
        e.ajouterEmployee();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("AJOUT AVEC SUCCES");
        alert.setHeaderText(null);
        alert.setContentText("L'employé "+e.getPrenom()+" "+e.getNom()+" a été ajouté avec succès");
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
        try {
        Stage stage = new Stage();
        stage.setTitle("Car Rent");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login.fxml"))));
                    stage.show();
        BAjout.getScene().getWindow().hide();
        } 
        catch (IOException ex) {
            Logger.getLogger(AjouterEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
