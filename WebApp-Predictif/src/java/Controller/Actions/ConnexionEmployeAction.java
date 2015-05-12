package Controller.Actions;

import javax.servlet.http.HttpServletRequest;
import modele.Employe;

/**
 * Action pour verifier le login et le mot de l'employé.
 * @author elmhaidara
 */
public class ConnexionEmployeAction extends Action{
    Employe employe;

    @Override
    public void execute(HttpServletRequest request) {
        
        String login = request.getParameter("login");
        String motDePasse = request.getParameter("password");
        
         employe = service.Service.connexionEmploye(login, motDePasse);
        
    }
    
    public Employe getEmploye(){
        
        return employe;
    }
}
