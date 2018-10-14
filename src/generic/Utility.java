package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	//getKeyword
	public static String getKeyword(String sheetName, int r, int c){
		String v= null;
		try{
			Workbook w = WorkbookFactory.create(new FileInputStream("./input/keyword.xlsx"));
			v = w.getSheet(sheetName).getRow(r).getCell(c).toString();
			w.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return v;
	}
	
	public static String getProperty(String key){
		String v = null;
		
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("./input/elements.properties"));
			v = p.getProperty(key);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
}
