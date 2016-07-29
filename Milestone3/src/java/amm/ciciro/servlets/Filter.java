/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.ciciro.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import amm.ciciro.classi.Compratore;
import amm.ciciro.classi.Oggetto;
import amm.ciciro.classi.OggettoFactory;

/**
 *
 * @author Ciro
 */
@WebServlet(name = "Filter", urlPatterns = {"/Filter"})
public class Filter extends HttpServlet {

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
        response.setContentType("application/json");
       
     HttpSession session = request.getSession();
        
        if(session != null){
            if(session.getAttribute("compratore_autenticato") != null){
                Compratore newCompratore = (Compratore) session.getAttribute("compratore_autenticato");
                request.setAttribute("compratore", newCompratore);
                String command = request.getParameter("cmd");

                if (command != null) 
                {
                    if (command.equals("cerca")) 
                    {

                        ArrayList<Oggetto> OggettoList = OggettoFactory.getInstance().cercaOggetto(request.getParameter("text"));
                        request.setAttribute("oggettolist", OggettoList);

                        response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                        response.setHeader("Cache-Control", "no-store, no-cache, "
                                + "must-revalidate");
                        request.getRequestDispatcher("oggettoList.jsp").forward(request, response);          
                    }
                }
            } else {
            request.setAttribute("login_fallito", true);
            response.sendRedirect("cliente.html");  
            return;
            }
            
        } else {
            request.setAttribute("login_fallito", true);
            response.sendRedirect("cliente.html");  
            return;
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        return "Short description";
    }// </editor-fold>

}

