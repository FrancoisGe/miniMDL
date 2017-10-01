package ServletPack;

import beans.Auteur;
import dao.DAOFactory;
import dao.UtilisateurDao;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by François on 30-09-17.
 */
public class Servlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID=1L;
    private UtilisateurDao utilisateurDao;

    public void init()throws ServletException {
        DAOFactory daoFactory=DAOFactory.getInstance();
        this.utilisateurDao=daoFactory.getUtilisateurDao();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("utilisateurs",utilisateurDao.lister());

        this.getServletContext().getRequestDispatcher("/WEB-INF/Bonjour.jsp").forward(request,response);

    }
}
