import java.time.LocalDate;

public class Doctor extends StaffMember{
    private String licenseNumber;
    private String specialization;
    private int consultationsPerWeekCount;

    public Doctor(String name, String sname){
        super(name, sname);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    public String getSpec() {
        return specialization;
    }
    public void setSpec(String specialization) {
        this.specialization = specialization;
    }
    public int getConsultationsPerWeekCount() {
        return consultationsPerWeekCount;
    }
    public void setConsultationsPerWeekCount(int consultationsPerWeekCount) {
        this.consultationsPerWeekCount = consultationsPerWeekCount;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", phoneNo='" + phoneNo + '\'' +
                ", staffID='" + staffID + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", specialization='" + specialization + '\'' +
                ", consultationsPerWeekCount=" + consultationsPerWeekCount +
                '}';
    }
}
