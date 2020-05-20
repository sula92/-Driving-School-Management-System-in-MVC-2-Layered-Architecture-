package dto;

public class EmployeeDTO {

    String employeeId;
    String nic;
    String pos;
    String monthly_sal;
    String branch;
    String dorec;
    String grade;

    String typeId;
    String nm;
    String dob;
    String age;
    String gender;

    String address;
    String mobile;
    String phone;
    String email;

    public EmployeeDTO(String employeeId, String nic, String pos, String monthly_sal, String branch, String dorec, String grade, String typeId, String nm, String dob, String age, String gender, String address, String mobile, String phone, String email) {
        this.employeeId = employeeId;
        this.nic = nic;
        this.pos = pos;
        this.monthly_sal = monthly_sal;
        this.branch = branch;
        this.dorec = dorec;
        this.grade = grade;
        this.typeId = typeId;
        this.nm = nm;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.mobile = mobile;
        this.phone = phone;
        this.email = email;
    }

    public EmployeeDTO() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getMonthly_sal() {
        return monthly_sal;
    }

    public void setMonthly_sal(String monthly_sal) {
        this.monthly_sal = monthly_sal;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDorec() {
        return dorec;
    }

    public void setDorec(String dorec) {
        this.dorec = dorec;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeId='" + employeeId + '\'' +
                ", nic='" + nic + '\'' +
                ", pos='" + pos + '\'' +
                ", monthly_sal='" + monthly_sal + '\'' +
                ", branch='" + branch + '\'' +
                ", dorec='" + dorec + '\'' +
                ", grade='" + grade + '\'' +
                ", typeId='" + typeId + '\'' +
                ", nm='" + nm + '\'' +
                ", dob='" + dob + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
