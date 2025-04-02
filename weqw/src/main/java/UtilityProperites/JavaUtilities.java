package UtilityProperites;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilities {
	
	
	public int random(int num1) {
	Random word =new Random();
    int num2 = word.nextInt(num1);
	return num2;
	
	}
	public String dassdte()
	{
		Date obj=new Date();
		SimpleDateFormat form=new SimpleDateFormat("dd-MM-yyyy");
		 String vb = form.format(obj);
	      System.out.println(vb);
	      return vb;
	}
	
	public String generateReqDate(int days)
	{
		Date dateObj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-YYYY");
		String todaysDate = sim.format(dateObj);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String closeDate = sim.format(cal.getTime());
		return closeDate;
	}
	
}


