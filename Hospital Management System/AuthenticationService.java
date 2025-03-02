public interface AuthenticationService {
    boolean login(String username, String password);
    void viewRecord(String username);
}