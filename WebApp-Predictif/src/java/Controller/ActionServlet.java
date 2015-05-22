/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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

        if (null != todo) {
            switch (todo) {
                case "page-inscription":
                    PageInscriptionAction pageInscriptionAction = new PageInscriptionAction();
                    pageInscriptionAction.execute(request);
                    request.getRequestDispatcher("inscription.jsp").forward(request, response);
                    break;
                case "traitement-inscription":
                    InscriptionFormAction ia = new InscriptionFormAction();
                    ia.execute(request);
                    request.getRequestDispatcher(ia.getVue()).forward(request, response);
                    break;
                case "connexion-admin":
                    ConnexionEmployeAction cea = new ConnexionEmployeAction();
                    cea.execute(request);
                    request.getRequestDispatcher(cea.getVue()).forward(request, response);
                    break;
                case "horoscope":
                    if (request.getSession(true).getAttribute(ConnexionEmployeAction.ATT_EMPLOYE) != null) { //on vérifie que l'usager est bien identifié
                        PageHoroscopeAction pageHoroscopeAction = new PageHoroscopeAction();
                        pageHoroscopeAction.execute(request);
                        request.getRequestDispatcher("WEB-INF/horoscope.jsp").forward(request, response);
                    } else {       //ou on le redirige vers la page de connexion
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    break;
                case "horoscope-validation":
                    HoroscopeFormAction horoscopeFormAction = new HoroscopeFormAction();
                    horoscopeFormAction.execute(request);
                    request.getRequestDispatcher(horoscopeFormAction.getVue()).forward(request, response);
                    break;
            }
        }
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
