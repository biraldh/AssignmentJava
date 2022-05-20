package ConLib;

public class MenuLibdata {
	int uid;
	int menuid;
	String item;
	String statu;
	String quantity;
	String date;
	public MenuLibdata() {
		
		this.uid = 0;
		this.menuid = 0;
		this.item = "";
		this.statu = "";
		this.quantity = "";
		this.date = "";
	}
	public MenuLibdata(int uid, int menuid, String item, String statu, String quantity, String date) {
		
		this.uid = uid;
		this.menuid = menuid;
		this.item = item;
		this.statu = statu;
		this.quantity = quantity;
		this.date = date;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
