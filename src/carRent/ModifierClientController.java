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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import model.Client;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifierClientController implements Initializable {

    @FXML
    private Button chercher;

    @FXML
    private JFXTextField id, Tcin, Tnom, Tprenom, Tnum, Temail, Tadresse;
    @FXML
    private DatePicker Tdate;

    @FXML
    private void AffichClient(ActionEvent event) throws SQLException {
    try {
        Connection con = config.getInstance().getConnection();

        ResultSet rs;

        rs = con.createStatement().executeQuery("SELECT * FROM client WHERE idclient=" + Integer.parseInt(id.getText()));
          if (rs.next()) {
                id.setText(rs.getString(1));
                Tcin.setText(rs.getString(8));
                Tnom.setText(rs.getString(2));
                Tprenom.setText(rs.getString(3));
                Temail.setText(rs.getString(6));
                Tadresse.setText(rs.getString(5));
                Tnum.setText(String.valueOf(rs.getInt(7)));
                Tdate.setValue(rs.getDate(4).toLocalDate());
            } else {
                System.out.println("non trouvé");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("CLIENT INCONNU");
                alert.setHeaderText(null);
                alert.setContentText("Il n'existe pas de client avec un tel ID");
                alert.showAndWait();
            }
        } catch (Exception ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }
        

    }

    @FXML
    private void modifierClient(ActionEvent event) {
        try {
        String x = Tdate.getValue().toString();
        Client c = new Client(Integer.parseInt(id.getText()), Tnom.getText(), Tprenom.getText(), x, Tadresse.getText(), Integer.parseInt(Tnum.getText()), Temail.getText(), Tcin.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("CONFIRMATION");
                    alert.setHeaderText(null);
                    alert.setContentText("Voulez vous vraiment Modifier le client  ?");
                    Optional <ButtonType> result= alert.showAndWait();
                     if (result.get()== ButtonType.OK)
                    {
                            c.modifierClient();
                             Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Client Modifié ",ButtonType.OK);
         a.showAndWait();
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierClientController.class.getName()).log(Level.SEVERE, null, ex);
        }        catch (Exception ex) {
             Alert a = new Alert(Alert.AlertType.ERROR,"Veuillez Verifier les donnees saisises ",ButtonType.OK);
         a.showAndWait();
        }

    }
    @FXML
    private void Annuler(ActionEvent event)  {
    
     Tnom.setText("");
     Tprenom.setText("");
     Tadresse.setText("");
     Temail.setText("");
     Tnum.setText("");
     Tcin.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
