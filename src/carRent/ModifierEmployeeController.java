package carRent;

import Config.config;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import model.Employee;

public class ModifierEmployeeController implements Initializable {

    @FXML
    private Button chercher;

    @FXML
    private JFXTextField id, Tcin, Tnom, Tprenom, Tnum, Temail, Tadresse;

    @FXML
    private DatePicker Tdate;
    @FXML
    private JFXPasswordField Tmdp,expdp,exmdpd;

    @FXML
    private void AffichEmployee(ActionEvent event) throws SQLException {

        Connection con = config.getInstance().getConnection();

        ResultSet rs;

        rs = con.createStatement().executeQuery("SELECT * FROM employee WHERE idemployee=" + Integer.parseInt(id.getText()));

        System.out.println("f");
        try {
            if (rs.next()) {
                id.setText(rs.getString(1));
                Tcin.setText(rs.getString(8));
                Tnom.setText(rs.getString(2));
                Tprenom.setText(rs.getString(3));
                Temail.setText(rs.getString(7));
                Tnum.setText(String.valueOf(rs.getInt(6)));
                Tadresse.setText(rs.getString(5));

            } else {
                System.out.println("non trouvé");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("EMPLOYEE INCONNU");
                alert.setHeaderText(null);
                alert.setContentText("Il n'existe pas d'employé avec un tel ID");
                alert.showAndWait();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("f");

    }

    @FXML
    private void modifierEmployee(ActionEvent event)  {
        
        try {
            Connection con = config.getInstance().getConnection();
            
            ResultSet rs;
            
            rs = con.createStatement().executeQuery("SELECT * FROM employee WHERE idemployee=" + Integer.parseInt(id.getText()));
            
            
            if(rs.next())
            { 
            if (Tmdp.getText()==exmdpd.getText())
            {Employee c = new Employee(Integer.parseInt(id.getText()), Tnom.getText(), Tprenom.getText(), rs.getDate(4).toString(), Tadresse.getText(), Integer.parseInt(Tnum.getText()), Temail.getText(), Tcin.getText(), Tmdp.getText());
            c.modifierEmployee();}
            else 
            {
                Alert a = new Alert(Alert.AlertType.ERROR,"Mots de pass nont identiques  ",ButtonType.OK);
         a.showAndWait();
            }   
            }
        } catch (Exception ex) {
            Logger.getLogger(ModifierEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
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
     Tmdp.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
