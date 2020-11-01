package carRent;

import Config.config;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Vehicule;

public class AfficherVehiculeController implements Initializable {

    String chemin = "";
    @FXML
    private TableView<Vehicule> table;

    @FXML
    private TableColumn<Vehicule, String> col_matricule;
    @FXML
    private TableColumn<Vehicule, String> col_modele;
    @FXML
    private TableColumn<Vehicule, String> col_marque;
    @FXML
    private TableColumn<Vehicule, String> col_puissance;
    @FXML
    private TableColumn<Vehicule, String> col_assurance;
    @FXML
    private TableColumn<Vehicule, String> col_type;
    @FXML
    private TableColumn<Vehicule, String> col_visite;
    @FXML
    private TableColumn<Vehicule, String> col_dispo;
    @FXML
    private TableColumn<Vehicule, Integer> col_prix;
    @FXML
    private TableColumn<Vehicule, Integer> col_penalisation;

    ObservableList<Vehicule> oblist = FXCollections.observableArrayList();

    @FXML
    private Pane afficheListe;
    @FXML
    private JFXRadioButton BVoiture, BBus, BCamion;

    @FXML
    private void handleBVoitureAction(ActionEvent event) {

        chemin = "AfficherVoiture.fxml";
        new OpenWindow(afficheListe, chemin);

    }

    @FXML
    private void handleBBusAction(ActionEvent event) {

        chemin = "AfficherBus.fxml";
        new OpenWindow(afficheListe, chemin);

    }

    @FXML
    private void handleBCamionAction(ActionEvent event) {

        chemin = "AfficherCamion.fxml";
        new OpenWindow(afficheListe, chemin);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con = config.getInstance().getConnection();

            ResultSet rs;

            rs = con.createStatement().executeQuery("SELECT * FROM vehicule");

            while (rs.next()) {
                Vehicule v = new Vehicule(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(5), rs.getInt(6));
                oblist.add(v);
            }

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

            table.setItems(oblist);

        } catch (SQLException ex) {
            Logger.getLogger(AfficherClientController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

}
