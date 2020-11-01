/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carRent;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Config.config;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class LoginController implements Initializable {

    String chemin = "";

    String title = "";
    Stage primaryStage = new Stage();
    @FXML

    private Label LBerror;

    @FXML
    private ImageView erreur;

    @FXML
    private JFXTextField TUser;

    @FXML
    private JFXPasswordField Tpassword;
    @FXML
    private JFXButton BValider;
    @FXML
    private JFXButton Bnouveau;

    @FXML
    private void Nouveau(ActionEvent event) throws IOException, SQLException {
        Stage stage = new Stage();
        stage.setTitle("Nouvel employee");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("AjouterEmployee.fxml"))));
        stage.show();
        BValider.getScene().getWindow().hide();
    }

    //@FXML
    public void ChangerScene(ActionEvent event) throws IOException {

        try {
            String user = TUser.getText().toString();
            String password = Tpassword.getText().toString();
            String sql = "SELECT * FROM employee Where nom='" + user + "' and motdepass='" + password + "'";

            Connection con = config.getInstance().getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                erreur.setOpacity(1);
                LBerror.setTextFill(Color.BLACK);
                LBerror.setText("ENTREZ UN NOM D'UTILISATEUR / MOT DE PASSE VALIDE !");
            } else {
                erreur.setOpacity(0);
                try {
                    File ff = new File("utilisateur.txt");
                    ff.createNewFile();
                    FileWriter ffw = new FileWriter(ff);
                    ffw.write(user);
                    ffw.close();
                } catch (Exception e) {
                    System.out.println("erreur");
                }

                Stage stage = new Stage();
                stage.setTitle("Car Rent");
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"))));
                stage.show();
                BValider.getScene().getWindow().hide();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
