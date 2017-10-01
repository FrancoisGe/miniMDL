package ServletPack;

import beans.ConnectionForm;
import beans.Noms;
import beans.Utilisateur;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recupère login and pass
        String login=request.getParameter("login");
        String pass=request.getParameter("pass");

        //Vérifie si ok
        Noms tableNoms =new Noms();
        tableNoms.recupererUtilisateurs();
        Utilisateur user = tableNoms.checkLogPass(login,pass);
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
            this.getServletContext().getRequestDispatcher("/WEB-INF/Acceuil.jsp").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Noms tableNoms =new Noms();
        request.setAttribute("utilisateur",tableNoms.recupererUtilisateurs());

        this.getServletContext().getRequestDispatcher("/WEB-INF/Acceuil.jsp").forward(request,response);
    }
}
