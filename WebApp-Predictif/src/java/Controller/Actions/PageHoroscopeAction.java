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
import modele.Prediction_Amour;
import modele.Prediction_Sante;
import modele.Prediction_Travail;

/**
 *
 * @author elmhaidara
 */
public class PageHoroscopeAction extends Action {

    public static final String ATT_CLIENT_CHOISI = "clientChoisi";
    public static final String ATT_MEDIUMS = "listMediumClient";
    public static final String ATT_PREDIC_SANTE = "listPredictionSante";
    public static final String ATT_PREDIC_AMOUR = "listPredictionAmour";
    public static final String ATT_PREDIC_TRAVAIL = "listPredictionTravail";
    public static final String ATT_HISTO_SANTE = "listHistoSante";
    public static final String ATT_HISTO_AMOUR = "listHistoAmour";
    public static final String ATT_HISTO_TRAVAIL = "listHistoTravail";

    @Override
    public void execute(HttpServletRequest request) {
        // on recupère l'id du client
        String id = request.getParameter("idCl");
        if(id == null){
            return;
        }
        int idClient = Integer.parseInt(id);
        Client client = service.Service.obtenirClientById(idClient);
        if (client != null) {
            List<Medium> listMedium = service.Service.obtenirMediumByClient(idClient);

            List<Prediction_Amour> listPredictionAmour = service.Service.obtenirPredictionsAmour();
            List<Prediction_Sante> listPredictionSante = service.Service.obtenirPredictionsSante();
            List<Prediction_Travail> listPredictionTravail = service.Service.obtenirPredictionsTravail();
            List<Prediction_Amour> listHistoAmour = service.Service.historiquePredictionsAmour(client);
            List<Prediction_Sante> listHistoSante = service.Service.historiquePredictionsSante(client);
            List<Prediction_Travail> listHistoTravail = service.Service.historiquePredictionsTravail(client);

            // on met ça dans la requête pour l'envoyer à la page
            request.setAttribute(ATT_CLIENT_CHOISI, client);
            request.setAttribute(ATT_MEDIUMS, listMedium);
            request.setAttribute(ATT_PREDIC_SANTE, listPredictionSante);
            request.setAttribute(ATT_PREDIC_TRAVAIL, listPredictionTravail);
            request.setAttribute(ATT_PREDIC_AMOUR, listPredictionAmour);
            request.setAttribute(ATT_HISTO_SANTE, listHistoSante);
            request.setAttribute(ATT_HISTO_TRAVAIL, listHistoTravail);
            request.setAttribute(ATT_HISTO_AMOUR, listHistoAmour);
        } 
    }

}
