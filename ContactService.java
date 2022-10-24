import java.util.HashMap;
import java.util.function.BiFunction;

public class ContactService {

    HashMap<String, Contact> contactList;

    public ContactService() {
        contactList = new HashMap<String, Contact>();
    }

     public HashMap<String, Contact> getContactService() {
        return contactList;

    }

    public Contact getContact(String contactId) {
        if(contactList.containsKey(contactId)){
            return contactList.get(contactId);
        }
        else{
            throw new NullPointerException("Contact ID does not exist");
        }
    }

    public void addContact(String contactId, Contact contact) {
        if(contactList.containsKey(contactId)){
            throw new IllegalArgumentException("Contact ID already exists");
        }
        else{
            contactList.put(contactId, contact);
        }
    }

    public void removeContact(String contactId) {
        if(contactList.containsKey(contactId)){
            contactList.remove(contactId);
        }
        else{
            throw new IllegalArgumentException("Contact ID does not exist");
        }
    }

    public void updateFirstName(String contactId, String newFirstName) {
        Contact tempContact = contactList.get(contactId);
        tempContact.setFirstName(newFirstName);
        contactList.remove(contactId);
        contactList.put(contactId, tempContact);

    }

    public void updateLastName(String contactId, String newLastName) {

        Contact tempContact = contactList.get(contactId);
        tempContact.setLastName(newLastName);
        contactList.remove(contactId);
        contactList.put(contactId, tempContact);

    }

    public void updatePhoneNumber(String contactId, String phoneNumber) {
        Contact tempContact = contactList.get(contactId);
        tempContact.setPhoneNumber(phoneNumber);
        contactList.remove(contactId);
        contactList.put(contactId, tempContact);

    }

    public void updateAddress(String contactId, String newAddress) {
        Contact tempContact = contactList.get(contactId);
        tempContact.setContactAddress(newAddress);
        contactList.remove(contactId);
        contactList.put(contactId, tempContact);
    }

}