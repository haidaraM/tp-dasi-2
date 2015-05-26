/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Actions;

import javax.servlet.http.HttpServletRequest;
import modele.Client;
import modele.Horoscope;
import modele.Medium;
import modele.Prediction_Amour;
import modele.Prediction_Sante;
import modele.Prediction_Travail;

/**
 *
 * @author elmhaidara
 */
public class HoroscopeFormAction extends Action {
    

    public static final String ATT_CLIENT = "client";
    public static final String ATT_MEDIUM = "medium";
    public static final String ATT_SANTE_ID = "chSante";
    public static final String ATT_TRAVAIL_ID = "chTravail";
    public static final String ATT_AMOUR_ID = "chAmour";
    public static final String ATT_LIST_MEDIUM ="listMedium";
    public static final String ATT_HOROSCOPE = "horoscope";

    @Override
    public void execute(HttpServletRequest request) {
               
        int idClient = Integer.parseInt(request.getParameter(ATT_CLIENT));
        System.out.println("Client : " + idClient);

        int idMedium = Integer.parseInt(request.getParameter(ATT_MEDIUM));
        System.out.println("Medium : " + idMedium);

        Client client = service.Service.obtenirClientById(idClient);
        if (client == null) {
            System.out.println("Impossible de récuperer le client");
            return;
        }

        Medium medium = service.Service.obtenirMediumById(idMedium);
        if (medium == null) {
            System.out.println("Impossible de récuperer le médium");
            return;
        }

        int idPredictionAmour = Integer.parseInt(request.getParameter(ATT_AMOUR_ID));

        Prediction_Amour prediction_Amour = service.Service.obtenirPredictionAmourById(idPredictionAmour);
        if (prediction_Amour == null) {
            System.out.println("Impossible de récuperer la prédiction amour");
            return;
        }

        int idPredictionTravail = Integer.parseInt(request.getParameter(ATT_TRAVAIL_ID));
        Prediction_Travail prediction_Travail = service.Service.obtenirPredictionTravailById(idPredictionTravail);

        if (prediction_Travail == null) {
            System.out.println("Impossible de récuperer la prédiction travail");
            return;
        }

        int idPredictionSante = Integer.parseInt(request.getParameter(ATT_SANTE_ID));
        Prediction_Sante prediction_Sante = service.Service.obtenirPredictionSanteById(idPredictionSante);
        if(prediction_Sante==null){
            System.out.println("Impossible de récuperer la prédiction sante");
            return;
        }
        
        Horoscope horoscope = new Horoscope(prediction_Amour, prediction_Sante, prediction_Travail, client, medium);
        if(service.Service.creerHoroscope(horoscope)){
            /* on envoie les infos à la page de confirmation pour affichage */
            request.setAttribute(ATT_CLIENT, client);
            request.setAttribute(ATT_HOROSCOPE, horoscope);
            request.setAttribute(ATT_LIST_MEDIUM, client.getMedium());
            
        } 

    }

    
    

}
