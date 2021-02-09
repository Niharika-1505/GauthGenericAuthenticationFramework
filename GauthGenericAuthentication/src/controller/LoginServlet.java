package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public LoginServlet() {
        super();
    }
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailid=request.getParameter("userid");
		String passwrd=request.getParameter("password");
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/abc1";
		String username="Niharika1";
		String password="auckland";
		if(emailid.equals("")||password.equals(""))
		{
		String message="cannot be empty";
		request.setAttribute("msg",message);
		getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
				}
		else
		{
			try
			{
				Class.forName(driver);
				Connection con=DriverManager.getConnection(url,username,password);
				PreparedStatement ps=con.prepareStatement("select * from login where emailid=? and password=?");
				ps.setString(1,emailid);
				ps.setString(2,passwrd);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					HttpSession session=request.getSession();
					session.setAttribute("userid",emailid);
					getServletContext().getRequestDispatcher("/verify1.jsp").forward(request, response);
				}
				else
				{
					response.getWriter().write("enter correct password and emailid");
					getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
				}
				con.close();
			}	
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}

}
}
