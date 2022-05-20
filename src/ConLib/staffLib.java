package ConLib;

public class staffLib {
	int id;
	String FullName;
	String Gender;
	String Address;
	String Country;
	String DOB;
	int PhoneNo;
	String Email;
	String StaffType;

	public staffLib() {
		id = 0;
		FullName = "";
		Gender = "";
		Address = "";
		Country = "";
		DOB = "";
		PhoneNo = 0;
		Email = "";
		StaffType = "";
	}

	public staffLib(int Id, String fullName, String gender, String address, String country, String dOB, int phoneNo,
			String email, String staffType) {
		id = Id;
		FullName = fullName;
		Gender = gender;
		Address = address;
		Country = country;
		DOB = dOB;
		PhoneNo = phoneNo;
		Email = email;
		StaffType = staffType;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public int getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getStaffType() {
		return StaffType;
	}

	public void setStaffType(String staffType) {
		StaffType = staffType;
	}

}
