/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    public static final String ATT_ERREURS = "erreurs";

    @Override
    public void execute(HttpServletRequest request) {

        Map<String, String> erreurs = new HashMap<>();

        String civilite = request.getParameter(ATT_CIVILITE);
        String nom = request.getParameter(ATT_NOM).trim();
        String prenom = request.getParameter(ATT_PRENOM).trim();

        if (nom.length() == 0) {
            erreurs.put(ATT_NOM, "Nom invalide");
        }

        if (prenom.length() == 0) {
            erreurs.put(ATT_PRENOM, "Prenom invalide");
        }

        /* date de naissance */
        Calendar date = null;
        String dateN = request.getParameter(ATT_NAISSANCE);
        String[] values = dateN.split("-", 3);
        if (values.length != 3) {
            erreurs.put(ATT_NAISSANCE, "Date de naissance invalide");
        } else {
            // TODO verifier peut etre l'intervalle des années et tout ça
            int jour_naissance = Integer.parseInt(values[0]);
            int mois_naissance = Integer.parseInt(values[1]) - 1;
            int annee_naissance = Integer.parseInt(values[2]);
            date = new GregorianCalendar(annee_naissance, mois_naissance, jour_naissance);
        }
        /* adresse */
        String adresse = request.getParameter(ATT_ADRESSE) + " " + request.getParameter(ATT_ADRESSE2);
        if (adresse.trim().isEmpty()) {
            erreurs.put(ATT_ADRESSE, "Adresse invalide");
        }

        String telephone = request.getParameter(ATT_TELEPHONE);
        String courriel = request.getParameter(ATT_COURIEL);

        /* création des mediums */
        List<Medium> listMedium = new ArrayList<>();
        String[] mediums = request.getParameterValues(ATT_MEDIUMS);
        if (mediums.length == 0) {
            erreurs.put(ATT_MEDIUMS, "Selection des mediums incorrects");
        } else {
            for (String nomMedium : mediums) {
                Long idMedium = Long.parseLong(nomMedium);
                listMedium.add(service.Service.obtenirMediumById(idMedium));
            }
        }

        if (erreurs.isEmpty()) {
            // pas d'erreurs dans les champs du formulaire
            Client client = new Client(nom, prenom, civilite, date, adresse, telephone, courriel, listMedium);
            if (service.Service.creerClient(client)) {
                request.setAttribute(ATT_CLIENT, client);
            } else {
                request.setAttribute(ATT_CLIENT, null);
            }
        } else {
            // on renvoie la liste des mediums à la page
            request.setAttribute("listMedium", service.Service.obtenirMediums());
            request.setAttribute(ATT_ERREURS, erreurs);
        }

    }

}
