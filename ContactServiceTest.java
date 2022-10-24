import org.junit.jupiter.api.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    static Contact testContact;
    static String testName;
    static String uniqueID;

    @BeforeAll
    static void setup(){
        testName = "";
        uniqueID = "";
    }
    @Test
    @DisplayName("Test contact service, constructor")
    void contactServiceClassTest() {
        // Create expected contact service value
        ContactService actual = new ContactService();
        HashMap<String, Contact> expected = new HashMap<String, Contact>();
        assertEquals(expected, actual.getContactService());
    }

    @Test
    @DisplayName("Test contact service, add contact with a unique ID")
    void addContactTest() {
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        // Initialize testContact with a unique contactID
        testContact = new Contact("0000000005", "Randal", "Smith", "8089478624", "9547 Melrose St. Derby, MI");
        // Add testContact to testContactService
        testContactService.addContact(testContact.getContactID(), testContact);
        // Assertion to compare testContact to contact stored in testContactService with
        // unique contactID
        assertEquals(testContact, testContactService.getContact("0000000005"));
    }
    @Test
    @DisplayName("Test contact service, add contact with a duplicate ID")
    void addDuplicateContactIdTest(){
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        // Create variable to hold and compare contact first
        uniqueID = "0000000001";
        testContact = new Contact(uniqueID, "Bob", "Jangles", "9815457662", "1312 Olympic Ct. Tennesse, MA");
        assertThrows(IllegalArgumentException.class, () -> testContactService.addContact(uniqueID, testContact));
    }
    @Test
    @DisplayName("Test contact service, delete contact with a unique ID")
    void removeContactTest() {
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        testContact = testContactService.getContact("0000000001");
        uniqueID = testContact.getContactID();
        testContactService.removeContact(uniqueID);
        assertThrows(NullPointerException.class, () -> testContactService.getContact(uniqueID));
    }
    @Test
    @DisplayName("Test contact service, delete contact with an invalid ID")
    void removeInvalidContactIdTest(){
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        uniqueID = "0000000008";
        assertThrows(IllegalArgumentException.class, () -> testContactService.removeContact(uniqueID));
    }
    @Test
    @DisplayName("Test contact service, update first name with a unique ID")
    void updateFirstNameTest() {
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        uniqueID = "0000000002";
        testName = "Oxnard";
        testContactService.updateFirstName(uniqueID, testName);
        testContact = testContactService.getContact(uniqueID);
        assertEquals(testName, testContact.getFirstName());
    }
    @Test
    @DisplayName("Test contact service, update first name with an invalid first name")
    void updateInvalidFirstNameTest() {
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        uniqueID = "0000000002";
        assertThrows(IllegalArgumentException.class, () -> testContactService.updateFirstName(uniqueID, "DeBoxoxnards"));
    }
    @Test
    @DisplayName("Test contact service, update last name with a unique ID")
    void updateLastNameTest() {
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        uniqueID = "0000000002";
        testName = "Boxnard";
        testContactService.updateLastName(uniqueID, "Boxnard");
        testContact = testContactService.getContact(uniqueID);
        assertEquals(testName, testContact.getLastName());
    }
    @Test
    @DisplayName("Test contact service, update last name with an invalid last name")
    void updateInvalidLastName() {
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        uniqueID = "0000000002";
        assertThrows(IllegalArgumentException.class, () -> testContactService.updateLastName(uniqueID, "DeBoulevard"));
    }
    @Test
    @DisplayName("Test contact service, update phone number with a unique ID")
    void updatePhoneNumberTest() {
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        uniqueID = "0000000002";
        testName = "5654201990";
        testContactService.updatePhoneNumber(uniqueID, testName);
        testContact = testContactService.getContact(uniqueID);
        assertEquals(testName, testContact.getPhoneNumber());
    }
    @Test
    @DisplayName("Test contact service, update phone number with an invalid phone number")
    void updateInvalidPhoneNumber() {
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        uniqueID = "0000000002";
        assertThrows(IllegalArgumentException.class, () -> testContactService.updatePhoneNumber(uniqueID, "15654201990"));
    }
    @Test
    @DisplayName("Test contact service, update address with a unique ID")
    void updateAddressTest() {
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        uniqueID = "0000000002";
        testName = "565 Unique Rd. Chussettes, VA";
        testContactService.updateAddress(uniqueID, testName);
        testContact = testContactService.getContact(uniqueID);
        assertEquals(testName, testContact.getContactAddress());
    }
    @Test
    @DisplayName("Test contact service, update address with an invalid address")
    void updateInvalidAddress() {
        final ContactService testContactService = new ContactService();
        generateTestService(testContactService);
        uniqueID = "0000000002";
        assertThrows(IllegalArgumentException.class, () -> testContactService.updateAddress(uniqueID, "7777 Boxnard Way Court, Las Vegas, NV 92212"));
    }
    // Function to populate test contact service
    public static void generateTestService(ContactService tempService){

        Contact contactOne = new Contact("0000000001", "Bescobeeys", "Maltdarts", "8587858956",
                "1532 Derby Way. Compton, CA");
        Contact contactTwo = new Contact("0000000002", "Discobeez", "Stafford", "8587234956",
                "2532 Mervin Rd. Fullerton, PT");
        Contact contactThree = new Contact("0000000003", "Biscobooz", "Cliffborg", "9198723496",
                "8546 Delaware Ct. Maxwell, FL");
        Contact contactFour = new Contact("0000000004", "ziverado", "washington", "4152057741",
                "8546 Delaware Ct. Maxwell, FL");

        tempService.addContact("0000000001", contactOne);
        tempService.addContact("0000000002", contactTwo);
        tempService.addContact("0000000003", contactThree);
        tempService.addContact("0000000004", contactFour);



    }

}