package Controller.Actions;

import javax.servlet.http.HttpServletRequest;
import modele.Employe;

/**
 * Action pour verifier le login et le mot de l'employé.
 * @author elmhaidara
 */
public class ConnexionEmployeAction extends Action{


    @Override
    public void execute(HttpServletRequest request) {
        
        String login = request.getParameter("login");
        String motDePasse = request.getParameter("password");
        
        /*Employe employe = service.Service.connexionEmploye(login, motDePasse);
        if(employe == null){
            
        }
        else {
        }*/
    }
    
}
