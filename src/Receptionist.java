import java.time.LocalDate;

public class Receptionist extends StaffMember{
    private int deskNumber;
    private int hoursPerWeek;

    public Receptionist(String name, String surname, LocalDate dob, String phoneNo, String staffID){
        super(name, surname, dob, phoneNo, staffID);
    }
     public int getDeskNumber(){
        return deskNumber;
     }
     public void setDeskNumber(int deskNumber){
        this.deskNumber = deskNumber;
     }
     public int getHoursPerWeek(){
        return hoursPerWeek;
     }
     public void setHoursPerWeek(int hoursPerWeek){
        this.hoursPerWeek = hoursPerWeek;
     }

    @Override
    public String toString() {
        return "Receptionist{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", phoneNo='" + phoneNo + '\'' +
                ", staffID='" + staffID + '\'' +
                ", deskNumber=" + deskNumber +
                ", hoursPerWeek=" + hoursPerWeek +
                '}';
    }
}
