package ConLib;

public class LibServiceReq {
	int UId;
	String Service;
	String date;
	String Quantity;
	int serviceid;
	public LibServiceReq() {
		
		UId = 0;
		Service = "";
		this.date = "";
		Quantity = "";
		this.serviceid = 0;
	}
	public LibServiceReq(int uId, String service, String date, String quantity, int serviceid) {
		super();
		UId = uId;
		Service = service;
		this.date = date;
		Quantity = quantity;
		this.serviceid = serviceid;
	}
	public int getUId() {
		return UId;
	}
	public void setUId(int uId) {
		UId = uId;
	}
	public String getService() {
		return Service;
	}
	public void setService(String service) {
		Service = service;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	
}
