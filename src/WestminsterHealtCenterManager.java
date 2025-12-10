import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class WestminsterHealtCenterManager implements HealthCenterManager {
    private ArrayList<StaffMember> StaffMemberList;
    private int staffLimit;

    public WestminsterHealtCenterManager(int maxStaffLimit) {
        StaffMemberList = new ArrayList<StaffMember>();
        staffLimit = maxStaffLimit;
    }

    @Override
    public void runMenu() {
            boolean exit = false;

            System.out.println("\n-- Westminster Health Center Manager --");
            System.out.println("Press 1 to add staff member");
            System.out.println("Press 2 to display staff member");
            System.out.println("Press 3 to edit staff member");
            System.out.println("Press 4 to remove staff member");
            System.out.println("Press 5 to run GUI");
            System.out.println("Press 0 to exit the program");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch(choice) {
                case 0:
                    exit = true;
                    break;

                case 1:
                    this.addStaffMember();
                    break;

                case 2:
                    this.printStaffMember();
                    break;

                case 3:
                    this.editStaffMember();
                    break;

                case 4:
                    this.deleteStaffMember();
                    break;

                case 5:
                    this.runGUI();
                    break;
            }
        }

    @Override
    public void addStaffMember() {
        Scanner input = new Scanner(System.in);

        if(StaffMemberList.size() < staffLimit){
            System.out.println("Press 1 if you want to add a Doctor");
            System.out.println("Press 2 if you want to add a Receptionist");

            int choiceStaff = input.nextInt();
            input.nextLine();

            //common questions
            System.out.println("Enter the name");
            String name = input.nextLine();

            System.out.println("Enter the surname");
            String surname = input.nextLine();

            System.out.println("Enter the date of birth (ddmmyyyy format only!)");
            LocalDate date = null;
            boolean parsingSucceeds = false;
            while(!parsingSucceeds){
                String dob = input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddmmyyyy");

                try {
                    date = LocalDate.parse(dob, formatter);
                    parsingSucceeds = true;
                } catch(DateTimeParseException e) {
                    System.out.println("Enter the correct format. It should be ddmmyyyy!");
                    parsingSucceeds = false;
                }
            }

            System.out.println("Enter the phone number");
            String phoneNumber = input.nextLine();

            System.out.println("Enter the staff id");
            String staffID = input.nextLine();

            switch(choiceStaff){
                case 1: //Its a doctor
                    System.out.println("Enter the license number");
                    String licenseNumber = input.nextLine();

                    System.out.println("Enter the Specialization");
                    String spec = input.nextLine();

                    System.out.println("Enter the number of consultations per week");
                    int consultationsPerWeekCount = input.nextInt();
                    input.nextLine();

                    Doctor doctor = new Doctor(name, surname, date, phoneNumber, staffID);
                    doctor.setLicenseNumber(licenseNumber);
                    doctor.setSpec(spec);
                    doctor.setConsultationsPerWeekCount(consultationsPerWeekCount);

                    this.addStaffMemberList(doctor);
                    break;

                case 2:
                    System.out.println("Enter the desk number");
                    int deskNumber = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter the hours per week");
                    int hoursPerWeek = input.nextInt();
                    input.nextLine();

                    Receptionist receptionist = new Receptionist(name, surname, date, phoneNumber, staffID);
                    receptionist.setDeskNumber(deskNumber);
                    receptionist.setHoursPerWeek(hoursPerWeek);

                    this.addStaffMemberList(receptionist);
                    break;

                default:
                    System.out.println("Invalid staff type selected. Person not added.");
            }
        }
        else {
            System.out.println("The system is at full capacity");
        }
    }

    @Override
    public void addStaffMemberList(StaffMember staff) {
        if(this.StaffMemberList.size() < staffLimit) {
            StaffMemberList.add(staff);
        } else {
            System.out.println("No more space in the list");
        }
    }

    @Override
    public void printStaffMember() {
        if(!StaffMemberList.isEmpty()){
            System.out.println("\n--- Available Staff Members ---");

            Collections.sort(StaffMemberList);
            for(StaffMember staff: StaffMemberList){
                System.out.println(staff.toString());
            }
            System.out.println("---------------------------------\n");
        } else {
            System.out.println("There are no staff members in the system.");
        }
    }

    @Override
    public void editStaffMember() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter staff id of the required staff member");
        String id = input.nextLine();
        StaffMember foundStaffMember = null;

        for(StaffMember staff: StaffMemberList){
            if(staff.getStaffID().equals(id)){
                foundStaffMember = staff;
                System.out.println("Current Name: " + staff.getName());
                System.out.println("Current Surname: " + staff.getSurname());
                System.out.println("Current Role: " + staff.getClass().getSimpleName());

                System.out.println("Enter the new name: ");
                staff.setName(input.nextLine());

                System.out.println("Enter the new surname: ");
                staff.setSurname(input.nextLine());

                System.out.println("Name has been changed successfully!");
                break;
            }
        }
        if(foundStaffMember == null){
            System.out.println("Staff Member not found.");
        }
    }

    @Override
    public void deleteStaffMember() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter staff id of the required staff member");
        String id = input.nextLine();
        StaffMember foundStaffMember = null;

        for (StaffMember staff : StaffMemberList) {
            if (staff.getStaffID().equals(id)) {
                foundStaffMember = staff;
                System.out.println("Current Name: " + staff.getName());
                System.out.println("Current Surname: " + staff.getSurname());
                System.out.println("Current Role: " + staff.getClass().getSimpleName());

                System.out.println("Do you wish to remove this staff member from the system? (y/n) ");
                String choice = input.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    StaffMemberList.remove(staff);
                }
            }
            System.out.println("Staff Member has been removed successfully!");
            break;
        }
        if (foundStaffMember == null) {
            System.out.println("Staff Member not found.");
        }
    }

    @Override
    public void runGUI() {

    }
}

