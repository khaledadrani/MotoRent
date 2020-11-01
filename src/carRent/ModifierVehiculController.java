
package carRent;

import Config.config;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.layout.Pane;
import model.Bus;
import model.Camion;
import model.Voiture;

/**
 * FXML Controller class
 *
 * @author gamer
 */
public class ModifierVehiculController implements Initializable {

    @FXML
    private Button chercher;
        @FXML
    private Pane p;
    @FXML
    private JFXTextField penalite, marque, modele, prixjour, capacite, nbplace, puissance, Tmat1, Tmat2;
    @FXML
    private JFXDatePicker assurance, visite;

    @FXML
    private void AffichVehicul(ActionEvent event) throws SQLException {
        
        try {
        Connection con = config.getInstance().getConnection();
        ResultSet rs;
        String mat = Tmat1.getText() + "tun" + Tmat2.getText();
        rs = con.createStatement().executeQuery("SELECT * FROM vehicule WHERE matricule='" + mat + "'");
        System.out.println("f");

            if (rs.next()) {
                p.setOpacity(1);
                marque.setText(rs.getString(2));
                modele.setText(rs.getString(3));
                prixjour.setText(rs.getString(5));
                assurance.setValue(rs.getDate(7).toLocalDate());
                visite.setValue(rs.getDate(8).toLocalDate());
                nbplace.setText(rs.getString(11));
                capacite.setText(rs.getString(10));
                puissance.setText(rs.getString(4));
                penalite.setText(rs.getString(6));
            } else {
                System.out.println("non trouvé");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("VEHICULE INCONNU");
                alert.setHeaderText(null);
                alert.setContentText("Il n'existe pas de vehicule avec une telle matricule");
                alert.showAndWait();
            }
        }
        catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }


    }

    @FXML
    private void modifierVehicule(ActionEvent event) throws SQLException {
           try {
        Connection con = config.getInstance().getConnection();
        ResultSet rs;
        String mat = Tmat1.getText() + "tun" + Tmat2.getText();
        String datAssur = assurance.getValue().toString();
        String datVis = visite.getValue().toString();
        rs = con.createStatement().executeQuery("SELECT * FROM vehicule WHERE matricule='"+mat+"'");
        System.out.println("f");
            if (rs.next()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("CONFIRMATION");
                    alert.setHeaderText(null);
                    alert.setContentText("Voulez vous vraiment Modifier le  véhicule "+mat+" ");
                    Optional <ButtonType> result= alert.showAndWait();
                    if (result.get()== ButtonType.OK)
                    {
                if (rs.getString(9).intern() == "voiture") 
                {      System.out.println("if voiture");
                    Voiture v = new Voiture(mat, marque.getText(), modele.getText(), puissance.getText(), datAssur, datVis, Integer.parseInt(prixjour.getText()), Integer.parseInt(penalite.getText()));
                    v.modifierVoiture();
                } 
                else if (rs.getString(9).intern() == "camion") 
                {

                    Camion camion = new Camion(mat, marque.getText(), modele.getText(), puissance.getText(), datAssur, datVis, Integer.parseInt(prixjour.getText()), Integer.parseInt(penalite.getText()), Integer.parseInt(capacite.getText()));
                    camion.modifierCamion();
                } 
                else if (rs.getString(9).intern() == "bus") 
                {
                    Bus bus = new Bus(mat, marque.getText(), modele.getText(), puissance.getText(), datAssur, datVis, Integer.parseInt(prixjour.getText()), Integer.parseInt(penalite.getText()), Integer.parseInt(nbplace.getText()));
                    bus.modifierBus();
                }
             Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Vehicule Modifié ",ButtonType.OK);
         a.showAndWait();
                    }
                    }
        } catch (Exception ex) {
             Alert a = new Alert(Alert.AlertType.ERROR,"Veuillez Verifier les donnees saisises ",ButtonType.OK);
         a.showAndWait();
        }
       
    }
    @FXML
    private void Annuler(ActionEvent event)  {
    
     marque.setText("");
     modele.setText("");
     prixjour.setText("");
     penalite.setText("");
     capacite.setText("");
     nbplace.setText("");
     puissance.setText("");Tmat1.setText("");Tmat2.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
