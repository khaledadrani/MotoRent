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
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Reservation;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AfficherReservationController implements Initializable {

      @FXML
    private TableView<Reservation> table;
    @FXML
    private TableColumn<Reservation, Integer> col_id_res;
    @FXML
    private TableColumn<Reservation, Integer> col_id_client;
    @FXML
    private TableColumn<Reservation, String> col_matricule;
    @FXML
    private TableColumn<Reservation, LocalDate> col_date_debut;
    @FXML
    private TableColumn<Reservation, LocalDate> col_date_fin;
    @FXML
    private TableColumn<Reservation, LocalDate> col_date_retour;
    @FXML
    private TableColumn<Reservation, Integer> col_cautionnement;
    @FXML
    private TableColumn<Reservation, Integer> col_prix_final;
    
    ObservableList<Reservation> oblist = FXCollections.observableArrayList();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Connection con =config.getInstance().getConnection();
            
            
            ResultSet rs;
            
            rs = con.createStatement().executeQuery("SELECT * FROM reservation");
            
            System.out.println("f");
            while (rs.next())
            {   Reservation r=new Reservation(rs.getInt(1),rs.getInt(2),rs.getString(3),
                        rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate(),rs.getInt(7));
                oblist.add(r);
            }
            
            
             System.out.println("f");
        
            col_cautionnement.setCellValueFactory(new PropertyValueFactory<>("Cautionnement"));
            col_prix_final.setCellValueFactory(new PropertyValueFactory<>("prix_total"));
            col_id_res.setCellValueFactory(new PropertyValueFactory<>("id_reservation"));
            col_id_client.setCellValueFactory(new PropertyValueFactory<>("id_client"));
            col_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
            col_date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
            col_date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
            col_date_retour.setCellValueFactory(new PropertyValueFactory<>("date_retour"));
           
            
            System.out.println("ffff");
            
            table.setItems(oblist);
            System.out.println("ffff");
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherClientController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

    }   
    
}
