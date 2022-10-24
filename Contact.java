public class Contact {
    // Global variables
    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String contactAddress;

    // Constructor with required fields
    public Contact(String id, String first, String last, String number, String address) {
        setContactID(id);
        setFirstName(first);
        setLastName(last);
        setPhoneNumber(number);
        setContactAddress(address);
    }
    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    // Setters
    private void setContactID(String id) {
        checkNameField(id);
        contactID = id;
    }

    public void setFirstName(String first) {
        checkNameField(first);
        firstName = first;
    }

    public void setLastName(String last) {
        checkNameField(last);
        lastName = last;
    }

    public void setPhoneNumber(String number) {
        if (number == null || number.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number: " + number);
        }
        phoneNumber = number;
    }

    public void setContactAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address: " + address);
        }
        contactAddress = address;
    }

    // Function to check field argument requirements
    public void checkNameField(String fieldName) {

        if(fieldName == null) {
            throw new IllegalArgumentException("Invalid: " + fieldName + " is null");
        }

        if(fieldName.length() > 10) {
            throw new IllegalArgumentException("Invalid: " + fieldName + "  greater than 10 characters");
        }
    }

}