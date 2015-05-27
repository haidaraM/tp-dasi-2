/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 * Cette contient les différents type d'erreur que l'on peut avoir
 * @author elmhaidara
 */
public  abstract class Erreur {
    
    public static final String ATT_ERREUR = "erreur";
    public static final String ATT_ERREUR_TITRE = "erreurTitre";
    
    /* partie horoscope */    
    public static final int ERR_CREATION_HOROSCOPE = 1;
    public static final String ERR_CREATION_HOROSCOPE_TITRE = "Echec création horoscope";
    
    
    /* inscription */
    public static final int ERR_INSCRIPTION_CLIENT = 2;
    public static final String ERR_INSCRIPTION_TITRE = "Echec inscription client";
    
    /* connexion employé */
    public static final int ERR_CONNEXION_EMPLOYE = 3;
    public static final String ERR_CONNEXION_TITRE = "Echec de connexion";
    
    /* accès refusé */
    public static final int ERR_ACCES_REFUSE = 4;
    public static final String ERR_ACCES_REFUSE_TITRE = "Accès refusé";
    
    /* todo invalide */
    public static final int ERR_TODO_INVALIDE = 5;
    public static final String ERR_TODO_INVALIDE_TITRE = "Paramètres URL invalides ";
    
    /* client introuvable */
    public static final int ERR_CLIENT_INTROUVABLE = 6;
    public static final String ERR_CLIENT_INTROUVABLE_TITRE = "Client introuvable ou paramètre incorrecte";
}
