import java.util.Random;

public class Contact {
	private final String uniqueID;
	private String firstName, lastName, phoneNumber, address;
	
	Contact(String uniqueIDIn){
		uniqueIDIn = verifyUniqueID(uniqueIDIn);
		this.uniqueID = (uniqueIDIn);
		this.firstName = "noFirstName";
		this.lastName = "noLastName";
		this.phoneNumber = "000-000-0000";
		this.address = "noAddress";
	}
	
	Contact(String uniqueIDIn, String firstNameIn, String lastNameIn, String phoneNumberIn, String addressIn){
		
		// Validation of id else create random ID for user. with 10 digits
		this.uniqueID = (verifyUniqueID(uniqueIDIn));
		// Validation of firstName
		if (verifyNameIn(firstNameIn)) {
			this.firstName = firstNameIn;
		}
		//Validation of lastName
		if(verifyNameIn(lastNameIn)) {
			this.lastName = lastNameIn;
		}
		// Validation of phoneNumber
		if (verifyPhoneIn(phoneNumberIn)) {
			this.phoneNumber = phoneNumberIn;
		}
		// Validation of address
		if(verifyAddressIn(addressIn)) {
			this.address = addressIn;
		}
	}
	
	String createUniqueID() {
		Random rand = new Random();
		rand.setSeed(rand.nextInt(0,1_000_000));
		long x = rand.nextInt()+1_000_000_000;
		return String.valueOf(x);
	}
	String verifyUniqueID(String uniqueIDIn) {
		if(uniqueIDIn == null) {
			return createUniqueID();
		}else if(uniqueIDIn.length() > 10) {
			return createUniqueID();
		}else {
			return uniqueIDIn;
		}
	}
	boolean verifyNameIn(String nameIn) {
		if(nameIn == null) {
			throw new java.lang.NullPointerException("NameIn is null");
		}else if((nameIn.length()> 10)) {
			throw new java.lang.IllegalArgumentException("name longer than 10");
		}else {
			return true;
		}
	}
	boolean verifyPhoneIn(String phoneNumberIn) {
		
		if(phoneNumberIn == null) {
			throw new java.lang.NullPointerException("phoneNumberIn is null");
			
		}else if(phoneNumberIn.length() != 10) {
			
			throw new java.lang.IllegalArgumentException("Number not 10 digits.");
			
		}else {
			for(int n = 0; n < phoneNumberIn.length(); n++) {
				if(Character.isAlphabetic(phoneNumberIn.charAt(n))) {
					throw new java.lang.IllegalArgumentException("Number cannot contain letters!");
				}
			}
			return true;
		}
	}
	boolean verifyAddressIn(String addressIn) {
		if(addressIn == null){
			throw new java.lang.NullPointerException("AddressIn is Null");
		}else if(addressIn.length() > 30 ) {
			throw new java.lang.IllegalArgumentException("Address cannot be longer than 30.");
		}else {
			return true;
		}
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		verifyNameIn(lastName);
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		verifyNameIn(firstName);
		this.firstName = firstName;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		verifyPhoneIn(phoneNumber);
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		verifyAddressIn(address);
		this.address = address;
	}
	
	
	
}

