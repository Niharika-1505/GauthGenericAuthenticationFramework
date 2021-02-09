package controller;

import helper.PasswordGenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.PasswordMail1;

/**
 * Servlet implementation class ForgotServlet
 */
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("emailid");
		String question=request.getParameter("ques");
		String answer=request.getParameter("ans");
		String to=userid;
		System.out.printf("%tc",new Date());
		long start=System.currentTimeMillis();
		try
		{
			Thread.sleep(400*60);
			}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(new Date());
		long end=System.currentTimeMillis();
		long diff=end-start;
		if(diff>=1440000)
		{
			getServletContext().getRequestDispatcher("/siteupdate.jsp").forward(request, response);
		}
		Connection con=null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/abc1","Niharika1","auckland");
		String sql="select * from login where emailid=? and ques=? and ans=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, userid);
		ps.setString(2, question);
		ps.setString(3, answer);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			PasswordGenerator pg=new PasswordGenerator();
			PasswordMail1 mail=new PasswordMail1();
		String generatepassword=pg.passwordgen();
		boolean status=mail.sendMail(to,generatepassword);
		System.out.println(generatepassword);
		if(status)
		{
			String sql1="update login set password=(?) where emailid=?";
			PreparedStatement ps1=con.prepareStatement(sql1);
			ps1.setString(1, generatepassword);
			ps1.setString(2, userid);
			int i=ps1.executeUpdate();
			String sql2="update register set password=(?) where emailid=?";
			PreparedStatement ps2=con.prepareStatement(sql2);
			ps2.setString(1, generatepassword);
			ps2.setString(2, userid);
			int j=ps2.executeUpdate();
			if(i==0 || j==0)
			{
				getServletContext().getRequestDispatcher("/out.jsp").forward(request, response);
			}
			else
			{
				HttpSession session =request.getSession();
				session.setAttribute("loginid", userid);
				session.setAttribute("password", generatepassword);
				getServletContext().getRequestDispatcher("/resetpassword.jsp").forward(request, response);
			}
			
			
		}
		else
		{
			String message="Question or Answer are incorrect. Please enter valid thing";
			request.setAttribute("msg", message);
			getServletContext().getRequestDispatcher("/forgotpassword.jsp").include(request, response);
		}
		
		}
		else
		{
			String message="Please try Again";
			request.setAttribute("msg", message);
			getServletContext().getRequestDispatcher("/forgotpassword.jsp").include(request, response);
		}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}



