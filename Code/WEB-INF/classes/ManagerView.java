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
import java.util.ArrayList;

public class ManagerView extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	PrintWriter out = response.getWriter();
	String type=request.getParameter("t1").trim();
	
	try{
		ArrayList<Pattern> list= DBCon.getResult();
    if(type.equals("Table")){
		request.setAttribute("table",list);
		RequestDispatcher rd=request.getRequestDispatcher("ManagerTable.jsp");
		rd.forward(request, response);
	}
	if(type.equals("pie")){
		PieChartDemo demo=new PieChartDemo("Pie Chart",list);
		out.println("<br><br>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<a href=PieChart.jsp>Pie Chart</a>");
	}
	if(type.equals("bar")){
		BarChart chart=new BarChart("Bar Chart",list);
		out.println("<br><br>");
		out.println("<a href=BarChart.jsp>Bar Chart</a>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
