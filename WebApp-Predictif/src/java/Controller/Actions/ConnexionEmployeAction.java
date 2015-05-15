package Controller.Actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modele.Client;
import modele.Employe;

/**
 * Action pour verifier le login et le mot de l'employé.
 *
 * @author elmhaidara
 */
public class ConnexionEmployeAction extends Action {

    Employe employe;
    String vue;

    @Override
    public void execute(HttpServletRequest request) {

        String login = request.getParameter("login");
        String motDePasse = request.getParameter("password");

        employe = service.Service.connexionEmploye(login, motDePasse);
        if (connecte()) {
            List<Client> listClient = service.Service.obtenirClients();
            request.setAttribute("listClient", listClient);
            vue = "selectionClient.jsp";
        } else {
            vue = "index.jsp";
        }

    }
    
    public String getVue(){
        return vue;
    }

    private boolean connecte() {

        if (employe != null) {
            return true;
        } else {
            return false;
        }
    }
}
