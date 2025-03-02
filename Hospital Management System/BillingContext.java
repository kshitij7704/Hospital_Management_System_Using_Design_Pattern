public class BillingContext {
    private BillingStrategy billingStrategy;

    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    public double calculate(double amount) {
        return billingStrategy.calculateBill(amount);
    }
}