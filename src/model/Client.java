package model;

import Config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Client extends Personne{
    int id_client;

    public Client(String nom, String prenom, String dateNaissance, String adresse, int tel, String email, String cin) {
        super(nom, prenom, dateNaissance, adresse, tel, email, cin);
    }
    
     public Client(int id_client, String nom, String prenom, String dateNaissance, String adresse, int tel, String email, String cin) {
        super(nom, prenom, dateNaissance, adresse, tel, email, cin);
        this.id_client = id_client;
    }

    public Client()
    {
           }
    public Client(int id)
    {
        this.id_client=id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    public void ajouterClient() throws SQLException {

        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "INSERT INTO client(nom,prenom,dateNaissance,adresse,email,tel,cin) "
                + "Values ('"+this.nom+"','"+this.prenom+"','"+this.dateNaissance+"','"+this.adresse+"','"+this.email+"',"+this.tel +",'"+this.cin+"')";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
     
    }
    
    public void supprimerClient() throws SQLException {
        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "DELETE FROM client WHERE idclient="+this.id_client;
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
        Alert a = new Alert(Alert.AlertType.INFORMATION,"Client  Supprimé ",ButtonType.OK);
         a.showAndWait();

    }
    public boolean exist() throws SQLException
    {
        Connection con = config.getInstance().getConnection();

        ResultSet rs;
        rs = con.createStatement().executeQuery("SELECT * FROM client WHERE idclient="+this.id_client);
        if (rs.next())
            return true;
        else return false;
    }
    
        public void modifierClient() throws SQLException {
        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE client SET nom='"+this.nom+"',prenom='"+this.prenom+"',dateNaissance='"+this.dateNaissance+"',adresse='"+this.adresse+"',email='"+this.email+"',tel="+this.tel+",cin='"+this.cin+"' WHERE idclient="+this.id_client;
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();

    }
    
    
    
    
    
}