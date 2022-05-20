package ConLib;

public class LoginLibs {
	int id;
    String Username;
    String Password;
    String   FullName; 
    String Gender; 
    String Address; 
    String DOB; 
    int PhoneNo; 
    String Email; 
    String type;
    String Company;
    
	public LoginLibs() {
		
		this.id = 0;
		Username = "";
		Password = "";
		FullName = "";
		Gender = "";
		Address = "";
		DOB = "";
		PhoneNo = 0;
		Email = "";
		type = "";
		Company = "";
	}

	public LoginLibs(int id, String username, String password, String fullName, String gender, String address,
			String dOB, int phoneNo, String email, String Type, String company) {
		
		this.id = id;
		Username = username;
		Password = password;
		FullName = fullName;
		Gender = gender;
		Address = address;
		DOB = dOB;
		PhoneNo = phoneNo;
		Email = email;
		type = Type;
		Company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
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

	public String gettype() {
		return type;
	}

	public void settype(String Type) {
		type = Type;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}
    
}