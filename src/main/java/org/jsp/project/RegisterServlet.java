package org.jsp.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet
{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("nm");
	int age=Integer.parseInt(req.getParameter("age"));
	long phone=Long.parseLong(req.getParameter("ph"));
	String password=req.getParameter("ps");
	Connection con=null;
	PreparedStatement pst=null;
	String qry="insert into new_table values(?,?,?,?,?)";
	try {
		Class.forName(UserUtility.DRIVER);
		con=DriverManager.getConnection(UserUtility.URL,UserUtility.USER,UserUtility.PASSWORD);
		pst=con.prepareStatement(qry);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, age);
		pst.setLong(4,phone);
		pst.setString(5, password);
		pst.executeUpdate();
		PrintWriter writer=resp.getWriter();
		writer.write("<html><body><h1>User Saved Successfully</h1></body></html>");
		
	}
	catch(SQLException | ClassNotFoundException e) {
	e.printStackTrace();
	}
    finally {
		if (con != null) {
			try {
				con.close();
				System.out.println("connection is closed");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pst != null) {
			try {
				pst.close();
				System.out.println("statement is closed");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
	
}

