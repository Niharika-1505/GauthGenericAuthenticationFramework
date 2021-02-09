package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.PasswordMail;
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public VerificationServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		String data="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String verify="";
		char ch[]=data.toCharArray();
		for(int i=0;i<6;i++)
		{
			int j=(int)((Math.random())*62);
			verify=verify+ch[j];
			
		}
		
		System.out.println(verify);
		PasswordMail mail=new PasswordMail();
		try {
			boolean status=mail.sendMail(userid, verify);
			if(status)
			{
				session.setAttribute("verify", verify);
				getServletContext().getRequestDispatcher("/verify.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
