import java.util.ArrayList;

public class ContactService {
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	ContactService(){
		
	}
	
	
	int getSize() {
		return this.contacts.size();
	}

	void addContact(String uniqueID, String firstName, String lastName, String phoneNumber, String address){
		if(uniqueID == null || firstName == null || lastName == null || phoneNumber == null || address == null) throw new java.lang.NullPointerException("a parameter is null.");
		else{
			
			Contact newContact = new Contact(uniqueID);
			boolean alreadyAdded = false;
			
			//System.out.println("Ran 1");
			if (contacts.size() > 0){
				for(Contact c: contacts) {
					if (c.getUniqueID().equals(uniqueID)) {
						alreadyAdded = true;
					}
				}
			}
			
			//System.out.println("Ran 2");
			if(!alreadyAdded) {
				newContact.setFirstName(firstName);
				newContact.setLastName(lastName);
				newContact.setPhoneNumber(phoneNumber);
				newContact.setAddress(address);
				contacts.add(newContact);
			}else {
				System.out.println("ID already in contacts");
			}
		}
	}
	
	void deleteContact(String uniqueID) {
		if (contacts.size() > 0) {
			int sizeOfContacts = (int)contacts.size();
			for(Contact c: contacts) {
				if(c.getUniqueID().equals(uniqueID)) {
					contacts.remove(c);
					break;
				}
			}
			if (sizeOfContacts == contacts.size()) System.out.println("Deleted contact");
			else System.out.println("Contact of id " + uniqueID + " not found.");
		}
	}
	
	void updateField(String uniqueID, String option,String update) {
		if (contacts.size() <= 0) throw new java.lang.ArrayIndexOutOfBoundsException("No contacts exist in contact service");
		else {
			for(Contact c: contacts) {
				if (c.getUniqueID().equals(uniqueID)){
					option = option.toLowerCase();
					System.out.println(option);
					switch(option) {
					case "firstname","first_name","first name":
						c.setFirstName(update);
						break;
					case "lastname","last_name","last name":
						c.setLastName(update);
						break;
					case "address":
						c.setAddress(update);
						break;
					case "phone_number","phone number","phonenumber":
						c.setPhoneNumber(update);
						break;
					default:
						System.out.println("No field " + option);
					}
					break;
				}
			}
		}
	}
	
}
