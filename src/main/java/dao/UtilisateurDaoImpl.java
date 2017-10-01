package dao;

/**
 * Created by François on 01-10-17.
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
    private DAOFactory daoFactory;

    UtilisateurDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Utilisateur utilisateur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
             preparedStatement =connexion.prepareStatement("INSERT  INTO noms(nom,prenom,login,pass,adress,ville,mail) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1,utilisateur.getNom());
            preparedStatement.setString(2,utilisateur.getPrenom());
            preparedStatement.setString(3,utilisateur.getLogin());
            preparedStatement.setString(4,utilisateur.getPass());
            preparedStatement.setString(5,utilisateur.getAdress());
            preparedStatement.setString(6,utilisateur.getVille());
            preparedStatement.setString(7,utilisateur.getMail());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Utilisateur> lister() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            //Execute request
            resultSet=statement.executeQuery("SELECT nom,prenom,login,pass,adress,ville,mail FROM noms;");

            //Recup data
            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String login = resultSet.getString("login");
                String pass = resultSet.getString("pass");
                String mail = resultSet.getString("mail");
                String ville = resultSet.getString("ville");
                String adress = resultSet.getString("adress");

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setAdress(adress);
                utilisateur.setLogin(login);
                utilisateur.setPass(pass);
                utilisateur.setMail(mail);
                utilisateur.setVille(ville);

                utilisateurs.add(utilisateur);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

}