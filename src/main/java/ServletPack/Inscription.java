package ServletPack;


import beans.Utilisateur;
import dao.DAOFactory;
import dao.UtilisateurDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by François on 01-10-17.
 */
@WebServlet(name = "Inscription")
public class Inscription extends HttpServlet {

    private static final long serialVersionUID=1L;
    private UtilisateurDao utilisateurDao;

    public void init()throws ServletException{
        DAOFactory daoFactory=DAOFactory.getInstance();
        this.utilisateurDao=daoFactory.getUtilisateurDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recup data formulaira
        String login=request.getParameter("login");
        String pass=request.getParameter("pass");
        String nom =request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String mail=request.getParameter("mail");
        String ville=request.getParameter("ville");
        String adress=request.getParameter("adress");


        //Create new user
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setLogin(login);
        utilisateur.setPass(pass);
        utilisateur.setNom(nom);
        utilisateur.setVille(ville);
        utilisateur.setMail(mail);
        utilisateur.setAdress(adress);
        utilisateur.setPrenom(prenom);

        //Send user to page


        request.setAttribute("utilisateur",utilisateur);


        /*Noms tableNoms =new Noms();
        tableNoms.addUtilisateur(utilisateur);*/
        utilisateurDao.ajouter(utilisateur);


        this.getServletContext().getRequestDispatcher("/WEB-INF/InscriptionOK.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request,response);
    }
}
