package model;

import Config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Voiture extends Vehicule {

    public Voiture(String matricule, String marque, String modele, String puissance, String assurance, String visite, String type, int prix_jour, int penalisation_jour) {
        super(matricule, marque, modele, puissance, assurance, visite, type, prix_jour, penalisation_jour);
    }

    public Voiture(String matricule, String marque, String modele, String puissance, String assurance, String visite, int prix_jour, int penalisation_jour) {
        super(matricule, marque, modele, puissance, assurance, visite, prix_jour, penalisation_jour);
    }

    public Voiture() {

    }

    public void ajouterVoiture() throws SQLException {

        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        String req = "INSERT INTO vehicule(matricule,marque,modele,puissance,prix_jour,penalisation_jour,assurance,visite,type) "
                + "values('" + this.matricule + "','" + this.marque + "','" + this.modele + "','" + this.puissance + "'," + this.prix_jour + "," + this.penalisation_jour + ",'" + this.assurance + "','" + this.visite + "','voiture')";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
    }

    public void modifierVoiture() throws SQLException {
        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE vehicule SET marque='" + this.marque + "',modele='" + this.modele + "',puissance='" + this.puissance + "',prix_jour=" + this.prix_jour + ",assurance='" + this.assurance + "', visite='" + this.visite + "',penalisation_jour=" + this.penalisation_jour + " WHERE matricule='" + this.matricule + "'";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();

    }

}
