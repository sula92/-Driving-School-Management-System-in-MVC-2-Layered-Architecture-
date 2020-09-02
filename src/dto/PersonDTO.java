package dto;

import entity.Person_Contact;

public class PersonDTO {

    private String NIC;
    private String Name;
    private String DOB;
    private String Age;
    private String Gender;
    private Person_Contact person_contact;

    public PersonDTO() {
    }

    public PersonDTO(String NIC, String name, String DOB, String age, String gender, Person_Contact person_contact) {
        this.NIC = NIC;
        Name = name;
        this.DOB = DOB;
        Age = age;
        Gender = gender;
        this.person_contact = person_contact;
    }

    public PersonDTO(String NIC, String name, String DOB, String age, String gender, String address, String mob, String phone, String email) {
        this.NIC = NIC;
        Name = name;
        this.DOB = DOB;
        Age = age;
        Gender = gender;
        this.person_contact = new Person_Contact(NIC,address,mob,phone,email);
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Person_Contact getPerson_contact() {
        return person_contact;
    }

    public void setPerson_contact(Person_Contact person_contact) {
        this.person_contact = person_contact;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "NIC='" + NIC + '\'' +
                ", Name='" + Name + '\'' +
                ", DOB='" + DOB + '\'' +
                ", Age='" + Age + '\'' +
                ", Gender='" + Gender + '\'' +
                ", person_contact=" + person_contact +
                '}';
    }
}
