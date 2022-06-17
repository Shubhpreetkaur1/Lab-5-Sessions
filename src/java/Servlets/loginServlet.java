
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.Account;


public class loginServlet extends HttpServlet {

   
  

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession session = request.getSession();
       
       if(request.getParameter("action") != null){
           session.invalidate();
       request.setAttribute("Logout", true);    
       getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       return;
       }
       else if(session.getAttribute("username") != null){
           response.sendRedirect("home");
           return;
       }
       
       getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       return;
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        if(username.equals("")|| username == null || 
             password.equals("") || password == null){
          String message = "Please enter both username and password";
         request.setAttribute("message", message);
         
         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
         return;
        }
        
        Account account = new Account();
        
        if(account.login(username, password) != null){
          session.setAttribute("username", username);
          response.sendRedirect("home");
          return;
        }
        else{
            String message ="Invalid username or password";
            request.setAttribute("message", message);
            
            getServletContext().getRequestDispatcher
        ("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }


}
