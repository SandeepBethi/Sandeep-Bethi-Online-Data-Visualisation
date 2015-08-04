<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<html>
<body>
<%
response.setContentType("image/jpeg");  
OutputStream pout = response.getOutputStream();  
FileInputStream in = new FileInputStream("D:/bar.jpg");  
int size = in.available();  
byte[] content = new byte[size];  
in.read(content);  
pout.write(content);  
pout.flush();
in.close();  
pout.close();
%>
</body>
</html>