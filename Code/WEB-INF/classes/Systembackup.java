package data;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Systembackup extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	PrintWriter out = response.getWriter();
	
	try{
		String msg=DBCon.backup();
    	RequestDispatcher rd=request.getRequestDispatcher("AdminScreen.jsp?t1="+msg);
		rd.forward(request, response);
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
