import java.util.Scanner;

public class AuthenticationProxy implements HospitalSystemInterface {

    private User loggedInUser;

    @Override
    public boolean login(String username, String password) {
        FileDatabase db = FileDatabase.getInstance();
        User user = db.getUser(username);
        
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            
            if (user.getRole().equalsIgnoreCase("Admin")) {
                System.out.println("Admin access granted.");
            } 
            else if (user.getRole().equalsIgnoreCase("Doctor")) {
                System.out.println("Doctor access granted.");
            } 
            else if (user.getRole().equalsIgnoreCase("Patient")) {
                System.out.println("Patient access granted.");
            }
            return true;
        }
        
        return false;
    }

    @Override
    public void viewRecords() {
        FileDatabase db = FileDatabase.getInstance();
        
        if (loggedInUser.getRole().equalsIgnoreCase("Admin")) {
            System.out.println("Viewing all users:");
            for (User user : db.getAllUsers()) {
                System.out.println(user);
            }
        } 
        else if (loggedInUser.getRole().equalsIgnoreCase("Doctor")) {
            System.out.println("Viewing all patients:");
            for (User user : db.getAllUsers()) {
                if (user.getRole().equals("Patient")) {
                    System.out.println(user);
                }
            }
        } 
        else if (loggedInUser.getRole().equalsIgnoreCase("Patient")) {
            System.out.println("Viewing own record:");
            System.out.println(loggedInUser);
            System.out.print("Continue to billing? (yes/no): ");
            
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            String isBill = scanner.nextLine();
            
            if (isBill.equalsIgnoreCase("yes")) {
                billingProcedure();
            }
        } 
        else {
            System.out.println("Access denied.");
        }
    }

    private void billingProcedure() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the amount to calculate billing: ");
        double amount = scanner.nextDouble();
        
        BillingContext billingContext = new BillingContext();
        
        System.out.println("Choose Billing Strategy:");
        System.out.println("1. Insurance Billing");
        System.out.println("2. Self-Pay Billing");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            billingContext.setBillingStrategy(new InsuranceBilling());
        } 
        else {
            billingContext.setBillingStrategy(new SelfPayBilling());
        }
        
        double finalBill = billingContext.calculate(amount);
        System.out.println("Final Bill Amount: " + finalBill);
    }
}