package model;

import Config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Reservation {

    int id_reservation;
    int id_client;
    String matricule;
    LocalDate date_debut;
    LocalDate date_fin;
    LocalDate date_retour;
    int Cautionnement;
    int prix_total;

    public Reservation(int id_reservation, int id_client, String matricule, LocalDate date_debut, LocalDate date_fin, LocalDate date_retour, int caution) {
        this.id_reservation = id_reservation;
        this.id_client = id_client;
        this.matricule = matricule;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.date_retour = date_retour;
        this.Cautionnement = caution;
    }

    public Reservation(int id_client, String matricule, LocalDate date_debut, LocalDate date_fin, int caution) {
        this.id_client = id_client;
        this.matricule = matricule;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.Cautionnement = caution;
        this.date_retour = this.date_fin;
        try {
            this.prix_total = this.PrixTotal();
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Reservation(int id_reservation, int id_client, String matricule, LocalDate date_debut, LocalDate date_fin, int Cautionnement) {
        this.id_reservation = id_reservation;
        this.id_client = id_client;
        this.matricule = matricule;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.Cautionnement = Cautionnement;
        this.date_retour = this.date_fin;
        try {
            this.prix_total = this.PrixTotal();
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Reservation(int id) {
        this.id_reservation = id;
    }

    public LocalDate getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(LocalDate date_retour) {
        this.date_retour = date_retour;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public int getCautionnement() {
        return Cautionnement;
    }

    public int getPrix_total() {
        return prix_total;
    }

    public void setCautionnement(int Cautionnement) {
        this.Cautionnement = Cautionnement;
    }

    public void setPrix_total(int prix_total) {
        this.prix_total = prix_total;
    }
    
    

    public int getPrix_Cautionnement() {
        return Cautionnement;
    }

    public void setPrix_Cautionnement(int prix_totale) {
        this.Cautionnement = prix_totale;
    }

    public int PrixTotal() throws SQLException {
        int nbjour = (int) ChronoUnit.DAYS.between(date_debut, date_retour);
        int nbJourRetard = (int) ChronoUnit.DAYS.between(date_fin, date_retour);
        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "SELECT prix_jour,penalisation_jour FROM vehicule WHERE matricule ='" + this.matricule + "'";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) * nbjour + nbJourRetard * rs.getInt(2);
        } else {
            return 0;
        }
    }

    public void supprimerReservation() throws SQLException {
        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "DELETE FROM reservation WHERE id_reservation=" + this.id_reservation;
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
         Alert a = new Alert(Alert.AlertType.INFORMATION,"Rservation Supprimé ",ButtonType.OK);
         a.showAndWait();

    }

    public void ajouterReservation() throws SQLException {

        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "INSERT INTO reservation(idclient,matricule,date_debut,date_fin,date_retour,Cautionnement,prix_total) "
                + "Values (" + this.id_client + ",'" + this.matricule + "','" + this.date_debut + "','" + this.date_fin + "','" + this.date_retour + "'," + this.Cautionnement + "," + this.prix_total + ")";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();}
        
         public void MAJdispo() throws SQLException {

        Connection con = config.getInstance().getConnection();
         try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE vehicule SET disponibilite='Non disponible' WHERE matricule='"+this.matricule+"'";
        
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
        
        
    }
         
         public void modifierReservation() throws SQLException {
        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE reservation SET idclient="+this.id_client+",matricule='"+this.matricule+"',date_debut='"+this.date_debut+"',date_fin='"+this.date_fin+"',date_retour='"+this.date_retour+"',Cautionnement="+this.Cautionnement+" WHERE id_reservation="+this.id_reservation;
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();

    }
    public boolean exist() throws SQLException
    {
        Connection con = config.getInstance().getConnection();

        ResultSet rs;
        rs = con.createStatement().executeQuery("SELECT * FROM reservation WHERE id_reservation="+this.id_reservation);
        if (rs.next())
            return true;
        else return false;
    }
}
