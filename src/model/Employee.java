
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


public class Employee extends Personne{
    String mdp;
    int id_employee;

    public Employee(int id_employee, String nom, String prenom, String dateNaissance, String adresse, int tel, String email,String CIN,String mdp) {
        super(nom, prenom, dateNaissance, adresse, tel, email,CIN);
        this.mdp = mdp;
        this.id_employee = id_employee;
    }

        public Employee(int id_employee, String nom, String prenom, String dateNaissance, String adresse, int tel, String email, String cin) {
        super(nom, prenom, dateNaissance, adresse, tel, email, cin);
        this.id_employee = id_employee;
    }

    public Employee(String mdp, String nom, String prenom, String dateNaissance, String adresse, int tel, String email, String cin) {
        super(nom, prenom, dateNaissance, adresse, tel, email, cin);
        this.mdp = mdp;
    }
    
    
    public Employee(String nom, String prenom, String dateNaissance, String adresse, int tel, String email, String cin) {
        super(nom, prenom, dateNaissance, adresse, tel, email, cin);
    }
   
   public Employee(){
       
   }
   public Employee(int id){
       this.id_employee=id;
   }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }
     public boolean exist() throws SQLException
    {
        Connection con = config.getInstance().getConnection();

        ResultSet rs;
        rs = con.createStatement().executeQuery("SELECT * FROM employee WHERE idemployee="+this.id_employee);
        if (rs.next())
            return true;
        else return false;
    }
    public void supprimerEmployee() throws SQLException {
        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "DELETE FROM employee WHERE idemployee="+this.id_employee;
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();
        Alert a = new Alert(Alert.AlertType.INFORMATION,"Employé Supprimé ",ButtonType.OK);
         a.showAndWait();

    }
    
        public void ajouterEmployee() throws SQLException {

        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "INSERT INTO employee(nom,prenom,dateNaissance,adresse,tel,email,cin,motdepass) "
                + "Values ('"+this.nom+"','"+this.prenom+"','"+this.dateNaissance+"','"+this.adresse+"',"+this.tel+",'"+this.email +"','"+this.cin+"','"+this.mdp+"')";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        System.out.println("farah");
        preparedStatement.executeUpdate();
        System.out.println("moatez");       
    }

      public void modifierEmployee() throws SQLException {
        Connection con =config.getInstance().getConnection();
        try {

            Statement ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String req = "UPDATE employee SET nom='"+this.nom+"',prenom='"+this.prenom+"',dateNaissance='"+this.dateNaissance+"',adresse='"+this.adresse+"',email='"+this.email+"',tel="+this.tel+",cin='"+this.cin+"',motdepass='"+this.mdp+"' WHERE idemployee="+this.id_employee;
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.executeUpdate();

    }
}