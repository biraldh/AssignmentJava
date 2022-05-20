package ConLib;

public class ReceiptLib2 {
	int uid;
	int billno;
	String item;
	String Quantity;
	String Total;
	public ReceiptLib2() {
		this.uid = 0;
		this.billno = 0;
		this.item = "";
		Quantity = "";
		Total = "";
	}
	public ReceiptLib2(int uid, int billno, 
			String item, String quantity, String total) {
		this.uid = uid;
		this.billno = billno;
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
