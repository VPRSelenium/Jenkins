package DDT_Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		String files="C:\\Users\\pradhiv.v\\eclipse-workspace\\weqw\\src\\test\\resources\\LoginCred.xlsx";
		FileInputStream bb=new FileInputStream(files);
		Workbook bop = WorkbookFactory.create(bb);
	    bop.createSheet("asdass").createRow(0).createCell(0).setCellValue("sadas");
		
		
		FileOutputStream kk=new FileOutputStream(files);
		
		bop.write(kk);
		bop.close();
		System.out.println("added succssfully");
		
		}

}
