<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script LANGUAGE="Javascript" >
function validate(){
	var x=document.forms["f1"]["t1"].value;
	var y=document.forms["f1"]["t2"].value;
	if(x == null || x==""){
		window.alert("Username must be enter");
		document.f1.t1.focus();
		return false;
	}
	if(y == null || y==""){
		window.alert("Password must be enter");
		document.f1.t2.focus();
		return false;
	}
	return true;
}
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
                    <li><a href="index.html"><font size=3 color="lightgreen">Home</a></li></font><br><br>
                    <li><a href="AdminLogin.jsp"><font size=3 color="lightgreen">Admin</a></li></font><br><br>
                    <li><a href="DataLogin.jsp"><font size=3 color="lightgreen">Data Expert</a></li></font><br><br>
                    <li><a href="ManagerLogin.jsp"><font size=3 color="lightgreen">Manager</a></li></font><br><br>
                    <li><a href="SupervisorLogin.jsp"><font size=3 color="lightgreen">Supervisor</a></li></font><br><br>
            	</ul>
				</table></td></tr>
				 
		
           </div>
		  <center>
		  <br/><br/>
	 <%
	 String data=request.getParameter("t1");
	 if(data!=null){
		 out.println(data);
	 }
	 %>
	 <br><br>
	 <font size="6" face='monotype corsiva'>Data Expert Login Screen</font>
	<form name="f1" method="post" action="DataExpert" OnSubmit="return validate()">
		
		<TABLE align=center width="20%" class="notepad">
		<TR class="row_title">
		</TR>
		<tr>
		  <TD align="left"><FONT SIZE="4"  face='monotype corsiva'>User ID</FONT></TD>
		  <TD><Input type="text" name="t1"   size="15"></TD></tr><br>

		  <tr><TD align="left"><FONT SIZE="4"  face='monotype corsiva'>Password</TD>
		  <TD><Input type="password" name="t2"  size="15"></TD>
  		  <tr><td></td>
		  <TD><input type="submit" value="Login"><br><br>
		  <br>
		 
		  </TABLE>
		   
		 
		  </tr>
	
</FORM>
</center>
            <div class="cleaner_with_width">&nbsp;</div>
    	<div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
   
</body>
</html>