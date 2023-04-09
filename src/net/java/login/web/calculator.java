package net.java.login.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.login.bean.CalculatorBean;

/**
 * Servlet implementation class calculator
 */
@WebServlet("/calculator")
public class calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=null;
//		String result = request.getParameter("result");
//		 CalculatorBean calculatorBean = new CalculatorBean();
//		 calculatorBean.setResult(result);
		try {
			out = response.getWriter();
			out.println("<div>");
			String t1=request.getParameter("t1");
			System.out.println(t1);
			int a = 0;
			if(t1=="")
			{
				a=0;
			}
			else {
				a=Integer.parseInt(request.getParameter("t1"));
			}
			String t2=request.getParameter("t2");
			System.out.println(t2);
			int b = 0;
			if(t2=="")
			{
				b=0;
			}
			else {
				b=Integer.parseInt(request.getParameter("t2"));
			}
			
			String op=request.getParameter("btn");
			System.out.println("a"+a);
			System.out.println("b"+b);
			int c = 0;
			request.setAttribute("result", c);
			if(op.equals("/")&& b==0)
			{
				String someMessage = "Invalid input fields";
            	out.println("<script type='text/javascript'>");
            	out.println("alert(" + "'" + someMessage + "'" + ");</script>");
            	out.println("</head><body></body></html>");
            	RequestDispatcher rd=request.getRequestDispatcher("loginsuccess.jsp");            
            	rd.include(request, response);
			}
			else 
			{
			if(op.equals("+"))c=a+b;
			if(op.equals("-"))c=a-b;
			if(op.equals("*"))c=a*b;
			if(op.equals("/"))c=a/b;
			request.setAttribute("result", c);
			request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
			}

			
		}
		catch(Exception e) {
			out.println("Error"+e.getMessage());
		}
	}

}
