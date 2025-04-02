package UtilityProperites;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtilities {

	//Excel
	public String Excelrr(String SheetName,int RowNum,int CellNum ) throws EncryptedDocumentException, IOException
	{
		String Excel="C:\\Users\\pradhiv.v\\eclipse-workspace\\weqw\\src\\test\\resources\\Excel\\Product.xlsx";
		FileInputStream first =new FileInputStream(Excel);
		Workbook book = WorkbookFactory.create(first);
		String readin = book.getSheet(SheetName).getRow(RowNum).getCell(CellNum).getStringCellValue();
		return readin;
	}
	
	//properties File
	public String readindataproperti(String key) throws IOException
	{
	String propFile="C:\\Users\\pradhiv.v\\eclipse-workspace\\weqw\\src\\test\\resources\\Properties\\DataDDTProp.properties";
	
	FileInputStream ss=new FileInputStream(propFile);
	Properties prop=new Properties();
	prop.load(ss);
	String data = prop.getProperty(key);
	return data;
   
	}
	
	//JSON File
	public String readingJson(String Keys) throws IOException, ParseException
	
	{
		
		JSONParser parsee=new JSONParser();
		FileReader file=new FileReader("E:\\eclipse-workspace\\weqw\\src\\test\\resources\\Json\\Login.json");
		Object obj = parsee.parse(file);
		JSONObject jsonobj = (JSONObject)obj;
		String main = jsonobj.get(Keys).toString();
		return main;
		
		
	}
	
}
