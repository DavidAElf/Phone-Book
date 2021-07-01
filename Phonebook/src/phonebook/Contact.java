package phonebook;

public class Contact {

	private String userFirstName;
	private String userMiddleName;
	private String userLastName;
	private String streetName;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String userFullName;

	public Contact(String userFirstName, String userMiddleName, String userLastName, String streetName, String city,
			String state, String zipCode, String phoneNumber) {
		super();
		this.userFirstName = userFirstName;
		this.userMiddleName = userMiddleName;
		this.userLastName = userLastName;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.userFullName = userLastName + ", " + userFirstName + " " + userMiddleName.charAt(0);
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public String getUserMiddleName() {
		return userMiddleName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	@Override
	public String toString() {
		return userFirstName + ", " + userMiddleName + ", " + userLastName + ", " + streetName + ", " + city + ", "
				+ state + ", " + zipCode + ", " + phoneNumber;
	}

}
