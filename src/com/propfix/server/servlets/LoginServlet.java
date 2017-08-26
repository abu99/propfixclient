/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.propfix.server.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
	String username = request.getParameter("j_username");
	String password = request.getParameter("j_password");

	//login
        try {
            System.out.println("**********************************");
//            request.login(username, password);
            response.sendRedirect("PropfixClient.html");
        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
            Logger.getLogger(LoginServlet.class.getName())
                    .log(Level.INFO, null, ex);
        } 
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

    private void promptInvalidUsername(HttpServletRequest request, PrintWriter out) {
	out.println("<html>");
            out.println("<head>");
	out.println("<script type=\"text/javascript\">");

        out.println("window.alert(\"Invalid username. Please try again.\")");
        out.println("window.location = \"" + request.getContextPath() + "\";");
	out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");

        out.flush();
    }

    private void promptInvalidPassword(HttpServletRequest request, PrintWriter out) {
	out.println("<html>");
            out.println("<head>");
	out.println("<script type=\"text/javascript\">");
        out.println("window.alert(\"Invalid password. Please try again.\");");
        out.println("window.location = \"" + request.getContextPath() + "\";");
	out.println("</script>");

            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        out.flush();
    }

    
}
