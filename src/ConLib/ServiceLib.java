package ConLib;

public class ServiceLib {
	int serviceid;
	int Customerid;
	String Services; 
	String Rate;
	String Status;
	String Date;
	String Types;
	String Quantity;
	public ServiceLib() {
		serviceid = 0;
		Customerid = 0;
		Services = "";
		Rate = "";
		Status = "";
		Date = "";
		Types = "";
		Quantity = "";
	}
	public ServiceLib(int serviceID, int customerid, String services, String rate, String status, String date, String types,
			String quantity) {
		serviceid = serviceID;
		Customerid = customerid;
		Services = services;
		Rate = rate;
		Status = status;
		Date = date;
		Types = types;
		Quantity = quantity;
	}
	
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	public int getCustomerid() {
		return Customerid;
	}
	public void setCustomerid(int customerid) {
		Customerid = customerid;
	}
	public String getServices() {
		return Services;
	}
	public void setServices(String services) {
		Services = services;
	}
	public String getRate() {
		return Rate;
	}
	public void setRate(String rate) {
		Rate = rate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTypes() {
		return Types;
	}
	public void setTypes(String types) {
		Types = types;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	
}
