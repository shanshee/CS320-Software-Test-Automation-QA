package contact;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactServiceTest {
    private ContactService contactService;

    @Before
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void addContactTest() {
        ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDuplicateContactTest() {
        ContactClass contact1 = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
        ContactClass contact2 = new ContactClass("1", "Shan", "Sheehan", "1234567890", "San Diego, CA");

        contactService.addContact(contact1);
        contactService.addContact(contact2);
    }

    @Test
    public void deleteContactTest() {
        ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
        contactService.addContact(contact);

        contactService.deleteContact("1");

        try {
            contactService.getContact("1");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Contact with ID 1 does not exist.", e.getMessage());
        }
    }

    @Test
    public void updateContactTest() {
        ContactClass contact = new ContactClass("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
        contactService.addContact(contact);

        contactService.updateContact("1", "Shan", "Sheehan", "1234567890", "San Diego, CA");

        ContactClass updatedContact = contactService.getContact("1");
        assertEquals("Shan", updatedContact.getFirstName());
        assertEquals("Sheehan", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhoneNumber());
        assertEquals("San Diego, CA", updatedContact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateNonexistentContactTest() {
        contactService.updateContact("1", "Londelle", "Sheehan", "1234567890", "San Diego, CA");
    }
}
