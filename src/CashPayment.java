// CashPayment.java
// A CHILD of Payment that is NOT Refundable.

public class CashPayment extends Payment {

    // TODO 9(a)
    public CashPayment(int id, String payerName, double amount) {
        super(id, payerName, amount);
    }

    // TODO 9(b)
    @Override
    public String provider() {
        return "CASH";
    }

    // TODO 9(c)
    @Override
    public void pay() {
        System.out.printf(" Cash: PHP %.2f received. Please get your change.%n",
                getAmount());
    }
}
