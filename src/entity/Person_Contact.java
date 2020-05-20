package entity;

public class Person_Contact implements SuperEntity {

    private String NIC;
    private String Type_ID;
    private String Address;
    private String Mobile;
    private String Phone;
    private String Email;

    public Person_Contact(String NIC, String type_ID, String address, String mobile, String phone, String email) {
        this.NIC = NIC;
        Type_ID = type_ID;
        Address = address;
        Mobile = mobile;
        Phone = phone;
        Email = email;
    }

    public Person_Contact() {
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getType_ID() {
        return Type_ID;
    }

    public void setType_ID(String type_ID) {
        Type_ID = type_ID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Person_Contact{" +
                "NIC='" + NIC + '\'' +
                ", Type_ID='" + Type_ID + '\'' +
                ", Address='" + Address + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
