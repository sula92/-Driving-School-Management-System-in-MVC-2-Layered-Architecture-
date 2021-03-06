package dto;

public class PersonContactDTO {

    private String NIC;
    private String Address;
    private String Mobile;
    private String Phone;
    private String Email;

    public PersonContactDTO() {
    }

    public PersonContactDTO(String NIC, String address, String mobile, String phone, String email) {
        this.NIC = NIC;
        Address = address;
        Mobile = mobile;
        Phone = phone;
        Email = email;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
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
        return "PersonContactDTO{" +
                "NIC='" + NIC + '\'' +
                ", Address='" + Address + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
