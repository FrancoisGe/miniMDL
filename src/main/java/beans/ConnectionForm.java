package beans;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by François on 30-09-17.
 */
public class ConnectionForm {
    private String resultat;

    public void verifierId(HttpServletRequest request){
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        System.out.println(login);
        if(pass.equals(login+"123")){
            resultat ="Vous etes co";

        }
        else {
            resultat="bad id/pass";
        }
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}
