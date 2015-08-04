package data;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class ReadExcel {
	@SuppressWarnings("unchecked")
    public static ArrayList<String> read(byte b[]) throws Exception{
		List sheetData = new ArrayList();
		try{
			InputStream is = new ByteArrayInputStream(b);     
            HSSFWorkbook workbook = new HSSFWorkbook(is);
            HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
				List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
            }
		}catch(Exception e){
			e.printStackTrace();
        } 
        return showExelData(sheetData);
		
    }

    private static ArrayList<String> showExelData(List sheetData) {
		StringBuilder sb = new StringBuilder(); 
		ArrayList<String> dataset = new ArrayList<String>();
        for (int i = 0; i < sheetData.size(); i++) {
            List list = (List) sheetData.get(i);
            for (int j = 0; j < list.size(); j++) {
                HSSFCell cell = (HSSFCell) list.get(j);
                if(j == 0)
					sb.append(cell.getStringCellValue()+"#");
				if(j == 1){
					java.sql.Date dd = new java.sql.Date(cell.getDateCellValue().getTime());
					sb.append(dd.toString());
				}
                if (j < list.size() - 1) {
                    System.out.print("---");
                }
            }
			dataset.add(sb.toString());
            sb.delete(0,sb.length());
        }
		return dataset;
    }
}