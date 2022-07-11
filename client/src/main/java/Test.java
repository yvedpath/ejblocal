//package com;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.*;
import java.lang.reflect.*;

@WebServlet("/Test")
public class Test extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		System.out.println("Inside Controller Servlet");
		String  a=req.getParameter("NumberOne");
		String  b=req.getParameter("NumberTwo");
		int x=Integer.parseInt(a);
		int y=Integer.parseInt(b);
		System.out.println(x+y);
		try
		{
		InitialContext context=new InitialContext();
		com.AR R=(com.AR)context.lookup("java:global/ejblocal-ear-1.0-SNAPSHOT/com-ejb-1.0-SNAPSHOT/AB!com.AR");
		int c=R.add(x,y);
		System.out.println("Addition is:"+c);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
