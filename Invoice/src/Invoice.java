import java.util.Date;

public class Invoice {

	public static final String FORMAT_STRING =
			"| %19s | %13s | %14s | %14s | %13s | %10s |";
	public static final String HEADER =
			InvoiceLine.LINE + "\n" + String.format(FORMAT_STRING, 
					InvoiceLine.center("SALESPERSON",19), InvoiceLine.center("SHIP METHOD",13), InvoiceLine.center("SHIP TERMS", 14), InvoiceLine.center("DELIVERY DATE",14),InvoiceLine.center("PAY TERMS",12),InvoiceLine.center("DUE DATE",10))
			+ "\n" + InvoiceLine.LINE;
	public static final double GST = 534.39;
	public static final String LINE1 = "-----------";
	public static final String LINE2 = "-----------------";
	
	
	private int inv;
	private Date date;
	private String nameTo;
	private String nameShipTo;
	
	private String salesPerson;
	private String shippingMethod;
	private String shippingTerms;
	private Date deliveryDate;
	private String paymentTerms;
	private Date dueDate;
	
	private InvoiceLine[] arrInvice = new InvoiceLine[20];
	
	public Invoice(int inv,Date date,String nameTo,String nameShipTo,String salesPerson, String shippingMethod, String shippingTerms, Date deliveryDate, String paymentTerms, Date dueDate) {
		this.inv = inv;
		this.date = date;
		this.nameTo = nameTo;
		this.nameShipTo = nameShipTo;
		
		this.salesPerson = salesPerson;
		this.shippingMethod = shippingMethod;
		this.shippingTerms = shippingTerms;
		this.deliveryDate = deliveryDate;
		this.paymentTerms = paymentTerms;
		this.dueDate = dueDate;
		
	}
	
	public void addInvoiceLine(InvoiceLine invoiceLine) {
		int count = 0;
		
		while (arrInvice[count] != null ) {
			count++;
		}
		
		arrInvice[count] = invoiceLine;
		
	}
	
	@Override
	public String toString() {

		String s = String.format("Inv# %d%n"
				+ String.format("Date: %tB %te, %tY%n", date,date,date) + "\n"
				+ "TO:  %s                                 SHIP TO: %s" + "\n", inv,nameTo,nameShipTo);
		
		s += HEADER + "\n";
		
		s += String.format(FORMAT_STRING,
				InvoiceLine.center(salesPerson,19),
				InvoiceLine.center(shippingMethod,13),
				InvoiceLine.center(shippingTerms,14),
				InvoiceLine.center(String.format("%tD", deliveryDate),14),
				InvoiceLine.center(paymentTerms,12),
				InvoiceLine.center(String.format("%tD", dueDate),10));
		
		s += "\n";
		
		s += InvoiceLine.LINE; 
		
		s += "\n";
		
		s += InvoiceLine.HEADER;
		
		s += "\n";
		
		s += printInvoiceLine();
		
		s += InvoiceLine.LINE; 
		
		s += "\n" + String.format("                                                           TOTAL DISCOUNT | %8s | %13s |",InvoiceLine.customFormat("##.00%",InvoiceLine.TotalDiscount/100),InvoiceLine.customFormat("$#,###,###.00", calculateLineTotal() * (100 - InvoiceLine.TotalDiscount)/100));
		
		s += "\n";
		
		s += "                                                                          " + LINE1 + LINE2;
		
		s += "\n" + String.format("                                                                            SUBTOTAL | %13s | ",InvoiceLine.customFormat("$#,###,###.00", calculateSubTotal()));
		
		s += "\n";
		
		s += "                                                                                     " + LINE2;
		
		s += "\n" + String.format("                                                                                 GST | %13s | ",InvoiceLine.customFormat("$#,###,###.00", GST));
		
		s += "\n";
		
		s += "                                                                                     " + LINE2;
		
		s += "\n" + String.format("                                                                               TOTAL | %13s | ",InvoiceLine.customFormat("$#,###,###.00", GST + calculateSubTotal()));
		
		s += "\n";
		
		s += "                                                                                     " + LINE2;
		
		s += "\n";
		
		return s;
	}
	
	private double calculateSubTotal() {
		double dou = calculateLineTotal() * (100 - InvoiceLine.TotalDiscount)/100;
		return dou;
	}
	
	private String printInvoiceLine() {
		String s = "";
		
		int count = 0;
		
		while (arrInvice[count] != null ) {
			s += arrInvice[count].toString() + "\n";
			count++;
		}
		
		return s;
	}
	
	private double calculateLineTotal() {
		int count = 0;
		double calLineTotal = 0;
		
		while (arrInvice[count] != null ) {
			calLineTotal += arrInvice[count].getLineTotal();
			count++;
		}
		return calLineTotal;
	}
	
	
}
