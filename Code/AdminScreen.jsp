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
				<center>
				  <br>
				  
				  <br>
	 <font size="6" face='monotype corsiva'>Administrator Screen</font>
	 <br><br>
	  <%
	 String data=request.getParameter("t1");
	 if(data!=null){
		 out.println(data);
	 }
	 %>
	 </center>
		 <table align="right"><tr><td> <font size="2" >Data visualization simplifies complex structure of analytical/large data. The simplification helps a brod range of users to help in decision  making. Data experts and analysts can understand complex statistical reports but most of the time it's difficult for decision makers to interpret it accurately and examine all the possibilities</p><br>
		 <p> The objective of this project would to integrate different data visualization methods avaialble with different consumability factors to make the data information on hand more accessible and user-friendly.</p><br>
		 <p>
		 Consumability factor is based on the business context, the role of the user, and the expertise level </p></font>
        
				</td></tr></table>
            </div>
            <div class="cleaner_with_width">&nbsp;</div>
    	<div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
   
</body>
</html>