package ConLib;

public class ReqMenuLib {
	int uid;
	int menuid;
	String item;
	String quantiy;
	String date;
	String Type;
	public ReqMenuLib() {
		
		this.uid = 0;
		this.menuid = 0;
		this.item = "";
		this.quantiy = "";
		this.date = "";
		Type = "";
	}
	public ReqMenuLib(int uid, int menuid, String item, String quantiy, String date, String type) {
		
		this.uid = uid;
		this.menuid = menuid;
		this.item = item;
		this.quantiy = quantiy;
		this.date = date;
		Type = type;
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
	public String getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(String quantiy) {
		this.quantiy = quantiy;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
}
