import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	ContactService c;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		c = new ContactService();
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testAddContact() {
		
		//ContactService c = new ContactService();
		assert(c.getSize() == 0);
		
		c.addContact("John123", "John", "Hancock","1234567890", "123 fake street");
		
		assert(c.getSize() == 1);
		assertEquals("John",c.contacts.get(0).getFirstName());
		//System.out.println(c.contacts.get(0).getFirstName());
		c.addContact("Jakub54", "Jakub", "James", "8884581293", "123 main street");
		assertEquals("8884581293",c.contacts.get(1).getPhoneNumber());
		//System.out.println(c.contacts.get(1).getPhoneNumber());
		assert(c.getSize() == 2);
		
		c.addContact("John123", "jj", "hamilton", "1234567889", "456 fake street");
		assert(c.getSize() == 2);
		
	}

	@Test
	void testDeleteContact() {
		
		assert(c.getSize() == 0);
		c.addContact("John123", "John", "Hancock","1234567890", "123 fake street");
		c.addContact("Jakub54", "Jakub", "James", "8884581293", "123 main street");
		assert(c.getSize() == 2);
		c.deleteContact("John123");
		assert(c.getSize()== 1);
		assert(c.contacts.get(0).getUniqueID().equals("Jakub54"));
		
	}

	
	@Test void testUpdateFieldName() {
		c.addContact("John123", "John", "Hancock","1234567890", "123 fake street");
		c.updateField("John123","firstname","Jables");
		assertEquals("Jables",c.contacts.get(0).getFirstName());

		c.addContact("Eliza43", "Elizabeth", "Blackwell", "5053208322", "3423 London Street");
		c.updateField("Eliza43", "phoneNumber", "3034563201");
		assertNotEquals("5053208322",c.contacts.get(1).getPhoneNumber());
		
	  
	 }
	 

}
