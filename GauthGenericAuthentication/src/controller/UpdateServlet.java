package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String contact=request.getParameter("contact");
			String address=request.getParameter("address");
			String state=request.getParameter("state");
			String city=request.getParameter("city");
			String emailid=request.getParameter("userid");
			String password=request.getParameter("password");
			String ques=request.getParameter("ques");
			String ans=request.getParameter("ans");
			if(fname.equals("")||lname.equals("")||contact.equals("")||address.equals("")||
					emailid.equals("")||password.equals("")||
					ans.equals(""))
			{
				String message="All fields are mandatory";
				request.setAttribute("msg",message);
				getServletContext().getRequestDispatcher("/update.jsp").include(request, response);
			}
			else 
			{
				try
				{
					Class.forName("com.ibm.db2.jcc.DB2Driver");
					Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/abc1","Niharika1","auckland");
					PreparedStatement ps=con.prepareStatement("update register set(fname,lname,contact,address,state,city,password,ques,ans)=(?,?,?,?,?,?,?,?,?)where emailid=?");
					ps.setString(1,fname);
					ps.setString(2,lname);
					ps.setString(3,contact);
					ps.setString(4,address);
					ps.setString(5,state);
					ps.setString(6,city);
					ps.setString(10,emailid);
					ps.setString(7,password);
					ps.setString(8,ques);
					ps.setString(9,ans);
					int i=ps.executeUpdate();
					PreparedStatement ps1=con.prepareStatement("update login set(password,ques,ans) =(?,?,?)where emailid=?");
					ps1.setString(4,emailid);
					ps1.setString(1,password);
		 			ps1.setString(2,ques);
					ps1.setString(3,ans);
					int j=ps1.executeUpdate();
					if(i!=0&&j!=0)
					{
						String message="updated sucessfully";
						request.setAttribute("userid", message);
						getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
					}
					else
					{
					String message="Please Try again";
					request.setAttribute("msg",message);
					getServletContext().getRequestDispatcher("/update.jsp").include(request, response); 
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}

	}

