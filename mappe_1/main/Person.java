package edu.ntnu.idatt2001.trygveam.mappe_1.hospital;


/**
 * The type Person.
 * @author trygveam
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;


    /**
     * Instantiates a new Person.
     *
     * @param firstName            the first name
     * @param lastName             the last name
     * @param socialSecurityNumber the social security number
     */
    public Person(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }


    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Get fullname string.
     *
     * @return the string
     */
    public String getFullname(){
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                '}';
    }

}
