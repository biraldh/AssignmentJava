package ConLib;

import java.sql.Date;

public class CorpLib {
	int id;
	String Name;
	String Dob;
	String gender;
	String email;
	String Address;
	int Phone;
	String Company;
	String cusType;

	public CorpLib() {

		id = 0;
		Name = "";
		Dob = "";
		this.gender = "";
		this.email = "";
		Address = "";
		Phone = 0;
		Company = "";
		this.cusType = "";
	}

	public CorpLib(int Id, String name, String dob, String gender, String email, String address, int phone,
			String company, String cusType) {
		
		id = Id;
		Name = name;
		Dob = dob;
		this.gender = gender;
		this.email = email;
		Address = address;
		Phone = phone;
		Company = company;
		this.cusType = cusType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int phone) {
		Phone = phone;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getCusType() {
		return cusType;
	}

	public void setCusType(String cusType) {
		this.cusType = cusType;
	}
	
}
