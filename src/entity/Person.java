package entity;

public class Person implements SuperEntity {

    private String NIC;
    private  String Type_ID;
    private String Name;
    private String DOB;
    private String Age;
    private String Gender;

    public Person(String NIC, String type_ID, String name, String DOB, String age, String gender) {
        this.NIC = NIC;
        Type_ID = type_ID;
        Name = name;
        this.DOB = DOB;
        Age = age;
        Gender = gender;
    }

    public Person() {
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

    @Override
    public String toString() {
        return "Person{" +
                "NIC='" + NIC + '\'' +
                ", Type_ID='" + Type_ID + '\'' +
                ", Name='" + Name + '\'' +
                ", DOB='" + DOB + '\'' +
                ", Age='" + Age + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
