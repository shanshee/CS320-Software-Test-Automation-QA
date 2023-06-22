package contact;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class contactClassTest {

@Test
public void testSetFirstName() {
	ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
	contact.setFirstName("Londelle");
	Assertions.assertEquals("Londelle", contact.getFirstName());
	}

@Test
public void testSetInvalidFirstName() {
	ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
	Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("LondelleLondelleLondelle"));
	Assertions.assertEquals("Londelle", contact.getFirstName()); // Make sure the value is not changed
	}

@Test
public void testSetLastName() {
	ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
	contact.setLastName("Sheehan");
	Assertions.assertEquals("Sheehan", contact.getLastName());
	}

@Test
public void testSetInvalidLastName() {
	ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
	Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setLastName("SheehanSheehanSheehan"));
	Assertions.assertEquals("Sheehan", contact.getLastName()); // Make sure the value is not changed
	}

@Test
public void testSetPhoneNumber() {
	ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
	contact.setPhoneNumber("1234567890");
	Assertions.assertEquals("1234567890", contact.getPhoneNumber());
	}

@Test
public void testSetInvalidPhoneNumber() {
	ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
	Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("123456789012345"));
	Assertions.assertEquals("1234567890", contact.getPhoneNumber()); // Make sure the value is not changed
	}

@Test
public void testSetAddress() {
	ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
	contact.setAddress("San Diego, CA");
	Assertions.assertEquals("San Diego, CA", contact.getAddress());
	}

@Test
public void testSetInvalidAddress() {
	ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
	Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setAddress("San Diego, CA San Diego, CA San Diego, CA San Diego, CA San Diego, CA San Diego, CA"));
	Assertions.assertEquals("San Diego, CA", contact.getAddress()); // Make sure the value is not changed
	}
}


