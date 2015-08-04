package data;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.Statement;
import java.util.ArrayList;
public class DBCon{
	static ArrayList<String> dataset = new ArrayList<String>();
	static ArrayList<String> dup=new ArrayList<String>();
	static ArrayList<Pattern> pattern = new ArrayList<Pattern>();
    private static Connection con;
public static ArrayList<Pattern> getResult()throws Exception{
	pattern.clear();
	con = DBCon.getCon();
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from resulttable");
	while(rs.next()){
		Pattern pat = new Pattern();
		pat.setProduct(rs.getString(1));
		pat.setCount(rs.getInt(2));
		pat.setDate(rs.getDate(3));
		pattern.add(pat);
	}
	rs.close();
	stmt.close();
	con.close();
	return pattern;
}
public static Connection getMysql()throws Exception{
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost/products","root","root");
	return con;
}
public static void countItems(){
	for(int i=0;i<dataset.size();i++){
		String data[] = dataset.get(i).split("#");
		String row[]=data[0].trim().split(",");
		for(int j=0;j<row.length;j++){
			String item = row[j];
			if(!dup.contains(item)){
				int count = getCount(item);
				Pattern pat = new Pattern();
				pat.setProduct(item);
				pat.setCount(count);
				pat.setDate(java.sql.Date.valueOf(data[1].trim()));
				pattern.add(pat);
				dup.add(item);
			}
		}
	}
}
public static int getCount(String item){
	int count=0;
	for(int i=0;i<dataset.size();i++){
		String data[] = dataset.get(i).split("#");
		String row[]=data[0].trim().split(",");
		for(int j=0;j<row.length;j++){
			if(row[j].equals(item))
				count++;
		}
	}
	return count;
}

public static int saveInput(String user,String type,String file,byte b[])throws Exception{
	int j=0;
	dataset.clear();
	dup.clear();
	pattern.clear();
	if(type.equals("DB2")){
		String input = new String(b);
		con = getCon();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+input);
		while(rs.next()){
			String products = rs.getString(1);
			java.sql.Date date = rs.getDate(2);
			dataset.add(products+"#"+date.toString());
		}
		rs.close();stmt.close();con.close();
		countItems();
		j = save();
	}
	if(type.equals("Mysql")){
		String input = new String(b);
		con = getMysql();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+input);
		while(rs.next()){
			String products = rs.getString(1);
			java.sql.Date date = rs.getDate(2);
			dataset.add(products+"#"+date.toString());
		}
		rs.close();stmt.close();con.close();
		countItems();
		j = save();
	}
	if(type.equals("Text")){
		String input = new String(b);
		String data[]=input.split("\n");
		for(int i=0;i<data.length;i++){
			dataset.add(data[i]);
		}
		countItems();
		j = save();
	}
	if(type.equals("Excel")){
		dataset = ReadExcel.read(b);
		countItems();
		j = save();
	}
	if(type.equals("Xml")){
		ReadXml.load(new String(b));
		dataset = ReadXml.Search(dataset);
		countItems();
		j = save();
	}
	return j;
}
public static int save()throws Exception{
	int j=0;
	con = getCon();
	PreparedStatement stat = con.prepareStatement("delete from resulttable");
	stat.executeUpdate();
	stat.close();
	stat = con.prepareStatement("insert into resulttable values(?,?,?)");
	for(int i=0;i<pattern.size();i++){
		Pattern pat = pattern.get(i);
		stat.setString(1,pat.getProduct());
		stat.setInt(2,pat.getCount());
		stat.setDate(3,pat.getDate());
		j = j+stat.executeUpdate();
	}
	stat.close();
	con.close();
	return j;
}
public static String backup()throws Exception{
	String output="";
	BufferedReader stdInput = null, stdError = null;
	String line=null;
	String cmd = "db2cmd.exe db2 backup db data to C://backup compress without prompting";  
	Process p = Runtime.getRuntime().exec("cmd /C "+cmd);
    stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        while ((line = stdInput.readLine()) != null){
			if (!(line.equals("")))
                 output+=line;
		}
		while ((line = stdError.readLine()) != null){
			if (!(line.equals("")))
				output+=line;
		}    
	return output;
}
public static Connection getCon()throws Exception {
    try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/data","root","root");
	}catch(Exception e){
		e.printStackTrace();
	}
	return con;
}
public static String addBusiness(String[] input)throws Exception{
    String msg="fail";
    con = getCon();
    PreparedStatement stat=con.prepareStatement("insert into business_details values(?,?,?,?)");
    stat.setString(1,input[0]);
    stat.setString(2,input[1]);
    stat.setString(3,input[2]);
    stat.setString(4,input[3]);
    int i=stat.executeUpdate();
    if(i > 0)
        msg = "success";
    stat.close();
	con.close();
    return msg;
}

public static String register(String[] input)throws Exception{
    String msg="no";
    boolean flag=false;
    boolean flag1=false;
    con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select username from register where username='"+input[0]+"'");
    if(rs.next()){
        flag=true;
        msg = "Username already exist";
    }
	stmt.close();
    stmt=con.createStatement();
    rs=stmt.executeQuery("select password from register where password='"+input[1]+"'");
    if(rs.next()){
        flag1=true;
        msg = "Password already exist";
    }
	rs.close();
	stmt.close();
    if(!flag && !flag1){
    PreparedStatement stat=con.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
    stat.setString(1,input[0]);
    stat.setString(2,input[1]);
    stat.setString(3,input[2]);
    stat.setString(4,input[3]);
    stat.setString(5,input[4]);
	stat.setString(6,input[5]);
	stat.setString(7,input[6]);
	int i=stat.executeUpdate();
    if(i > 0)
        msg = "success";
    stat.close();
	}
	con.close();
    return msg;
}
public static String login(String input[])throws Exception{
    String msg="fail";
    con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select username,password from register where username='"+input[0]+"' and password='"+input[1]+"' and usertype='"+input[2]+"'");
    if(rs.next()){
        msg = "success";
    }
	rs.close();
	stmt.close();
	con.close();
    System.out.println(msg);
    return msg;
}

}
