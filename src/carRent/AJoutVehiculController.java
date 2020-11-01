package carRent;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.SQLException;
import model.Voiture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import model.Bus;
import model.Camion;


public class AJoutVehiculController implements Initializable {

    @FXML
    private JFXTextField marque,modele, prixjour,penalite, capacite,nbplace,puissance,mat1,mat2;
    @FXML
    private JFXDatePicker assurance,visite;
    @FXML
    private RadioButton RBvoiture,RBbus,RBcamion;
    @FXML
    private void AjouterAction(ActionEvent event){
       
       try
        {
        String mat=mat1.getText()+"tun"+mat2.getText();
       String datAssur=assurance.getValue().toString();
       String datVis=visite.getValue().toString();
       if(RBvoiture.isSelected())
       {
       Voiture v=new Voiture(mat,marque.getText(),modele.getText(),puissance.getText(),datAssur,datVis,Integer.parseInt(prixjour.getText()),Integer.parseInt(penalite.getText()));
       v.ajouterVoiture();
       }
       else if (RBcamion.isSelected())
       {
       Camion camion=new Camion(mat,marque.getText(),modele.getText(),puissance.getText(),datAssur,datVis,Integer.parseInt(prixjour.getText()),Integer.parseInt(penalite.getText()),Integer.parseInt(capacite.getText()));
       camion.ajouterCamion();
       }
       else if (RBbus.isSelected())
       {
       Bus bus=new Bus(mat,marque.getText(),modele.getText(),puissance.getText(),datAssur,datVis,Integer.parseInt(prixjour.getText()),Integer.parseInt(penalite.getText()),Integer.parseInt(nbplace.getText()));
       bus.ajouterBus();
       }  
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION," Vehicule ajouté avec succes  ",ButtonType.FINISH);
        alert.showAndWait();
       }
       catch(SQLException ex)
       {
         Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides veuillez les verifiers ",ButtonType.CLOSE);
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
    
     marque.setText("");
     modele.setText("");
     prixjour.setText("");
     penalite.setText("");
     capacite.setText("");
     nbplace.setText("");
     puissance.setText("");mat1.setText("");mat2.setText("");
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
