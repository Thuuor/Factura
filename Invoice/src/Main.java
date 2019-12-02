import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		InvoiceLine line = new InvoiceLine(1, "LP150-C" , "PS150-Centric SJ5_8,Lorentz", 268, 0); 
		InvoiceLine line2 = new InvoiceLine(1000, "VD90a" , "AXC200 syringes", 2.99, 0); 
		InvoiceLine line3 = new InvoiceLine(3, "TYDE3" , "JIN 2l reagent", 98, 0); 
		InvoiceLine line4 = new InvoiceLine(1, "" , "Overnight shipping Ft icepack", 238, 0); 
		
		Invoice inv = new Invoice(12, createDate(2011, 12, 19), "Care Plus Clinic", "Salina abgulmante", "Jene Pawjuk", "UPS", "Due on receipt",  createDate(2011, 01, 07),"Credit Card",  createDate(2012, 03, 04));
		inv.addInvoiceLine(line);
		inv.addInvoiceLine(line2);
		inv.addInvoiceLine(line3);
		inv.addInvoiceLine(line4);
		
		
		System.out.print(inv.toString());

	}

	public static Date createDate(int year,int month,int day){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		
		Date myDate = cal.getTime();
		return myDate;
		
	}
}
