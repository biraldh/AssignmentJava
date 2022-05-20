package ConLib;

public class ServiceLibdata {
	int serviceId;
	int uid;
	String item;
	String status;
	String quantity;
	String date;
	public ServiceLibdata() {

		this.serviceId = 0;
		this.uid = 0;
		this.item = "";
		this.status = "";
		this.quantity = "";
		this.date = "";
	}

	public ServiceLibdata(int serviceId, int uid, String item, String status, String quantity, String Date) {

		this.serviceId = serviceId;
		this.uid = uid;
		this.item = item;
		this.status = status;
		this.quantity = quantity;
		this.date = Date;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
