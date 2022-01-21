package com.mouritech;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
	static Connection con; // = null;
	static PreparedStatement pstmt; // = null;
	private static final long serialVersionUID = 1L;
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html");
			//Here the text to be printed on the browser
			PrintWriter out = response.getWriter();
			//read the data entered in the html
			String productid = request.getParameter("productid");
			String productname = request.getParameter("productname");
			String productprice = request.getParameter("productprice");
			String productbrand = request.getParameter("productbrand");
			String productcategory = request.getParameter("productcategory");
			out.println("<h1> Product ID = " +productid + "Product Name = "+productname+
					"Product Price = "+productprice +"Product Brand = "+productbrand+"Product Category = "+productcategory + "</h1>");
			con = DBConnection.getDBConnection();
			String insertProduct = "insert into product1 values(?,?,?,?,?);";
			
			pstmt = con.prepareStatement(insertProduct);
			pstmt.setString(1, productid);
			pstmt.setString(2, productname);
			pstmt.setString(3, productprice);
			pstmt.setString(4, productbrand);
			pstmt.setString(5, productcategory);
			int i = pstmt.executeUpdate();
			if(i != 0) {
				out.println("inserted successfully");
			}else {
				out.println("Not inserted");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}*/


