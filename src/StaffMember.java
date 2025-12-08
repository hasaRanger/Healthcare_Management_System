import java.time.LocalDate;

public abstract class StaffMember {
    protected String name;
    protected String surname;
    protected LocalDate dob;
    protected String phoneNo;
    protected String staffID;

    public StaffMember(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return "StaffMember{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", phoneNo='" + phoneNo + '\'' +
                ", staffID='" + staffID + '\'' +
                '}';
    }
}


