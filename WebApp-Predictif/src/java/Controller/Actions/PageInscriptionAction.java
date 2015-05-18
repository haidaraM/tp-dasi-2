/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modele.Medium;

/**
 * Recupère les mediums pour la page d'inscription
 * @author elmhaidara
 */
public class PageInscriptionAction extends Action{

    public static final String ATT_MEDIUMS = "listMedium";
   
    @Override
    public void execute(HttpServletRequest request) {
        List<Medium> listMedium = service.Service.obtenirMediums();
        request.setAttribute(ATT_MEDIUMS, listMedium);
    }
    
}
