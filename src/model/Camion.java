
package model;

import Config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Camion extends Vehicule{
    
    int capacite;

    public Camion(int capacite, String matricule, String marque, String modele, String puissance, String assurance, String visite, String type, int prix_jour, int penalisation_jour) {
        super(matricule, marque, modele, puissance, assurance, visite, type, prix_jour, penalisation_jour);
        this.capacite = capacite;
    }

    public Camion(String matricule, String marque, String modele, String puissance, String assurance, String visite, int prix_jour, int penalisation_jour,int capacite) {
        super(matricule, marque, modele, puissance, assurance, visite, prix_jour, penalisation_jour);
        this.capacite = capacite;
    }

  
    
  

    public Camion() {
   
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public void ajouterCamion() throws SQLException {

        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "INSERT INTO vehicule(matricule,marque,modele,puissance,prix_jour,penalisation_jour,assurance,visite,capacite,type) "
                + "values('"+this.matricule+"','"+this.marque+"','"+this.modele+"','"+this.puissance+"',"+this.prix_jour+","+this.penalisation_jour+",'"+this.assurance+"','"+this.visite+"',"+this.capacite+",'camion')";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
    }
    
    
            public void modifierCamion() throws SQLException {
        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE vehicule SET marque='"+this.marque+"',modele='"+this.modele+"',puissance='"+this.puissance+"',prix_jour="+this.prix_jour+",assurance='"+this.assurance+"', visite='"+this.visite+"',penalisation_jour="+this.penalisation_jour+",capacite="+this.capacite+" WHERE matricule='"+this.matricule+"'";     
         PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();

    }
    
}