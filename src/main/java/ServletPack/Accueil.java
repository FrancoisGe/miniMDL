package ServletPack;


import beans.Noms;
import beans.Utilisateur;
import dao.DAOFactory;
import dao.UtilisateurDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by François on 30-09-17.
 */
@WebServlet(name = "Accueil")
public class Accueil extends HttpServlet {

    private static final long serialVersionUID=1L;
    private UtilisateurDao utilisateurDao;

    public void init()throws ServletException{
        DAOFactory daoFactory=DAOFactory.getInstance();
        this.utilisateurDao=daoFactory.getUtilisateurDao();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recupère login and pass
        String login=request.getParameter("login");
        String pass=request.getParameter("pass");

        //Vérifie si ok
        Noms tableNoms =new Noms();
        tableNoms.recupererUtilisateurs();
        Utilisateur user = tableNoms.checkLogPass(login,pass,this.utilisateurDao);
        if (user !=null){

            HttpSession session =request.getSession();
            session.setAttribute("login",user.getLogin());
            session.setAttribute("pass",user.getPass());
            session.setAttribute("nom",user.getNom());
            session.setAttribute("prenom",user.getPrenom());
            session.setAttribute("mail",user.getMail());
            session.setAttribute("ville",user.getVille());
            session.setAttribute("adress",user.getAdress());

            this.getServletContext().getRequestDispatcher("/WEB-INF/Profil.jsp").forward(request,response);

        }
        else{

            request.setAttribute("utilisateurs",utilisateurDao.lister());
            this.getServletContext().getRequestDispatcher("/WEB-INF/Acceuil.jsp").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Noms tableNoms =new Noms();
        request.setAttribute("utilisateur",tableNoms.recupererUtilisateurs());

        this.getServletContext().getRequestDispatcher("/WEB-INF/Acceuil.jsp").forward(request,response);
    }
}
