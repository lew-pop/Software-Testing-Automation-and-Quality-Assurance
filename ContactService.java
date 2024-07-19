import java.util.HashMap;
import java.util.function.BiFunction;

public class ContactService {
    // Data structure to store contacts
    HashMap<String, Contact> contactList;
    
    // Initialize Contact Service with empty contact list.
    public ContactService() {
        contactList = new HashMap<String, Contact>();
    }

    // Function to get an instance of the contact service.
     public HashMap<String, Contact> getContactService() {
        return contactList;

    }
    // Contact service to retrieve a contact from the contact list.
    public Contact getContact(String contactId) {
        if(contactList.containsKey(contactId)){
            return contactList.get(contactId);
        }
        else{
            throw new NullPointerException("Contact ID does not exist");
        }
    }
     // Contact service to add a contact to the contact list.
    public void addContact(String contactId, Contact contact) {
        if(contactList.containsKey(contactId)){
            throw new IllegalArgumentException("Contact ID already exists");
        }
        else{
            contactList.put(contactId, contact);
        }
    }
     // Contact service to remove a contact from the contact list.
    public void removeContact(String contactId) {
        if(contactList.containsKey(contactId)){
            contactList.remove(contactId);
        }
        else{
            throw new IllegalArgumentException("Contact ID does not exist");
        }
    }
     // Contact service to modify a contact's first name.
    public void updateFirstName(String contactId, String newFirstName) {
        Contact tempContact = contactList.get(contactId);
        tempContact.setFirstName(newFirstName);
        contactList.remove(contactId);
        contactList.put(contactId, tempContact);

    }
     // Contact service to modify a contact's last name.
    public void updateLastName(String contactId, String newLastName) {

        Contact tempContact = contactList.get(contactId);
        tempContact.setLastName(newLastName);
        contactList.remove(contactId);
        contactList.put(contactId, tempContact);

    }
     // Contact service to modify a contact's phone number.
    public void updatePhoneNumber(String contactId, String phoneNumber) {
        Contact tempContact = contactList.get(contactId);
        tempContact.setPhoneNumber(phoneNumber);
        contactList.remove(contactId);
        contactList.put(contactId, tempContact);

    }
     // Contact service to modify a contact's address.
    public void updateAddress(String contactId, String newAddress) {
        Contact tempContact = contactList.get(contactId);
        tempContact.setContactAddress(newAddress);
        contactList.remove(contactId);
        contactList.put(contactId, tempContact);
    }

}
