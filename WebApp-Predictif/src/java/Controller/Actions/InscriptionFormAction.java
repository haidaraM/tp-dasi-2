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
 *
 * @author elmhaidara
 */
public class InscriptionFormAction extends Action {

    /**
     * Constantes pour recuperer les paramètres
     */
    public static final String ATT_CIVILITE = "civilite";
    public static final String ATT_NOM = "nom";
    public static final String ATT_PRENOM = "prenom";
    public static final String ATT_NAISSANCE = "dateNaissance";
    public static final String ATT_ADRESSE = "adresse";
    public static final String ATT_ADRESSE2 = "adresse2";
    public static final String ATT_TELEPHONE = "telephone";
    public static final String ATT_COURIEL = "courriel";
    public static final String ATT_MEDIUMS = "mediums";
    
    public static final String ATT_CLIENT = "clientInscrit";

    @Override
    public void execute(HttpServletRequest request) {

        // TODO : vérification des paramètres reçues et traiter les erreurs
        String civilite = request.getParameter(ATT_CIVILITE);
        String nom = request.getParameter(ATT_NOM);
        String prenom = request.getParameter(ATT_PRENOM);
        
        String dateN = request.getParameter(ATT_NAISSANCE);
        String[] values = dateN.split("-", 3);
        
        int jour_naissance = Integer.parseInt(values[0]);
        int mois_naissance = Integer.parseInt(values[1]) - 1;
        int annee_naissance = Integer.parseInt(values[2]);
        Calendar date = new GregorianCalendar(annee_naissance, mois_naissance, jour_naissance);

        String adresse = request.getParameter(ATT_ADRESSE) + " " + request.getParameter(ATT_ADRESSE2);
        
        
        String telephone = request.getParameter(ATT_TELEPHONE);
        String courriel = request.getParameter(ATT_COURIEL);
        List<Medium> listMedium = new ArrayList<>();
        String[] mediums = request.getParameterValues(ATT_MEDIUMS);

        for (String nomMedium : mediums) {
            Long idMedium = Long.parseLong(nomMedium);
            listMedium.add(service.Service.obtenirMediumById(idMedium));
        }

        Client client = new Client(nom, prenom, civilite, date, adresse, telephone, courriel, listMedium);

        if (service.Service.creerClient(client)) {
            request.setAttribute(ATT_CLIENT, client);
        } else {
            request.setAttribute(ATT_CLIENT, null);
        }

    }


}
