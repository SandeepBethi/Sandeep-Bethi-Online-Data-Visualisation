<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script LANGUAGE="Javascript" >
function validate(){
	var x=document.forms["f1"]["t1"].value;
	var y=document.forms["f1"]["t2"].value;
	var cname=document.forms["f1"]["t3"].value;
	var address=document.forms["f1"]["t4"].value;
	var contact=document.forms["f1"]["t5"].value;
	var email=document.forms["f1"]["t6"].value;
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
	if(cname == null || cname==""){
		window.alert("Company name must be enter");
		document.f1.t3.focus();
		return false;
	}
	if(address == null || address==""){
		window.alert("Address must be enter");
		document.f1.t4.focus();
		return false;
	}
	if(contact == null || contact==""){
		window.alert("Contact no must be enter");
		document.f1.t5.focus();
		return false;
	}
	if(email == null || email==""){
		window.alert("Email id must be enter");
		document.f1.t6.focus();
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
                    <li><a href="CreateUser.jsp"><font size=3 color="lightgreen">Create Users</a></li></font><br><br>
                    
                    <li><a href="ViewUser.jsp"><font size=3 color="lightgreen">View Users</a></li></font><br><br>
                    <li><a href="Logout.jsp"><font size=3 color="lightgreen">Logout</a></li></font><br><br>
                    
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
	 <font size="6" face='monotype corsiva'>Create Users Screen</font>
	<form name="f1" method="post" action="CreateUser" OnSubmit="return validate()">
		
		<TABLE align=center width="30%" class="notepad">
		<TR class="row_title">
		</TR>
		<tr>
		  <TD align="left"><FONT SIZE="4"  face='monotype corsiva'>User name</FONT></TD>
		  <TD><Input type="text" name="t1"   size="15"></TD></tr><br>

		  <tr><TD align="left"><FONT SIZE="4"  face='monotype corsiva'>Password</TD>
		  <TD><Input type="password" name="t2"  size="15"></TD>
		
			<tr><TD align="left"><FONT SIZE="4"  face='monotype corsiva'>Company Name</TD>
		  <TD><Input type="text" name="t3"  size="15"></TD>

			<tr><TD align="left"><FONT SIZE="4"  face='monotype corsiva'>Company Address</TD>
		  <TD><Input type="text" name="t4"  size="15"></TD>

		  <tr><TD align="left"><FONT SIZE="4"  face='monotype corsiva'>Contact No</TD>
		  <TD><Input type="text" name="t5"  size="15"></TD>

		  <tr><TD align="left"><FONT SIZE="4"  face='monotype corsiva'>Email ID</TD>
		  <TD><Input type="text" name="t6"  size="15"></TD>

		<tr><TD align="left"><FONT SIZE="4"  face='monotype corsiva'>User Type</TD>
		  <TD><select name="t7">
		  <option value="Data Expert">Data Expert</option>
		  <option value="Manager">Manager</option>
		  <option value="Supervisor">Supervisor</option>
		  </select></TD>




		
  		  <tr><td></td>
		  <TD><input type="submit" value="Create User"><br><br>
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