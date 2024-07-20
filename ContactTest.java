// import JUnit dependencies
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {
    
    // Initialize test contact
    protected Contact testContact;
    // Initialize static components for testing
    protected static String id, first, last, number, address;
    protected static String longId, longFirst, longLast, longNumber, longAddress;

    // Setup stage one of the test lifecycle
    // Configure static components before all tests.
    @BeforeAll
    protected static void setup() {
        // Initialize illegal test values
        longId = "01234567890";
        longFirst = "Mynameislong";
        longLast = "Lastnamelong";
        longNumber = "18587234956";
        longAddress = "2532 Mervin Rd. Fullerton, CA 92104";
    }

    // Test Contact object to ensure the actual address matches the expected address.
    // JUnit @test and @DisplayName annotations. 
    @Test
    @DisplayName("Test contact constructor with valid contactId, firstName, lastName, phoneNumber, contactAddress")
    void testContactClass() {
        
        // Initialize valid test contact
        testContact = new Contact("0000000001", "Discobeez", "Stafford", "8587234956", "2532 Mervin Rd. Fullerton, CA");
        // Group of assertions to verify contact constructor
        assertAll("Contact",
                () -> assertEquals("0000000001", testContact.getContactID()),
                () -> assertEquals("Discobeez", testContact.getFirstName()),
                () -> assertEquals("Stafford", testContact.getLastName()),
                () -> assertEquals("8587234956", testContact.getPhoneNumber()),
                () -> assertEquals("2532 Mervin Rd. Fullerton, CA", testContact.getContactAddress()));
    }

    // Test Contact when uniqueID is null
    @Test
    @DisplayName("Test contact ID with null value")
    void testNullContactId() {
        // Assertion to verify null value exception is thrown
        assertThrows(IllegalArgumentException.class, () -> testContact = new Contact(id, "Discobeez", "Stafford",
                "8587234956", "2532 Mervin Rd. Fullerton, CA"));

    }

    // Test Contact when uniqueID is more than 10 characters
    @Test
    @DisplayName("Test contact ID with more than 10 characters")
    void testLongContactId() {
        // Assertion to verify illegal value exception is thrown
        assertThrows(IllegalArgumentException.class, () -> testContact = new Contact(longId, "Discobeez", "Stafford",
                "8587234956", "2532 Mervin Rd. Fullerton, CA"));
    }

    // Test Contact when first name is null
    @Test
    @DisplayName("Test first name with null value")
    void testNullFirstName() {
        // Assertion to verify null value exception is thrown
        assertThrows(IllegalArgumentException.class, () -> testContact = new Contact("0000000001", first, "Stafford",
                "8587234956", "2532 Mervin Rd. Fullerton, CA"));
    }

    // Test Contact when uniqueID is more than 10 characters
    @Test
    @DisplayName("Test first name with more than 10 characters")
    void testLongFirstName() {
        // Assertion to verify illegal value exception is thrown
        assertThrows(IllegalArgumentException.class, () -> testContact = new Contact("0000000001", longFirst,
                "Stafford", "8587234956", "2532 Mervin Rd. Fullerton, CA"));
    }

    // Test Contact when last name is null
    @Test
    @DisplayName("Test last name with null value")
    void testNullLastName() {
        // Assertion to verify null value exception is thrown
        assertThrows(IllegalArgumentException.class, () -> testContact = new Contact("0000000001", "Discobeez", last,
                "8587234956", "2532 Mervin Rd. Fullerton, CA"));
    }

    // Test Contact when last name is more than 10 characters
    @Test
    @DisplayName("Test last name with more than 10 characters")
    void testLongLastName() {
        // Assertion to verify illegal value exception is thrown
        assertThrows(IllegalArgumentException.class, () -> testContact = new Contact("0000000001", "Discobeez",
                longLast, "8587234956", "2532 Mervin Rd. Fullerton, CA"));
    }

    // Test Contact when phone number is null
    @Test
    @DisplayName("Test phone number with null value")
    void testNullPhoneNumber() {
        // Assertion to verify null value exception is thrown
        assertThrows(IllegalArgumentException.class, () -> testContact = new Contact("0000000001", "Discobeez",
                "Stafford", number, "2532 Mervin Rd. Fullerton, CA"));
    }

    // Test Contact when phone number is more than 10 characters
    @Test
    @DisplayName("Test phone number with more than 10 characters")
    void testLongPhoneNumber() {
        // Assertion to verify illegal value exception is thrown
        assertThrows(IllegalArgumentException.class, () -> testContact = new Contact("0000000001", "Discobeez",
                "Stafford", longNumber, "2532 Mervin Rd. Fullerton, CA"));
    }

    // Test Contact when address is null
    @Test
    @DisplayName("Test address with null value")
    void testNullContactAddress() {
        // Assertion to verify null value exception is thrown
        assertThrows(IllegalArgumentException.class,
                () -> testContact = new Contact("0000000001", "Discobeez", "Stafford", "8587234956", address));
    }

    // Test Contact when address is more than 30 characters
    @Test
    @DisplayName("Test address with more than 30 characters")
    void testLongContactAddress() {
        // Assertion to verify illegal value exception is thrown
        assertThrows(IllegalArgumentException.class,
                () -> testContact = new Contact("0000000001", "Discobeez", "Stafford", "8587234956", longAddress));
    }
}
