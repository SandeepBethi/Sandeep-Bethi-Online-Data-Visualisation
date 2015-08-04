package data;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


public class CreateUser extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	PrintWriter out = response.getWriter();
	String user=request.getParameter("t1").trim();
	String pass=request.getParameter("t2").trim();
	String cname=request.getParameter("t3").trim();
	String address=request.getParameter("t4").trim();
	String contact=request.getParameter("t5").trim();
	String email=request.getParameter("t6").trim();
	String usertype=request.getParameter("t7").trim();
	try{
		String input[]={user,pass,cname,address,contact,email,usertype};
		String res = DBCon.register(input);
    if(res.equals("success")){
		RequestDispatcher rd=request.getRequestDispatcher("AdminScreen.jsp?t1=User created successfully");
		rd.forward(request, response);
		
	}
	else{
		RequestDispatcher rd=request.getRequestDispatcher("CreateUser.jsp?t1=Error in creating user");
		rd.forward(request, response);
		 }
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
