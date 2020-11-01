/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent;

import Config.config;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Employee;

public class AfficherEmployeeController implements Initializable {

      
      @FXML
    private TableView<Employee> table;
    @FXML
    private TableColumn<Employee, Integer> col_id;
    @FXML
    private TableColumn<Employee, String> col_nom;
    @FXML
    private TableColumn<Employee, String> col_prenom;
    @FXML
    private TableColumn<Employee, String> col_dateNaissance;
    @FXML
    private TableColumn<Employee, String> col_adresse;
    @FXML
    private TableColumn<Employee, Integer> col_tel;
    @FXML
    private TableColumn<Employee, String> col_email;
    @FXML
    private TableColumn<Employee, String> col_cin;
      @FXML
    private TextField recherche;
    
    ObservableList<Employee> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con =config.getInstance().getConnection();
            
            
            ResultSet rs;
            
            rs = con.createStatement().executeQuery("SELECT * FROM employee");
            
            System.out.println("f");
            while (rs.next())
                oblist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getInt(7),rs.getString(6),rs.getString(8)));
            
            
             System.out.println("f");
        
            
            col_id.setCellValueFactory(new PropertyValueFactory<>("id_employee"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_dateNaissance.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
            col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            col_cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
            
            System.out.println("ffff");
            
            table.setItems(oblist);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherClientController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

    }
    
     @FXML
        private void rechercher_employee(ActionEvent event) {
        table.getItems().clear();
        try {
            Connection con =config.getInstance().getConnection();
            
            
            ResultSet rs;
            
            rs = con.createStatement().executeQuery("SELECT * FROM employee WHERE idemployee="+recherche.getText());
            
            System.out.println("f");
            while (rs.next())
                oblist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getInt(7),rs.getString(6),rs.getString(8)));
            
            
             System.out.println("f");
        
            
            col_id.setCellValueFactory(new PropertyValueFactory<>("id_employee"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_dateNaissance.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
            col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            col_cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
            
            System.out.println("ffff");
            
            table.setItems(oblist);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherClientController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

    }
    
    
}
