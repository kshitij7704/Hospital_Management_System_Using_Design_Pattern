public class InsuranceBilling implements BillingStrategy {
    @Override
    public double calculateBill(double amount) {
        System.out.println("Using Insurance Billing Strategy");
        return amount * 0.8;
    }
}