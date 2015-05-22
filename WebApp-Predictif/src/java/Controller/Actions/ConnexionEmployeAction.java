package Controller.Actions;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import modele.Client;
import modele.Employe;

/**
 * Action pour verifier le login et le mot de l'employé.
 *
 * @author elmhaidara
 */
public class ConnexionEmployeAction extends Action {

    public static final String ATT_EMPLOYE = "employe";
    
    Employe employe;
    String vue;

    @Override
    public void execute(HttpServletRequest request) {

        String login = request.getParameter("login");
        String motDePasse = request.getParameter("password");

        employe = service.Service.connexionEmploye(login, motDePasse);
        if (connecte()) {
            HttpSession session =  request.getSession(true);
            
            session.setAttribute(ATT_EMPLOYE, employe);
            
            List<Client> listClient = service.Service.obtenirClients();
            request.setAttribute("listClient", listClient);
            
        }

    }
    
    public String getVue(){
        return vue;
    }

    private boolean connecte() {

        return employe != null;
    }
}
