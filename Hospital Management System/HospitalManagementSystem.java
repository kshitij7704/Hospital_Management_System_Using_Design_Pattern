import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileDatabase db = FileDatabase.getInstance();
        AuthenticationProxy authProxy = new AuthenticationProxy();

        while (true) {
            System.out.println("--- Hospital Management System ---");
            System.out.println("1. Register New User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Username: ");
                String username = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                System.out.print("Enter Role (Admin/Doctor/Patient): ");
                String role = scanner.nextLine();

                try {
                    User newUser = UserFactory.createUser(role, name, username, password);
                    db.addUser(newUser);
                    System.out.println(role + " registered successfully!");
                } 
                catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } 
            else if (option == 2) {
                System.out.print("Enter Username: ");
                String username = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                if (authProxy.login(username, password)) {
                    System.out.println("Login successful!");
                    boolean isLoggedIn = true;

                    while (isLoggedIn) {
                        System.out.println("--- User Menu ---");
                        System.out.println("1. View Records");
                        System.out.println("2. Logout");
                        System.out.print("Choose an option: ");
                        int userOption = scanner.nextInt();
                        scanner.nextLine();

                        if (userOption == 1) {
                            authProxy.viewRecords();
                        } 
                        else if (userOption == 2) {
                            isLoggedIn = false;
                            System.out.println("Logged out.");
                        } 
                        else {
                            System.out.println("Invalid option. Try again.");
                        }
                    }
                } 
                else {
                    System.out.println("Invalid credentials!");
                }

            }
            else if (option == 3) {
                System.out.println("Exiting...");
                break;
            } 
            else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}