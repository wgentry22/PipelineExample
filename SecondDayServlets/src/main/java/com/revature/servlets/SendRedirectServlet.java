	package com.revature.servlets;

import java.io.IOException;import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendRedirectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside the SendRedirectServlet");
		String searchQuery = request.getParameter("searchQuery");
		response.sendRedirect("https://www.google.com/#q=" + searchQuery);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
