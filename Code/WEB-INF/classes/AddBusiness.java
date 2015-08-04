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


public class AddBusiness extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	PrintWriter out = response.getWriter();
	String user=request.getParameter("t1").trim();
	String cname=request.getParameter("t2").trim();
	String type=request.getParameter("t3").trim();
	String details=request.getParameter("t4").trim();
	
	try{
		String input[]={user,cname,type,details};
		String res = DBCon.addBusiness(input);
    if(res.equals("success")){
		RequestDispatcher rd=request.getRequestDispatcher("DataExpert.jsp?t1=Business details added successfully");
		rd.forward(request, response);
		
	}
	else{
		RequestDispatcher rd=request.getRequestDispatcher("AddBusiness.jsp?t1=Error in adding business details");
		rd.forward(request, response);
		 }
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
