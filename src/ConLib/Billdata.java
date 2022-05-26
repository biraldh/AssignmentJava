package ConLib;

public class Billdata {
	int bookingid;
	int uid;
	String quantity;
	String quantity2;
	String menu;
	String service;
	int room;
	String date;
	public Billdata() {
		this.bookingid = 0;
		this.uid = 0;
		this.quantity = "";
		this.quantity2 = "";
		this.menu = "";
		this.service = "";
		this.room = 0;
		this.date = "";
	}
	public Billdata(int bookingid, int Uid, String quantity, String quantity2, String menu, String service, int room, String date) {
		this.bookingid = bookingid;
		this.uid = Uid;
		this.quantity = quantity;
		this.quantity2 = quantity2;
		this.menu = menu;
		this.service = service;
		this.room = room;
		this.date = date;
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getQuantity2() {
		return quantity2;
	}
	public void setQuantity2(String quantity2) {
		this.quantity2 = quantity2;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
