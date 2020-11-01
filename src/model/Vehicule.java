package model;

import Config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Vehicule {

    protected String matricule, marque, modele, puissance, assurance, visite, dispo="Disponible",type;
    protected int prix_jour, penalisation_jour;

    public Vehicule(String matricule, String marque, String modele, String puissance, String assurance, String visite, String type, int prix_jour, int penalisation_jour) {
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.assurance = assurance;
        this.visite = visite;
        this.type = type;
        this.prix_jour = prix_jour;
        this.penalisation_jour = penalisation_jour;
    }
    
    public Vehicule(String matricule, String marque, String modele, String puissance, String assurance, String visite, int prix_jour, int penalisation_jour) {
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.assurance = assurance;
        this.visite = visite;
        this.prix_jour = prix_jour;
        this.penalisation_jour = penalisation_jour;
    }
    

    public Vehicule(String mat) {
        this.matricule = mat;
    }

    public Vehicule() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisite() {
        return visite;
    }

    public void setVisite(String visite) {
        this.visite = visite;
    }

    public String getDispo() {
        return dispo;
    }

    public void setDispo(String dispo) {
        this.dispo = dispo;
    }

    public int getPenalisation_jour() {
        return penalisation_jour;
    }

    public void setPenalisation_jour(int penalisation_jour) {
        this.penalisation_jour = penalisation_jour;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public String getExpiration() {
        return visite;
    }

    public void setExpiration(String expiration) {
        this.visite = expiration;
    }

    public int getPrix_jour() {
        return prix_jour;
    }

    public void setPrix_jour(int prix_jour) {
        this.prix_jour = prix_jour;
    }
    public boolean exist() throws SQLException
    {
        Connection con = config.getInstance().getConnection();

        ResultSet rs;
        rs = con.createStatement().executeQuery("SELECT * FROM vehicule WHERE matricule='" + matricule + "'");
        if (rs.next())
            return true;
        else return false;
    }
    public void supprimerVehicul() throws SQLException  {
        Connection con = config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "DELETE FROM vehicule WHERE matricule ='" + this.matricule + "'";
        PreparedStatement preparedStatement;

        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
        Alert a = new Alert(Alert.AlertType.INFORMATION,"Vehicule Supprimé ",ButtonType.OK);
         a.showAndWait();
        

                }      
    }
    



