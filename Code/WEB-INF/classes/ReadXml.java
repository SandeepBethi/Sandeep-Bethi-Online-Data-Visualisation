package data;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 
import org.xml.sax.InputSource;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
public class ReadXml{
	static DocumentBuilderFactory docBuilderFactory; 
    static DocumentBuilder docBuilder;
    static Document doc;
    
    public static void load(String data){
		try{
			docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.parse(new InputSource(new ByteArrayInputStream(data.getBytes("utf-8"))));
            doc.getDocumentElement ().normalize ();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static ArrayList<String> Search(ArrayList<String> dataset){
		try{
		    NodeList list = doc.getElementsByTagName("product");
            for(int i=0;i<list.getLength();i++){
				Node zipinfo = list.item(i);
				if(zipinfo.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element)zipinfo;
					NodeList zip = element.getElementsByTagName("product-name");
                    Element ele = (Element)zip.item(0);
					NodeList key = ele.getChildNodes();
					String value = ((Node)key.item(0)).getNodeValue().trim();
					NodeList latitude = element.getElementsByTagName("purchase-date");
					Element lat = (Element)latitude.item(0);
					NodeList s1 = lat.getChildNodes();
					String   s2 = ((Node)s1.item(0)).getNodeValue().trim();
					dataset.add(value+"#"+s2);
				}
			}	
		}catch (Exception e) {
			e.printStackTrace ();
        }
       return dataset;
    }


}