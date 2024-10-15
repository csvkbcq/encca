

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Addresult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int Marks1 =Integer.parseInt(request.getParameter("Marks1"));
		int Marks2 =Integer.parseInt(request.getParameter("Marks2"));
		int Marks3 =Integer.parseInt(request.getParameter("Marks3"));
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8098/june2024", "root", "Prajwal@1234#$");
			String s = "insert into student values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, Marks1);
			pstmt.setInt(3, Marks2);
			pstmt.setInt(3, Marks3);
			int rows= pstmt.executeUpdate();
			PrintWriter out=response.getWriter();
			if(rows==0) {
			    out.println("Student data not added");
			 }
		    else {
			    	   out.println("Student data added success");
			       }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
       }
	}}

