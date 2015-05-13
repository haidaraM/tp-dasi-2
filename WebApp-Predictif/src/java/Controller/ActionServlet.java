/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Actions.ConnexionEmployeAction;
import Controller.Actions.InscriptionAction;
import Controller.Actions.PageInscriptionAction;
import daojpa.JpaUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Client;
import modele.Employe;
import modele.Medium;

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
        List<Client> listClient;

        String todo = request.getParameter("todo");

        if (null != todo) {
            switch (todo) {
                case "page-inscription":
                    PageInscriptionAction pageInscriptionAction = new PageInscriptionAction();
                    pageInscriptionAction.execute(request);
                    request.getRequestDispatcher("inscription.jsp").forward(request, response);
                    break;
                case "traitement-inscription":
                    InscriptionAction ia = new InscriptionAction();
                    ia.execute(request);
                    request.getRequestDispatcher(ia.getVue()).forward(request, response);
                    break;
                case "connexion-admin":
                    ConnexionEmployeAction cea = new ConnexionEmployeAction();
                    cea.execute(request);
                    if (cea.connecte()) {
                        listClient = service.Service.obtenirClients();
                        request.setAttribute("listClient", listClient);
                        request.getRequestDispatcher("selectionClient.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }

                    break;
                    
                case "horoscope":
                    
                    break;

            }
        }
    }

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        JpaUtil.init();
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
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
