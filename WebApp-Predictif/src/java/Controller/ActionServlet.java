package Controller;

import Controller.Actions.Action;
import Controller.Actions.ConnexionEmployeAction;
import Controller.Actions.ErreurAction;
import Controller.Actions.HoroscopeFormAction;
import Controller.Actions.InscriptionFormAction;
import Controller.Actions.PageHoroscopeAction;
import Controller.Actions.PageInscriptionAction;
import Utilities.Erreur;
import daojpa.JpaUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Le controleur du modèle MVC
 *
 * @author elmhaidara
 */
public class ActionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String todo = request.getParameter("todo");
        Action action = this.getAction(todo);
        action.execute(request);
        String vue = this.SetVue(todo, request);
        request.getRequestDispatcher(vue).forward(request, response);
    }

    private Action getAction(String todo) {
        Action action;
        switch (todo) {
            case "page-inscription":
                action = new PageInscriptionAction();
                break;
            case "traitement-inscription":
                action = new InscriptionFormAction();
                break;
            case "connexion-admin":
                action = new ConnexionEmployeAction();
                break;
            case "horoscope":
                action = new PageHoroscopeAction();
                break;
            case "horoscope-validation":
                action = new HoroscopeFormAction();
                break;
            default: // paramètre todo inconnu => erreur
                action = new ErreurAction();
                break;
        }
        return action;
    }

    private String SetVue(String todo, HttpServletRequest request) {
        String vue = null;
        switch (todo) {
            case "page-inscription":
                vue = "inscription.jsp";
                break;
            case "traitement-inscription":
                if (request.getAttribute(InscriptionFormAction.ATT_CLIENT) != null) {
                    // tout s'est bien passé
                    vue = "WEB-INF/confirmation-inscription.jsp";
                } else if (request.getAttribute(InscriptionFormAction.ATT_ERREURS) != null) {
                    // un des champs est invalide, on le renvoie sur la même page
                    vue = "inscription.jsp";
                } else {
                    // sinon y a eu un probleme lié à la base de donnée peut être
                    request.setAttribute(Erreur.ATT_ERREUR, Erreur.ERR_INSCRIPTION_CLIENT);
                    request.setAttribute(Erreur.ATT_ERREUR_TITRE, Erreur.ERR_INSCRIPTION_TITRE);
                    vue = "WEB-INF/erreur.jsp";
                }
                break;
            case "connexion-admin":
                if (request.getAttribute(ConnexionEmployeAction.ATT_EMPLOYE) != null) {
                    vue = "WEB-INF/selectionClient.jsp";
                } else {
                    request.setAttribute(Erreur.ATT_ERREUR, Erreur.ERR_CONNEXION_EMPLOYE);
                    request.setAttribute(Erreur.ATT_ERREUR_TITRE, Erreur.ERR_CONNEXION_TITRE);
                    vue = "WEB-INF/erreur.jsp";
                }
                break;
            case "horoscope":
                if (adminConnecte(request)) {
                    
                    if (request.getAttribute(PageHoroscopeAction.ATT_CLIENT_CHOISI) == null) {
                        // soit le client est introuvable soit l'url (id ou nom du parametre) est incorrect
                        request.setAttribute(Erreur.ATT_ERREUR, Erreur.ERR_CLIENT_INTROUVABLE);
                        request.setAttribute(Erreur.ATT_ERREUR_TITRE, Erreur.ERR_CLIENT_INTROUVABLE_TITRE);
                        vue = "WEB-INF/erreur.jsp";
                    } else {
                        vue = "WEB-INF/horoscope.jsp";
                    }
                    
                } else {
                    // erreur d'accès
                    request.setAttribute(Erreur.ATT_ERREUR, Erreur.ERR_ACCES_REFUSE);
                    request.setAttribute(Erreur.ATT_ERREUR_TITRE, Erreur.ERR_ACCES_REFUSE_TITRE);

                    vue = "WEB-INF/erreur.jsp";
                }
                break;
            case "horoscope-validation":
                if (request.getAttribute(HoroscopeFormAction.ATT_HOROSCOPE) != null) {
                    vue = "WEB-INF/confirmation-creation-horoscope.jsp";
                } else {
                    request.setAttribute(Erreur.ATT_ERREUR, Erreur.ERR_CREATION_HOROSCOPE);
                    request.setAttribute(Erreur.ATT_ERREUR_TITRE, Erreur.ERR_CREATION_HOROSCOPE_TITRE);
                    vue = "WEB-INF/erreur.jsp";
                }
                break;
            default:
                request.setAttribute(Erreur.ATT_ERREUR, Erreur.ERR_TODO_INVALIDE);
                request.setAttribute(Erreur.ATT_ERREUR_TITRE, Erreur.ERR_TODO_INVALIDE_TITRE);
                vue = "WEB-INF/erreur.jsp";
                break;
        }
        return vue;
    }

    private boolean adminConnecte(HttpServletRequest request) {
        return request.getSession(true).getAttribute(ConnexionEmployeAction.ATT_EMPLOYE) != null;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.init();
    }

    @Override
    public void destroy() {
        super.destroy();
        JpaUtil.destroy();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controller servlet";
    }// </editor-fold>

}
