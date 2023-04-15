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

@WebServlet("/edit")

public class EditUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("nm");
		int age = Integer.parseInt(req.getParameter("age"));
		long phone = Long.parseLong(req.getParameter("ph"));
		String Password = req.getParameter("ps");
		Connection con = null;
		PreparedStatement pst = null;
		String qry = "update new_table set Name=?,Phone=?,Age=?,Password=? where Id=?";
		try {
			Class.forName(UserUtility.DRIVER);
			con = DriverManager.getConnection(UserUtility.URL, UserUtility.USER, UserUtility.PASSWORD);
			pst = con.prepareStatement(qry);
			pst.setString(1, name);
			pst.setLong(2, phone);
			pst.setInt(3, age);
			pst.setString(4, Password);
			pst.setInt(5, id);
			pst.executeUpdate();
			PrintWriter writer = resp.getWriter();
			writer.write("<html><body><h1> User details updated Succesfully</h1></body></html>");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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
					System.out.println("prepared statement is closed");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
