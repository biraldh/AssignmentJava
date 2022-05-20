package ConLib;

public class MenuLib {
	int menuId;
	String item;
	String rate;
	String quantity;
	String type;
	String status;
	String date;
	public MenuLib() {
		
		this.menuId = 0;
		this.item = "";
		this.rate = "";
		this.quantity = "";
		this.type = "";
		this.status = "";
		this.date = "";
	}
	public MenuLib(int menuId, String item, String rate, String quantity, String type, String status, String date) {
		
		this.menuId = menuId;
		this.item = item;
		this.rate = rate;
		this.quantity = quantity;
		this.type = type;
		this.status = status;
		this.date = date;
	}
	public int getmenuId() {
		return menuId;
	}
	public void setmenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
