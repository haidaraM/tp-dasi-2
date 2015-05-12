/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Actions;

import javax.servlet.http.HttpServletRequest;
import modele.Client;


/**
 * Action pour inscrire un nouveau client
 * @author elmhaidara
 */
public class InscriptionAction extends Action{

    /**
     * Représente la vue qui sera affichée par l'action servlet
     */
    private String vue;
    
    @Override
    public void execute(HttpServletRequest request) {
        
        String civilite =  request.getParameter("civilite");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
                    
        int jour_naissance = Integer.parseInt(request.getParameter("jour_naissance"));
        int mois_naissance = Integer.parseInt(request.getParameter("mois_naissance"));
        int annee_naissance = Integer.parseInt(request.getParameter("annee_naissance"));
                   
        String adresse = request.getParameter("adresse");
        String adresse2 = request.getParameter("adresse2");
        
        String telephone = request.getParameter("telephone");
        String courriel = request.getParameter("courriel");
        
        Client client = new Client();
        
        request.setAttribute("client", client);
        
        vue = "WEB-INF/confirmation-inscription.jsp";
    }

    public String getVue() {
        return vue;
    }
    
    
}
