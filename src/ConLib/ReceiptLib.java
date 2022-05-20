package ConLib;

public class ReceiptLib {
	int uid;
	int billno;
	String name;
	String vat;
	String checkindate;
	String checkoutdate;
	String billdate;
	String item;
	String Quantity;
	String Total;
	public ReceiptLib() {
		this.uid = 0;
		this.billno = 0;
		this.name = "";
		this.vat = "";
		this.checkindate = "";
		this.checkoutdate = "";
		this.billdate = "";
		this.item = "";
		Quantity = "";
		Total = "";
	}
	public ReceiptLib(int uid, int billno, String name,String vat, String checkindate, String checkoutdate, String billdate,
			String item, String quantity, String total) {
		this.uid = uid;
		this.billno = billno;
		this.name = name;
		this.vat = vat;
		this.checkindate = checkindate;
		this.checkoutdate = checkoutdate;
		this.billdate = billdate;
		this.item = item;
		Quantity = quantity;
		Total = total;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getBillno() {
		return billno;
	}
	public void setBillno(int billno) {
		this.billno = billno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	public String getCheckindate() {
		return checkindate;
	}
	public void setCheckindate(String checkindate) {
		this.checkindate = checkindate;
	}
	public String getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public String getTotal() {
		return Total;
	}
	public void setTotal(String total) {
		Total = total;
	}
	
}
