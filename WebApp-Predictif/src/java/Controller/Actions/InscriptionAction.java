/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modele.Client;
import modele.Medium;


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
        Calendar date = new GregorianCalendar(annee_naissance, mois_naissance, jour_naissance);
        
                   
        String adresse = request.getParameter("adresse");
        String adresse2 = request.getParameter("adresse2");
        
        String telephone = request.getParameter("telephone");
        String courriel = request.getParameter("courriel");
        List<Medium> listMedium = new ArrayList<>();
        String [] mediums = request.getParameterValues("mediums");
        
        for (String nomMedium: mediums){
            Long idMedium = Long.parseLong(nomMedium);
            listMedium.add(service.Service.obtenirMediumById(idMedium));
        }
        
        Client client = new Client(nom, prenom, civilite, date, adresse, nom, nom, listMedium);
        
        service.Service.creerClient(client);
        
        request.setAttribute("client", client);
        
        vue = "WEB-INF/confirmation-inscription.jsp";
    }

    public String getVue() {
        return vue;
    }
    
    
}
