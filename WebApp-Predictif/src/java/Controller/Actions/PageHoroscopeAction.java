/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modele.Client;
import modele.Medium;

/**
 *
 * @author elmhaidara
 */
public class PageHoroscopeAction extends Action{

    @Override
    public void execute(HttpServletRequest request) {
        // on recupère l'id du client
        int idClient = Integer.parseInt(request.getParameter("idCl"));
        Client client = service.Service.obtenirClientById(idClient);
        List<Medium> listMedium = service.Service.obtenirMediumByClient(idClient);
        
        //TODO : peut être faire des vérifications sur les valeurs reçues
        
        // on met ça dans la requête pour l'envoyer à la page
        request.setAttribute("clientChoisi", client);
        request.setAttribute("listMediumClient", listMedium);
    }
    
}
