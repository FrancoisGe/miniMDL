package beans;

import dao.UtilisateurDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by François on 01-10-17.
 */
public class Noms {

    private Connection connection;

    public List<Utilisateur> recupererUtilisateurs(){
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

        this.loadDB();

        //Connection DB
        Statement statement = null;
        ResultSet resultSet=null;

        try {


            statement=connection.createStatement();

            //Execute request
            resultSet=statement.executeQuery("SELECT nom,prenom,login,pass,adress,ville,mail FROM noms;");

            //Recup data
            while (resultSet.next()){
                String nom =resultSet.getString("nom");
                String prenom=resultSet.getString("prenom");
                String login=resultSet.getString("login");
                String pass=resultSet.getString("pass");
                String mail=resultSet.getString("mail");
                String ville=resultSet.getString("ville");
                String adress=resultSet.getString("adress");

                Utilisateur utilisateur=new Utilisateur();
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setAdress(adress);
                utilisateur.setLogin(login);
                utilisateur.setPass(pass);
                utilisateur.setMail(mail);
                utilisateur.setVille(ville);

                utilisateurs.add(utilisateur);
            }
        }catch  (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet !=null){
                    resultSet.close();
                }
                if(statement !=null ){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return utilisateurs;
    }

    private void loadDB(){
        //Charg driver
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){

        }
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee","root","1234");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUtilisateur(Utilisateur utilisateur){
        loadDB();

        try {
            PreparedStatement preparedStatement =connection.prepareStatement("INSERT  INTO noms(nom,prenom,login,pass,adress,ville,mail) VALUES (?,?,?,?,?,?,?)");
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

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Utilisateur checkLogPass(String login,String pass,UtilisateurDao utilisateurDao){

        List<Utilisateur> utilisateurList=utilisateurDao.lister();
        for (int i = 0; i < utilisateurList.size(); i++) {
            String log = utilisateurList.get(i).getLogin();
            if (log.equals(login)){
                String p = utilisateurList.get(i).getPass();
                if (p.equals(pass)){
                    return utilisateurList.get(i);
                }
            }
        }
        return null;

    }



}
