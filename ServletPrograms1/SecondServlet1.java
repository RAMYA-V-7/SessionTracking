/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 91984
 */
@WebServlet(name = "SecondServlet1", urlPatterns = {"/SecondServlet1"} , initParams = {
    @WebInitParam(name = "user", value = "Ramya,Devi,Selvi"),
    @WebInitParam(name = "credit_card", value = "123,456,789"),
    @WebInitParam(name = "password", value = "111,222,333")})
public class SecondServlet1 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String name=request.getParameter("name");
            String ccard=request.getParameter("credit");
            String password=request.getParameter("pwd");
            
            ServletConfig config=getServletConfig();
            
            String user[]=config.getInitParameter("user").split(",");
            String card[]=config.getInitParameter("credit_card").split(",");
            String pwd[]=config.getInitParameter("password").split(",");
            
            Cookie c;
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Session Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            for(String u:user)
            {
                if(u.equals(name))
                {
                    c=new Cookie("name",u);
                    response.addCookie(c);
                }
            }
            for(String cc:card)
            {
                if(cc.equals(ccard))
                {
                    c=new Cookie("card",cc);
                    response.addCookie(c);
                }
            }
            for(String p:pwd)
            {
                if(p.equals(password))
                {
                    c=new Cookie("password",p);
                    response.addCookie(c);
                }
            }

            out.println("</body>");
            out.println("</html>");
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

