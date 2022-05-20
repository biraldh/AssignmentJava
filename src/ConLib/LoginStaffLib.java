package ConLib;

public class LoginStaffLib {
	int staffID;
	String name;
	String type;
	String email;
	int phone;
	String address;
	String uname;
	String pass;

	public LoginStaffLib() {

		this.staffID = 0;
		this.name = "";
		this.type = "";
		this.email = "";
		this.phone = 0;
		this.address = "";
		this.uname ="";
		this.pass="";
	}

	public LoginStaffLib(int staffID, String name, String type, String email, int phone, String address, String uname, String pass) {

		this.staffID = staffID;
		this.name = name;
		this.type = type;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.uname = uname;
		this.pass = pass;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
