import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	Contact c;
	@BeforeEach
	void setUp() throws Exception {
		c = new Contact("Johnny32", "James", "Gunn", "1234567890", "123 fake street");
	}
	
	@Test 
	void verifyObjectCreationFirstNameNullErrorThrown(){
		assertThrows(NullPointerException.class,
				() -> {
					c = new Contact("UniqueID1",null,"LastName","1234567890","123 fake street");
				});
	}
	@Test
	void testVerifyUniqueID() {
		assert(c.getUniqueID().equals("Johnny32"));
		
		c = new Contact("");
		for(char c: c.getUniqueID().toCharArray()) {
			assert(Character.isDigit(c));
		}
	}

	@Test
	void testVerifyNameIn() {
		// verify First name in was set and returned true.
		
		// verify Last name in is there and returned true.
		assert(c.verifyNameIn(c.getLastName()));
		assert(c.verifyNameIn(c.getLastName()));
	
		c.setFirstName("JohnA");
		assertEquals("JohnA", c.getFirstName());
		c.setLastName("AppleSeed");
		assertEquals("AppleSeed", c.getLastName());
		
		assertAll(
		() -> assertThrows(NullPointerException.class,
				() -> {
					c.setLastName(null);
				}),
		() -> assertThrows(IllegalArgumentException.class, 
				() -> {
					c.setLastName("VeryLongNameOverTenCharacters");
				}),
		() -> assertThrows(IllegalArgumentException.class, 
				() -> {
					c.setFirstName("VeryLongNameOverTenCharacters");
				})
		);
	}

	@Test
	void testVerifyPhoneIn() {
		
		assert(c.verifyPhoneIn(c.getPhoneNumber()));
		assertAll(
		() -> assertThrows(IllegalArgumentException.class, 
				() -> {
					c.setPhoneNumber("12345678900");
				}),
		() -> assertThrows(IllegalArgumentException.class,
				() ->{
					c.setPhoneNumber("TenLetters");
				}),
		() -> assertThrows(NullPointerException.class, 
				
				() -> {
					c.setPhoneNumber(null);
				})
		);
		c.setPhoneNumber("0987654321");
		assertEquals("0987654321", c.getPhoneNumber());
	}

	@Test
	void testVerifyAddressIn() {
		
		assert(c.verifyAddressIn(c.getAddress()));
		assertAll(
			() -> assertThrows(IllegalArgumentException.class, 
					() -> {
						//43 characters long
						c.setAddress("VeryLongNameAddressNameOverThirtyCharacters");
						}),
			() -> assertThrows(NullPointerException.class,
					() ->{
						c.setAddress(null);
					})
				);
		c.setAddress("456 main street");
		assertEquals("456 main street", c.getAddress());
	}
	@Test
	void verifyRandomIDIfNull() {
		
		String ID = c.getUniqueID();
		c = new Contact(null);
		assertNotEquals(c.getUniqueID(),ID);
		c = new Contact("SuperLongIDOver10Characters");
		assertNotEquals("SuperLongIDOver10Characters",c.getUniqueID());
	}

}
