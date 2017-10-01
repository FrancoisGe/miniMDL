package ServletPack;

import beans.Auteur;

import java.io.IOException;

/**
 * Created by François on 30-09-17.
 */
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Auteur auteur = new Auteur();
        auteur.setActif(true);
        auteur.setNom("Georis");
        auteur.setPrenom("Francsoi");

        request.setAttribute("auteur",auteur);

        String message = "Au revoir !";
        request.setAttribute("var",message);

        String name = request.getParameter("name");
        request.setAttribute("name",name);

        this.getServletContext().getRequestDispatcher("/WEB-INF/Bonjour.jsp").forward(request,response);
        System.out.println("test");
    }
}
