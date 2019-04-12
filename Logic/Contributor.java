package logic;

public class Contributor{
	private String username;
	private String password;
	private String gender;
	private String profession;
	private String contactNo;
	private boolean isValid;


	public Contributor(String username, String password, String gender, String profession, String contactNo) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.profession = profession;
		this.contactNo = contactNo;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isValid() {
		return isValid;
	}
	public String getGender() {
		return gender;
	}

	public String getProfession() {
		return profession;
	}

	public String getContactNo() {
		return contactNo;
	}
}
