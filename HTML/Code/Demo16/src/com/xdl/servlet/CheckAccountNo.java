package com.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckAccountNo
 */
@WebServlet("/checkAccountNoAJAX.do")
public class CheckAccountNo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 		String  ano  = request.getParameter("ano");
        System.out.println("ano:"+ano);	
        boolean  msg=true;
        if(ano.equals("abc123")){
        	msg = true;
        }else{
        	msg = false;
        }
        PrintWriter pw = response.getWriter();
        pw.write(msg+"");
        //pw.write("hello world");
        pw.close();
	}

}


