import java.text.DecimalFormat;

public class InvoiceLine {

	public static final String LINE = 
			"------------------------------------------------------------------------------------------------------";
	public static final String FORMAT_STRING =
			"| %9s | %10s | %30s | %13s | %8s | %13s |";
	public static final String HEADER =
			LINE + "\n" + String.format(FORMAT_STRING, 
					center("QTY",9), center("ITEM #",10), center("DESCRIPTION", 30), center("UNIT PRICE",13),center("DISCOUNT",8),center("LINE TOTAL",13))
			+ "\n" + LINE;
	
	private int qty;
	private String item;
	private String description;
	private double price;
	private float discountPercent;
	private double lineTotal;
	
	public InvoiceLine(int qty,String item,String description,double price,float discount) {
		this.qty = qty;
		this.item = item;
		this.description = description;
		this.price = price;
		this.discountPercent = discount / 100;
		lineTotal = qty * price * (100 - discount)/100;
	}
	
	static public String customFormat(String pattern, double value ){
		 DecimalFormat myFormatter = new DecimalFormat(pattern);
		 String output = myFormatter.format(value);
		 return output;
		 }
	
	@Override
	public String toString() {
		String s = String.format("| %-9s | %-10s | %-30s | %13s | %8s | %13s |",
				customFormat("###,###", qty),
				item,
				description,
				customFormat("$####.00",price),
				customFormat("##.00%",discountPercent),
				customFormat("$#,###,###.00",lineTotal));
		return s;
	}
	
	public static String center(String s, int size) {
        return center(s, size, ' ');
    }

    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }
}
