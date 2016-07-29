/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.ciciro.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import amm.ciciro.classi.Account;
import amm.ciciro.classi.AccountFactory;
import amm.ciciro.classi.Compratore;
import amm.ciciro.classi.Oggetto;
import amm.ciciro.classi.OggettoFactory;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ciro
 */
@WebServlet(name = "Cliente", urlPatterns = {"/cliente.html"})
public class Cliente extends HttpServlet {

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
        
            HttpSession session = request.getSession();
            
            if(session != null){
                 ArrayList<Oggetto> OggettoList = OggettoFactory.getInstance().getOggettoList();
                if(session.getAttribute("compratore_autenticato") != null){
                     Compratore nuovoCompratore = (Compratore) session.getAttribute("compratore_autenticato");
                     request.setAttribute("compratore", nuovoCompratore);
             
                
                 if(request.getParameter("acquisto") != null){
                   int oggettoId = Integer.parseInt(request.getParameter("acquisto"));
                   double oggettoPrezzo = OggettoFactory.getInstance().getOggettoById(oggettoId).getPrezzo();
                   int oggettoQuantita = OggettoFactory.getInstance().getOggettoById(oggettoId).getQuantita();
                   double soldi = AccountFactory.getInstance().getAccountById(nuovoCompratore.getId()).getSoldi();
                  
                   if(oggettoPrezzo < soldi && oggettoQuantita > 0){
                       request.setAttribute("complimenti", true);
                       request.getRequestDispatcher("cliente.jsp").forward(request, response);    
                   }
                    else {
                       request.setAttribute("riprova", true);
                       request.getRequestDispatcher("cliente.jsp").forward(request, response);
                   }
                 
                 }
                 else 
                     if(request.getParameter("oggettoId") != null){
                        int oggettoId = Integer.parseInt(request.getParameter("oggettoId"));
                        Oggetto oggetto = OggettoFactory.getInstance().getOggettoById(oggettoId);
                        request.setAttribute("dettagli",oggetto);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                     }
                     else{
                         request.setAttribute("oggettoList",OggettoList);
                         request.getRequestDispatcher("cliente.jsp").forward(request, response);  
                     }
            
                }
                else{
                    request.setAttribute("errore",true);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
                
            }
            else{
                request.setAttribute("errore",true);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
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
