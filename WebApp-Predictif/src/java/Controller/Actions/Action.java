/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Actions;

import javax.servlet.http.HttpServletRequest;

/**
 * Class abstraite jouant le rôle de sous controlleur.
 * Voir cours "Developpement d'ihm" page 7
 * @author elmhaidara
 */
public abstract class Action {
    
    /**
     * Methode à implementer par chaque action
     * @param request 
     */
    public abstract void execute(HttpServletRequest request);
    
}
