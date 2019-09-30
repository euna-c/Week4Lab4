
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author 784564
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
                String a = request.getParameter("logout");
                
                HttpSession session = request.getSession();
                // get the list of numbers from the session
                String userName = (String)session.getAttribute("userName");
               
               
                //when the user cliked logout
                if(a != null)
                {
                    session.removeAttribute("userName");
                    //session.invalidate();
                    String msg = "You successfully logged out";
                    request.setAttribute("message", msg);
                    
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
                }
                //when the user goes to the login page(first page) also 
                //when they are already logged in.
                else
                {
                    if(userName != null)
                    {
                        response.sendRedirect("/home");
                    }
                    //if the user is null
                    else
                    {
                        
                        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
                    }        
                   
                    
                }
             
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            
            
            
            if ( username == null || username.equals("")|| password == null || password.equals(""))
            {
                String error = "Type username and password";
                request.setAttribute("message", error);
                
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            return;
            }
            
           
            
            AccountService as = new AccountService(username, password);
            
            User u = new User(username, password);
            
            //varifying the username and password
            if(as.login(username, password) != null)
            {
                 //create session
                HttpSession session = request.getSession();
                // get the list of numbers from the session
                String userName = (String)session.getAttribute("userName");
            
                session.setAttribute("userName",username);
                
                response.sendRedirect("/home");
                
            }
            if(as.login(username, password) == null)
            {
                //get message when username and password are wrong
                String error = "Invalid username or password";
                request.setAttribute("message", error);
                
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            }
            
            
    }
}
