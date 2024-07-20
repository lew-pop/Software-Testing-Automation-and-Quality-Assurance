// Import Java utility and Junit dependencies
import org.junit.jupiter.api.*;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    
    // Initialize static components for testing
    static Contact testContact;
    static String testName;
    static String uniqueID;
    
    // Configure static components before all tests. 
    // JUnit @BeforeAll annotation ensures the setup is handled before all tests.
    @BeforeAll
    static void setup(){
        testName = "";
        uniqueID = "";
    }
    
    // Test ContactService class to ensure the actual address matches the expected address.
    // JUnit @test and @DisplayName annotations.  
    @Test
    @DisplayName("Test contact service, constructor")
    void contactServiceClassTest() {
        
        // The actual value of the contact service address.
        ContactService actual = new ContactService();        
        // The expected value of the contact service address.
        HashMap<String, Contact> expected = new HashMap<String, Contact>();         
        // Compare the actual value to the expected value. 
        assertEquals(expected, actual.getContactService());
    }
    
    // Test to ensure the Contact Service correctly adds a contact to the contact list.
    @Test
    @DisplayName("Test contact service, add contact with a unique ID")
    void addContactTest() {

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Initialize testContact with a unique contactID
        testContact = new Contact("0000000005", "Randal", "Smith", "8089478624", "9547 Melrose St. Derby, MI");
        // Add testContact to testContactService
        testContactService.addContact(testContact.getContactID(), testContact);
        // Compare testContact address value to the expected contact address value stored in testContactService.
        assertEquals(testContact, testContactService.getContact("0000000005"));
    }
    
     // Test to ensure the Contact Service handles duplicate contact entries correctly.
    @Test
    @DisplayName("Test contact service, add contact with a duplicate ID")
    void addDuplicateContactIdTest(){
        
         // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // The test contact service created a contact with the uniqueID of 0000000001. (see lines 171-186)
        // uniqueID value to try and add to the contact list
        uniqueID = "0000000001";
        // New contact object with the uniqueID
        testContact = new Contact(uniqueID, "Bob", "Jangles", "9815457662", "1312 Olympic Ct. Tennesse, MA");
        // Try to add the new contact with uniqueID to the contact list. Throws an exception if uniqueID exists in the contact list.
        assertThrows(IllegalArgumentException.class, () -> testContactService.addContact(uniqueID, testContact));
    }
    
     // Test to ensure the Contact Service correctly removes contact entries.
    @Test
    @DisplayName("Test contact service, delete contact with a unique ID")
    void removeContactTest() {

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Set the contact to test.
        testContact = testContactService.getContact("0000000001");
        // Get the uniqueID of the test contact.
        uniqueID = testContact.getContactID();
        // Remove test contact from contact list.
        testContactService.removeContact(uniqueID);
        // Try to retrieve the contact from the contact list. Throws an exception if the contact does not exist.
        assertThrows(NullPointerException.class, () -> testContactService.getContact(uniqueID));
    }
    
     // Test to ensure the Contact Service removes contacts with invalid IDs.
    @Test
    @DisplayName("Test contact service, delete contact with an invalid ID")
    void removeInvalidContactIdTest(){

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Create a uniqueID to test.
        uniqueID = "0000000008";
        // Try to retrieve the contact from the contact list. Throws an exception if the contact does not exist.
        assertThrows(IllegalArgumentException.class, () -> testContactService.removeContact(uniqueID));
    }
    
    // Test to ensure the Contact Service correctly updates the contact's first name.
    @Test
    @DisplayName("Test contact service, update first name with a unique ID")
    void updateFirstNameTest() {

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Create a uniqueID to test.
        uniqueID = "0000000002";
        // Create a testName to test.
        testName = "Oxnard";
        // Use uniqueID to update the contact's first name in the test contact service.
        testContactService.updateFirstName(uniqueID, testName);
        // Get the contact with uniqueID
        testContact = testContactService.getContact(uniqueID);
        // Check the actual first name matches the expected first name (testName).
        assertEquals(testName, testContact.getFirstName());
    }
    
    // Test to ensure the Contact Service manages invalid first name input.
    @Test
    @DisplayName("Test contact service, update first name with an invalid first name")
    void updateInvalidFirstNameTest() {

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Create a uniqueID to test.
        uniqueID = "0000000002";
        // Try to update the contact's first name with an invalid first name.
        assertThrows(IllegalArgumentException.class, () -> testContactService.updateFirstName(uniqueID, "DeBoxoxnards"));
    }
    
    // Test to ensure the Contact Service correctly updates the contact's last name.
    @Test
    @DisplayName("Test contact service, update last name with a unique ID")
    void updateLastNameTest() {

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Create a uniqueID to test.
        uniqueID = "0000000002";
        // Create a testName to test.
        testName = "Boxnard";
        // Use uniqueID to update the contact's last name in the test contact service.
        testContactService.updateLastName(uniqueID, "Boxnard");
        // Get the contact with uniqueID
        testContact = testContactService.getContact(uniqueID);
        // Check the actual last name matches the expected last name (testName).
        assertEquals(testName, testContact.getLastName());
    }
    // Test to ensure the Contact Service manages invalid last name input.
    @Test
    @DisplayName("Test contact service, update last name with an invalid last name")
    void updateInvalidLastName() {

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Create a uniqueID to test.
        uniqueID = "0000000002";
        // Try to update the contact's last name with an invalid last name.
        assertThrows(IllegalArgumentException.class, () -> testContactService.updateLastName(uniqueID, "DeBoulevard"));
    }
    
    // Test to ensure the Contact Service correctly updates the contact's phone number.
    @Test
    @DisplayName("Test contact service, update phone number with a unique ID")
    void updatePhoneNumberTest() {

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Create a uniqueID to test.
        uniqueID = "0000000002";
        // Create a testPhoneNumber to test.
        testName = "5654201990";
        // Use uniqueID to update the contact's phone number in the test contact service.
        testContactService.updatePhoneNumber(uniqueID, testName);
        // Get the contact with uniqueID
        testContact = testContactService.getContact(uniqueID);
        // Check the actual phone number matches the expected phone number (testName).
        assertEquals(testName, testContact.getPhoneNumber());
    }
    
    // Test to ensure the Contact Service manages invalid phone number input.
    @Test
    @DisplayName("Test contact service, update phone number with an invalid phone number")
    void updateInvalidPhoneNumber() {

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Create a uniqueID to test.
        uniqueID = "0000000002";
        // Try to update the contact's phone number with an invalid phone number.
        assertThrows(IllegalArgumentException.class, () -> testContactService.updatePhoneNumber(uniqueID, "15654201990"));
    }
    
    // Test to ensure the Contact Service correctly updates the contact's address.
    @Test
    @DisplayName("Test contact service, update address with a unique ID")
    void updateAddressTest() {

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Create a uniqueID to test.
        uniqueID = "0000000002";
        // Create a testAddress to test.
        testName = "565 Unique Rd. Chussettes, VA";
        // Use uniqueID to update the contact's address in the test contact service.
        testContactService.updateAddress(uniqueID, testName);
        // Get the contact with uniqueID
        testContact = testContactService.getContact(uniqueID);
        // Check the actual address matches the expected address (testName).
        assertEquals(testName, testContact.getContactAddress());
    }
    // Test to ensure the Contact Service manages invalid address input.
    @Test
    @DisplayName("Test contact service, update address with an invalid address")
    void updateInvalidAddress() {

        // Create a new Contact Service to test.
        final ContactService testContactService = new ContactService();
        // Generates a test Contact Service with four contacts. (see lines 171-186)
        generateTestService(testContactService);
        // Create a uniqueID to test.
        uniqueID = "0000000002";
        // Try to update the contact's address with an invalid address.
        assertThrows(IllegalArgumentException.class, () -> testContactService.updateAddress(uniqueID, "7777 Boxnard Way Court, Las Vegas, NV 92212"));
    }
    // Function to initialize and populate test contact service.
    public static void generateTestService(ContactService tempService){
        
        // Create contact One
        Contact contactOne = new Contact("0000000001", "Bescobeeys", "Maltdarts", "8587858956",
                "1532 Derby Way. Compton, CA");
        // Create contact Two
        Contact contactTwo = new Contact("0000000002", "Discobeez", "Stafford", "8587234956",
                "2532 Mervin Rd. Fullerton, PT");
        // Create contact Three
        Contact contactThree = new Contact("0000000003", "Biscobooz", "Cliffborg", "9198723496",
                "8546 Delaware Ct. Maxwell, FL");
        // Create contact Four
        Contact contactFour = new Contact("0000000004", "ziverado", "washington", "4152057741",
                "8546 Delaware Ct. Maxwell, FL");
        
        // Add contacts to the contact service.
        tempService.addContact("0000000001", contactOne);
        tempService.addContact("0000000002", contactTwo);
        tempService.addContact("0000000003", contactThree);
        tempService.addContact("0000000004", contactFour);
    }

}
