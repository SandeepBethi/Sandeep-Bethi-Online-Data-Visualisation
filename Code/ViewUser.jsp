<%@page import="data.DBCon,java.sql.Connection,java.sql.Statement,java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online Data Visualization</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="templatemo_container">
	<div id="templatemo_menu">
    	
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
	<FONT SIZE="5" FACE="courier" COLOR=blue><MARQUEE WIDTH=100% height="25" align="center" BEHAVIOR=ALTERNATE BGColor="#4CC417">Online Data Visualization</MARQUEE></FONT>
    	 
     
        <br><br><br><br>  <br> <br><br><br><br>   <br><br><br> <br><br><br> <br><br><br>
              
				<table align="left"><tr><td>
<ul>
                    <li><a href="CreateUser.jsp"><font size=3 color="lightgreen">Create Users</a></li></font><br><br>
                    
                    <li><a href="ViewUser.jsp"><font size=3 color="lightgreen">View Users</a></li></font><br><br>
                    <li><a href="Logout.jsp"><font size=3 color="lightgreen">Logout</a></li></font><br><br>
                    
            	</ul>
				</table></td></tr>
				
		 <table align="center" border="1">
		 <tr><th>Username</th><th>Company Name</th><th>Company Address</th>
		 <th>Contact No</th><th>Email ID</th><th>UserType</th>
		<%
		try{
			Connection con=DBCon.getCon();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from register");
			while(rs.next()){%>
			<tr><td><%=rs.getString(1)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td><%=rs.getString(6)%></td>
			<td><%=rs.getString(7)%></td>
			<%}
			rs.close();
			stmt.close();
			con.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		%>
		 </table>
            </div>
            <div class="cleaner_with_width">&nbsp;</div>
    	<div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
   
</body>
</html>