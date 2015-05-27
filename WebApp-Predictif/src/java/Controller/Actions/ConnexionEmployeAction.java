package Controller.Actions;

import java.util.List;
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

    @Override
    public void execute(HttpServletRequest request) {

        HttpSession session;
        String login = request.getParameter("login");
        String motDePasse = request.getParameter("password");

        Employe employe = service.Service.connexionEmploye(login, motDePasse);
        if (employe != null) {
            session = request.getSession(true);

            session.setAttribute(ATT_EMPLOYE, employe);
            request.setAttribute(ATT_EMPLOYE, employe);
            // Ici on aurait du recupérer la liste des clients pour l'employé qui s'est connecté
            // mais le service n'a pas été implémentée.
            List<Client> listClient = service.Service.obtenirClients();
            request.setAttribute("listClient", listClient);
        } else {
            request.setAttribute(ATT_EMPLOYE, null);
        }

    }
}
