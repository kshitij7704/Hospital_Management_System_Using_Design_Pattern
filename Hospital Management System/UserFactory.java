import java.util.Scanner;

public class UserFactory {
    public static User createUser(String role, String name, String username, String password) {
        if (role.equalsIgnoreCase("Patient")) {
            System.out.print("Is the patient a VIP? (yes/no): ");
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            String isVIP = scanner.nextLine();
            User patient = new Patient(name, username, password);
            
            if (isVIP.equalsIgnoreCase("yes")) {
                // Decorated VIP patient
                return new VIPPatientDecorator(patient);
            }
            // Regular patient
            return patient;
        } 
        else if (role.equalsIgnoreCase("Doctor")) {
            return new Doctor(name, username, password);
        } 
        else if (role.equalsIgnoreCase("Admin")) {
            return new Admin(name, username, password);
        } 
        else {
            throw new IllegalArgumentException("Invalid role specified");
        }
    }
}