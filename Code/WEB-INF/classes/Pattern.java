package data;
public class Pattern
{
	String product;
	int count;
	java.sql.Date date;
public void setProduct(String product){
	this.product=product;
}
public String getProduct(){
	return product;
}
public void setCount(int count){
	this.count=count;
}
public int getCount(){
	return count;
}
public void setDate(java.sql.Date date){
	this.date = date;
}
public java.sql.Date getDate(){
	return date;
}
}
