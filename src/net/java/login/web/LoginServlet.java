package net.java.login.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.java.login.bean.LoginBean;
import net.java.login.database.LoginDao;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        PrintWriter out = response.getWriter();  

        try {
            if (loginDao.validate(loginBean)) {
                response.sendRedirect("loginsuccess.jsp");
            } else {
            	String someMessage = "Invalid Username or Password !";
            	out.println("<script type='text/javascript'>");
            	out.println("alert(" + "'" + someMessage + "'" + ");</script>");
            	out.println("</head><body></body></html>");
            	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");            
            	rd.include(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}