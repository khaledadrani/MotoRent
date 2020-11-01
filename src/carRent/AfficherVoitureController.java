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
import model.Vehicule;
import model.Voiture;

public class AfficherVoitureController implements Initializable {
    @FXML
    private TableView<Voiture> table;
    
    @FXML
    private TableColumn<Voiture, String> col_matricule;
    @FXML
    private TableColumn<Voiture, String> col_modele;
    @FXML
    private TableColumn<Voiture, String> col_marque;
    @FXML
    private TableColumn<Voiture, String> col_puissance;
    @FXML
    private TableColumn<Voiture, String> col_assurance;
    @FXML
    private TableColumn<Voiture, String> col_type;
    @FXML
    private TableColumn<Voiture, String> col_visite;
    @FXML
    private TableColumn<Voiture, String> col_dispo;
    @FXML
    private TableColumn<Voiture, Integer> col_prix;
    @FXML
    private TableColumn<Voiture, Integer> col_penalisation;
    
    ObservableList<Voiture> oblist = FXCollections.observableArrayList();
    
        
        @FXML
    private TextField recherche;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con =config.getInstance().getConnection();
            
            
            ResultSet rs;
            
            rs = con.createStatement().executeQuery("SELECT * FROM vehicule where type='voiture'");
            
            System.out.println("f");
            while (rs.next())
            {   Voiture v=new Voiture(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(5),rs.getInt(6));
                oblist.add(v);
            }
            
            
             System.out.println("f");
             
             
            col_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
            col_modele.setCellValueFactory(new PropertyValueFactory<>("modele"));
            col_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
            col_puissance.setCellValueFactory(new PropertyValueFactory<>("puissance"));
            col_assurance.setCellValueFactory(new PropertyValueFactory<>("assurance"));
            
            col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
            col_visite.setCellValueFactory(new PropertyValueFactory<>("visite"));
            col_dispo.setCellValueFactory(new PropertyValueFactory<>("dispo"));
            col_prix.setCellValueFactory(new PropertyValueFactory<>("prix_jour"));
            col_penalisation.setCellValueFactory(new PropertyValueFactory<>("penalisation_jour"));
            
            System.out.println("ffff");
            
            table.setItems(oblist);
            System.out.println("ffff");
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherClientController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }    
 @FXML
    private void rechercher_voiture(ActionEvent event) {
        table.getItems().clear();
        try {
            Connection con =config.getInstance().getConnection();
            
            
            ResultSet rs;
            
            rs = con.createStatement().executeQuery("SELECT * FROM vehicule where type='voiture' and matricule='"+recherche.getText()+"'");
            
            System.out.println("f");
            while (rs.next())
            {   Voiture v=new Voiture(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(5),rs.getInt(6));
                oblist.add(v);
            }
            
            
             System.out.println("f");
             
             
            col_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
            col_modele.setCellValueFactory(new PropertyValueFactory<>("modele"));
            col_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
            col_puissance.setCellValueFactory(new PropertyValueFactory<>("puissance"));
            col_assurance.setCellValueFactory(new PropertyValueFactory<>("assurance"));
            
            col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
            col_visite.setCellValueFactory(new PropertyValueFactory<>("visite"));
            col_dispo.setCellValueFactory(new PropertyValueFactory<>("dispo"));
            col_prix.setCellValueFactory(new PropertyValueFactory<>("prix_jour"));
            col_penalisation.setCellValueFactory(new PropertyValueFactory<>("penalisation_jour"));
            
            System.out.println("ffff");
            
            table.setItems(oblist);
            System.out.println("ffff");
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherClientController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }    
}
