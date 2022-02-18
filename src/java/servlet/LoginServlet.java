package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logoutParam = request.getParameter("logout");
        HttpSession session = request.getSession();
        
        User validUser = (User)session.getAttribute("validUser");
         
        if(logoutParam == null){
            if(validUser != null){
                response.sendRedirect("home");
                return;
            }
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        else if(logoutParam.isEmpty()){
            String logoutMessage = "You have successfully logged out.";
            request.setAttribute("logoutMessage", logoutMessage);
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        AccountService user = new AccountService ();
        
        User validUser = user.login(username, password);
        
        if (validUser == null){
            String error = "Failed authentication";
            request.setAttribute("error", error);
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }else{
            session.setAttribute("validUser", validUser);
            response.sendRedirect("home");
        }
        
    }

}
