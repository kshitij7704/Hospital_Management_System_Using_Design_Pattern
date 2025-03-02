public class SelfPayBilling implements BillingStrategy {
    @Override
    public double calculateBill(double amount) {
        System.out.println("Using Self-pay Billing Strategy");
        return amount;
    }
}