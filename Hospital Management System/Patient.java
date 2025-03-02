public class Patient extends User {
    public Patient(String name, String username, String password) {
        super(name, username, password, "Patient");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}