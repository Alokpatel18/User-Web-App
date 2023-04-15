package org.jsp.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		PrintWriter writer =resp.getWriter();
		writer.write("<html><body><h1>You are Logged out </h1></body></html>");
		RequestDispatcher dispatcher=null;
		dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}
}
