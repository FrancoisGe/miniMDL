package ServletPack;

import beans.ConnectionForm;

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
        ConnectionForm co =new ConnectionForm();
        co.verifierId(request);
        request.setAttribute("co",co);

        String login=request.getParameter("login");
        String pass=request.getParameter("pass");


        HttpSession session =request.getSession();
        session.setAttribute("login",login);
        session.setAttribute("pass",pass);

        this.getServletContext().getRequestDispatcher("/WEB-INF/Acceuil.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("nom","franck");
        this.getServletContext().getRequestDispatcher("/WEB-INF/Acceuil.jsp").forward(request,response);
    }
}
