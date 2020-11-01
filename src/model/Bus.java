package model;

import Config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Bus extends Vehicule {

    int nb_places;

    public Bus(String matricule, String marque, String modele, String puissance, String assurance, String visite, int prix_jour, int penalisation_jour, int nb_places) {
        super(matricule, marque, modele, puissance, assurance, visite, prix_jour, penalisation_jour);
        this.nb_places = nb_places;
    }

    public Bus(int nb_places, String matricule, String marque, String modele, String puissance, String assurance, String visite, String type, int prix_jour, int penalisation_jour) {
        super(matricule, marque, modele, puissance, assurance, visite, type, prix_jour, penalisation_jour);
        this.nb_places = nb_places;
    }

    public Bus() {
    }

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    public void ajouterBus() throws SQLException {

        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "INSERT INTO vehicule(matricule,marque,modele,puissance,prix_jour,penalisation_jour,assurance,visite,nbPlace,type) "
                + "values('" + this.matricule + "','" + this.marque + "','" + this.modele + "','" + this.puissance + "'," + this.prix_jour + "," + this.penalisation_jour + ",'" + this.assurance + "','" + this.visite + "'," + this.nb_places + ",'bus')";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
    }

    public void modifierBus() throws SQLException {
        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE vehicule SET marque='" + this.marque + "',modele='" + this.modele + "',puissance='" + this.puissance + "',prix_jour=" + this.prix_jour + ",assurance='" + this.assurance + "', visite='" + this.visite + "',penalisation_jour=" + this.penalisation_jour + ",nbPlace=" + this.nb_places + " WHERE matricule='" + this.matricule + "'";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();

    }

}
