package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<ContactClass> contacts;

    public ContactService() {
        contacts = new ArrayList<>();
    }

    public void addContact(ContactClass contact) {
        String contactId = contact.getContactID();
        for (ContactClass existingContact : contacts) {
            if (existingContact.getContactID().equals(contactId)) {
                throw new IllegalArgumentException("Contact with ID " + contactId + " already exists.");
            }
        }
        contacts.add(contact);
    }

    public void deleteContact(String contactId) {
        ContactClass contactToRemove = null;
        for (ContactClass contact : contacts) {
            if (contact.getContactID().equals(contactId)) {
                contactToRemove = contact;
                break;
            }
        }
        if (contactToRemove != null) {
            contacts.remove(contactToRemove);
        }
    }

    public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        ContactClass contact = getContact(contactId);
        
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phoneNumber != null) {
            contact.setPhoneNumber(phoneNumber);
        }
        if (address != null) {
            contact.setAddress(address);
           
            }
        }
    

    public ContactClass getContact(String contactId) {
        for (ContactClass contact : contacts) {
            if (contact.getContactID().equals(contactId)) {
                return contact;
            }
        }
        throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist.");
    }
}