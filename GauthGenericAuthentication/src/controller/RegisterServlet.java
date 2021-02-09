package controller;

import helper.Helper;

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



public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String emailid=request.getParameter("userid");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("password1");
		String dob=request.getParameter("dob");
		String ques=request.getParameter("ques");
		String ans=request.getParameter("ans");
		String code=request.getParameter("code");
		HttpSession session=request.getSession();
		session.setAttribute("code", code);
		String captcha=(String)session.getAttribute("captcha");
		boolean status=Helper.checkCaptcha(captcha,code);
		if(fname.equals("")||lname.equals("")||contact.equals("")||address.equals("")||emailid.equals("")||password.equals("")||confirmpassword.equals("")||dob.equals("")||ans.equals(""))
		{
			String message="All Fields Are Mandatory";
			request.setAttribute("msg",message);
			getServletContext().getRequestDispatcher("/contact.jsp").include(request,response);
		}
		else if(status)
		{
			try
			{
					Class.forName("com.ibm.db2.jcc.DB2Driver");
					Connection con1=DriverManager.getConnection("jdbc:db2://localhost:50000/abc1","Niharika1","auckland");
							PreparedStatement ps3=con1.prepareStatement("select * from register where emailid=?");
									ps3.setString(1, emailid);
									ResultSet rs=ps3.executeQuery();
						if(rs.next())
						{
							String message="Please enter another emailid ! emailid already exist";
							request.setAttribute("msg1", message);
							getServletContext().getRequestDispatcher("/contact.jsp").include(request,response);
						}
			
			else if(password.equals(confirmpassword))
			{
				Class.forName("com.ibm.db2.jcc.DB2Driver");
				Connection con2=DriverManager.getConnection("jdbc:db2://localhost:50000/abc1","Niharika1","auckland");
						PreparedStatement ps2=con2.prepareStatement("select * from register where contact=?");
								ps2.setString(1, contact);
								ResultSet rs1=ps2.executeQuery();
					if(rs1.next())
					{
						String message="Please enter another Contact ! it already exist";
						request.setAttribute("msg", message);
						getServletContext().getRequestDispatcher("/contact.jsp").include(request,response);
					}
			
					else	if(password.equals(confirmpassword))
					{
		
				Class.forName("com.ibm.db2.jcc.DB2Driver");
				Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/abc1","Niharika1","auckland");
				PreparedStatement ps=con.prepareStatement("insert into register(fname,lname,contact,address,gender,state,city,emailid,password,dob,ques,ans)values(?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,fname);
				ps.setString(2,lname);
				ps.setString(3,contact);
				ps.setString(4,address);
				ps.setString(5,gender);
				ps.setString(6,state);
				ps.setString(7,city);
				ps.setString(8,emailid);
				ps.setString(9,password);
				ps.setString(10,dob);
				ps.setString(11,ques);
				ps.setString(12,ans);
				int i=ps.executeUpdate();
				PreparedStatement ps1=con.prepareStatement("insert into login(emailid,password,ques,ans)values(?,?,?,?)");
				ps1.setString(1,emailid);
				ps1.setString(2,password);
				ps1.setString(3,ques);
				ps1.setString(4,ans);
				int j=ps1.executeUpdate();
				if(i!=0&&j!=0)
				{
					String message="Registered successfully.you can LogIn now";
					request.setAttribute("msg",message);
					getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
				}
				else
				{
					String message="Plz Try Again";
					request.setAttribute("msg",message);
					getServletContext().getRequestDispatcher("/contact.jsp").include(request,response);
				}
			}
			else
			{
						String message="enter same password";
						request.setAttribute("msg",message);
						getServletContext().getRequestDispatcher("/contact.jsp").include(request,response);
			}
			}
		
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

else
{
	String message="enter same captcha";
	request.setAttribute("msg",message);
	getServletContext().getRequestDispatcher("/contact.jsp").include(request,response);
}}
}
