package Parking_System.Model;

public class UserData {

	public String userName="";
	public String password="";
	public String fname="";
	public String lname="";
	public String parkingType="";
	public String driverLicense="";
	public String role="";
	public int UTAID;
	public String phone="";
	public String email="";
	public String address="";
	public String city="";
	public String state="";
	public int zipCode;
	public int noShows;
	public int overdue;
	String emptyString="";
	
	public String getUserName() {
		return userName;
	}
	
	public String getEmptyString()
	{
		return emptyString;
	}
	
	public void setEmptyString(String emptyString)
	{
		this.emptyString=emptyString;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getParkingType() {
		return parkingType;
	}

	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUTAID() {
		return UTAID;
	}

	public void setUTAID(int utaID) {
		UTAID = utaID;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getNoShows() {
		return noShows;
	}

	public void setNoShows(int noShows) {
		this.noShows = noShows;
	}

	public int getOverdue() {
		return overdue;
	}

	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}

}
