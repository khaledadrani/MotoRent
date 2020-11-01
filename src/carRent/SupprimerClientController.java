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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import model.Client;

public class SupprimerClientController implements Initializable {

    @FXML
    private Button SuppClient;

    @FXML
    private JFXTextField id;

    @FXML
    private void SupprimerClient(ActionEvent event) throws SQLException {
        Client c = new Client(Integer.parseInt(id.getText()));
        if(c.exist())
        {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText(null);
        alert.setContentText("Voulez vous vraiment supprimer ce client?");
       
        Optional <ButtonType> result= alert.showAndWait();
        if (result.get()== ButtonType.OK)
        {c.supprimerClient();}
        }
        else 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Client  inexistant",ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
