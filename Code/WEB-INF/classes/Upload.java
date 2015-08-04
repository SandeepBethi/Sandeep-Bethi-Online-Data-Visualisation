package data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       byte b[]=null;
       String user,file,type;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DiskFileItemFactory factory = new DiskFileItemFactory();
	    factory.setSizeThreshold(1*1024*1024);
	    factory.setRepository(new File("\\usr"));
        ServletFileUpload upload = new ServletFileUpload(factory);
	    upload.setSizeMax(1*1024*1024);
        try{ 
	       List fileItems = upload.parseRequest(request);
		   Iterator itr = fileItems.iterator();
		   while(itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				 if (item.isFormField())
		           {
		              String name = item.getFieldName();
		              String value = item.getString();
		              if(name.equals("t1")){
		            	  user=value;
		              }
		              if(name.equals("t2")){
		            	  type=value;
		              }
		           }else{
					   file = item.getName();
		        	   InputStream in=item.getInputStream();
		        	   b = new byte[in.available()];
		        	   in.read(b,0,b.length);
		           }
		   }
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   try{
		int i=DBCon.saveInput(user,type,file,b);
		if(i > 0){
			RequestDispatcher rd=request.getRequestDispatcher("DataExpert.jsp?t1=Input uploaded successfully");
			rd.forward(request,response);
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("Upload.jsp?t1=Error in uploading input");
				rd.forward(request,response);	
			}
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	}

}
