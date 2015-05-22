/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Actions.Action;
import Controller.Actions.ConnexionEmployeAction;
import Controller.Actions.HoroscopeFormAction;
import Controller.Actions.InscriptionFormAction;
import Controller.Actions.PageHoroscopeAction;
import Controller.Actions.PageInscriptionAction;
import daojpa.JpaUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
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

    private Action getAction(String todo){
        Action action =null;
        switch(todo){
            case "page-inscription":
                action = new PageInscriptionAction();
                break;
            case "traitement-inscription":
                action = new InscriptionFormAction();
                break;
            case "connexion-admin":
                action = new ConnexionEmployeAction();
                break;
            case "horoscope" : 
                action = new PageHoroscopeAction();
                break;
            case "horoscope-validation":
                action = new HoroscopeFormAction();
                break;                  
        }
        return action;
    }
    
    private String SetVue(String todo,HttpServletRequest request){
        String vue = null;
        switch (todo){
            case "page-inscription":
                vue = "inscription.jsp";
                break;
            case "traitement-inscription":
                if (request.getAttribute("clientInscrit")!=null){
                    vue = "WEB-INF/confirmation-inscription.jsp";
                }
                else{
                    vue = "WEB-INF/erreur.jsp";
                }
            break;
            case "connexion-admin":
                if(adminConnecte(request)){
                    vue = "WEB-INF/selectionClient.jsp";
                }
                else {
                    vue = "index.jsp";
                }
            break;
            case "horoscope":
                if(adminConnecte(request)){
                    vue = "WEB-INF/horoscope.jsp";
                }
                else {
                    vue = "index.jsp";
                }
            break;
            case "horoscope-validation":
                    if (request.getAttribute("horoscope")!=null){
                        vue = "WEB-INF/confirmation-creation-horoscope.jsp";
                    }
                    else{
                        vue = "WEB-INF/erreur.jsp";
                    }
                break;
            default :
                vue = "index.jsp";
        }
        return vue;
    }
    
    private boolean adminConnecte(HttpServletRequest request){
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
