package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResetServlet
 */
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetServlet() {
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
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String emailid=request.getParameter("userid");
		String opassword=request.getParameter("password");
		String npassword=request.getParameter("password1");
		String cpassword=request.getParameter("password2");
		String mpassword=(String)session.getAttribute("oldpassword");
		if(emailid.equals("")||opassword.equals("")||npassword.equals("")||cpassword.equals(""))
		{
			String message="All fields are mandatory";
			request.setAttribute("msg",message);
			getServletContext().getRequestDispatcher("/resetpassword.jsp").include(request, response);
		}
		else 
		{
			try
			{
				if(opassword.equals(mpassword))
				{
					if(npassword.equals(cpassword))
					{
				Class.forName("com.ibm.db2.jcc.DB2Driver");
				Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/abc1","Niharika1","auckland");
				PreparedStatement ps=con.prepareStatement("update register set(password)=(?) where emailid=?");
				ps.setString(1,npassword);
				ps.setString(2, emailid);
				int i=ps.executeUpdate();
				PreparedStatement ps1=con.prepareStatement("update login set(password)=(?) where password=?");
				ps1.setString(1,npassword);
				ps1.setString(2, emailid);
				int j=ps1.executeUpdate();
				if(i!=0&&j!=0)
				{
					String message="Password changed successfully";
					request.setAttribute("msg", message);
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
				else
				{
					String message="Please try again";
					request.setAttribute("msg",message);
					getServletContext().getRequestDispatcher("/resetpassword.jsp").include(request,response);
				}
					}
				else
				{
					String message="enter same password";
					request.setAttribute("msg",message);
					getServletContext().getRequestDispatcher("/resetpassword.jsp").include(request,response);
				}
					}
					else
					{
						String message="enter same old password";
						request.setAttribute("msg",message);
						getServletContext().getRequestDispatcher("/resetpassword.jsp").include(request,response);
					}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	
	}
}

