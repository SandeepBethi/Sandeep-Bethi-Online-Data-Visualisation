<%@page import="data.Pattern,java.util.ArrayList,java.io.FileWriter"%>
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
                    <li><a href="AddBusiness.jsp"><font size=3 color="lightgreen">Add Business Details</a></li></font><br><br>
                    <li><a href="Upload.jsp"><font size=3 color="lightgreen">Upload Business Data</a></li></font><br><br>
                    <li><a href="DataVisual.jsp"><font size=3 color="lightgreen">Data Visualization</a></li></font><br><br>
                    <li><a href="Logout.jsp"><font size=3 color="lightgreen">Logout</a></li></font><br><br>
                    
            	</ul>
				</table></td></tr>
				
		 <table align="center" border="1">
		 <tr><th>Product Name</th><th>Count</th><th>Purchase Date</th>
		 
		<%
		try{
			java.util.Date d1 = new java.util.Date();
			java.sql.Date d2 = new java.sql.Date(d1.getTime());
			StringBuilder sb = new StringBuilder();
			String line = System.getProperty("line.separator");
			sb.append("<html>"+line+"<body>"+line+"<center>"+line+"<table border=1>"+line);
			sb.append("<tr><th>Product Name</th><th>Count</th><th>Purchase Date</th>"+line);
			ArrayList<Pattern> list = (ArrayList)request.getAttribute("table");
			for(int i=0;i<list.size();i++){
				Pattern pat=list.get(i);
				sb.append("<tr><td>"+pat.getProduct()+"</td>"+line);
				sb.append("<td>"+pat.getCount()+"</td>"+line);
				sb.append("<td>"+pat.getDate().toString()+"</td></tr>"+line);
				%>
			<tr><td><%=pat.getProduct()%></td>
			<td><%=pat.getCount()%></td>
			<td><%=pat.getDate().toString()%></td>
			
			<%}
			sb.append("</table>"+line+"</center>"+line+"</body>"+line+"</html>");
			FileWriter fw = new FileWriter("C:/record_"+d2.toString()+".html");
			fw.write(sb.toString());
			fw.flush();
			fw.close();
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