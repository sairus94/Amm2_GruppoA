/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.ciciro.servlets;

import amm.ciciro.classi.AccountFactory;
import amm.ciciro.classi.Compratore;
import amm.ciciro.classi.CompratoreFactory;
import amm.ciciro.classi.OggettoFactory;
import amm.ciciro.classi.Venditoree;
import amm.ciciro.classi.VenditoreeFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ciro
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"},
    loadOnStartup = 0)
public class Login extends HttpServlet {
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        OggettoFactory.getInstance().setConnectionString(dbConnection);
        VenditoreeFactory.getInstance().setConnectionString(dbConnection);
        CompratoreFactory.getInstance().setConnectionString(dbConnection);
        AccountFactory.getInstance().setConnectionString(dbConnection);
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
       
            HttpSession session = request.getSession(true);

            
     
            
            if(request.getParameter("Submit") != null)
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Compratore c = CompratoreFactory.getInstance().getCompratore(username,password);
            if (c != null) {
                if (c != null){
                    session.setAttribute("compratore_autenticato", c);
                    response.sendRedirect("cliente.html");
                    return;                    
                }
                Venditoree v = VenditoreeFactory.getInstance().getVenditore(username, password);
                if (v != null){
                    session.setAttribute("venditore_auteniticato", v); 
                    response.sendRedirect("venditore.html");
                    return;
                }
            }
            request.setAttribute("login_fallito", true);
            
        }
            
        request.getRequestDispatcher("login.jsp").forward(request, response);
       

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
