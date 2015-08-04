<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script LANGUAGE="Javascript" >
function validate(){
	var x=document.forms["f1"]["t1"].value;
	var y=document.forms["f1"]["t2"].value;
	var type=document.forms["f1"]["t3"].value;
	var details=document.forms["f1"]["t4"].value;
	
	if(x == null || x==""){
		window.alert("Username must be enter");
		document.f1.t1.focus();
		return false;
	}
	if(y == null || y==""){
		window.alert("Company name must be enter");
		document.f1.t2.focus();
		return false;
	}
	if(type == null || type==""){
		window.alert("Business type must be enter");
		document.f1.t3.focus();
		return false;
	}
	if(details == null || details==""){
		window.alert("Business details must be enter");
		document.f1.t4.focus();
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
                   <li><a href="SuperVisual.jsp"><font size=3 color="lightgreen">Data Visualization</a></li></font><br><br>
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
	 <font size="6" face='monotype corsiva'>Visual Details Screen</font>
	<form name="f1" method="post" action="SuperView"  OnSubmit="return validate()">
		
		<TABLE align=center width="30%" class="notepad">
		<TR class="row_title">
		</TR>
		<tr>
		  <TD align="left"><FONT SIZE="4"  face='monotype corsiva'>Visual Type</FONT></TD>
		  <TD><select name="t1">
		  <option value="Table">Table</option>
		  <option value="bar">Bar chart</option>
		  <option value="pie">Pie chart</option>
		  </select>
		  </TD>
		
		  <tr><td></td>
		  <TD><input type="submit" value="View"><br><br>
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