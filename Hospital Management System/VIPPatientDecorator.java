public class VIPPatientDecorator extends UserDecorator {
    public VIPPatientDecorator(User user) {
        super(user);
    }

    public String getVIPServices() {
        return "Priority appointments, personalized care";
    }

    @Override
    public String toString() {
        return super.toString() + " (VIP Services: " + getVIPServices() + ")";
    }
}