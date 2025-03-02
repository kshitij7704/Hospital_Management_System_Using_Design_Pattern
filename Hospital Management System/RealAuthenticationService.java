public class RealAuthenticationService implements AuthenticationService {
    @Override
    public boolean login(String username, String password) {
        FileDatabase db = FileDatabase.getInstance();
        User user = db.getUser(username);
        
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful for: " + username);
            return true;
        }
        
        System.out.println("Login failed for: " + username);
        return false;
    }

    @Override
    public void viewRecord(String username) {
        FileDatabase db = FileDatabase.getInstance();
        User user = db.getUser(username);
        
        if (user != null) {
            System.out.println("Record for " + username + ": " + user);
        } else {
            System.out.println("No record found for " + username);
        }
    }
}