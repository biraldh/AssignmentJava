package ConLib;

public class Billdata {
	int bookingid;
	String quantity;
	String menu;
	String service;
	int room;
	String date;
	public Billdata() {
		this.bookingid = 0;
		this.quantity = "";
		this.menu = "";
		this.service = "";
		this.room = 0;
		this.date = "";
	}
	public Billdata(int bookingid, String quantity, String menu, String service, int room, String date) {
		this.bookingid = bookingid;
		this.quantity = quantity;
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
