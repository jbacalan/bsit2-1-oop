// GCashPayment.java
// A CHILD of Payment. A GCashPayment IS-A Payment, and it CAN-DO a refund.

public class GCashPayment extends Payment implements Refundable {

    // TODO 7(a)
    private String mobile;

    // TODO 7(b)
    public GCashPayment(int id, String payerName, double amount, String mobile) {
        super(id, payerName, amount);
        this.mobile = mobile;
    }

    // TODO 7(c)
    public String getMobile() {
        return mobile;
    }

    // TODO 7(d)
    @Override
    public String provider() {
        return "GCASH";
    }

    // TODO 7(e)
    @Override
    public void pay() {
        System.out.printf(" GCash: PHP %.2f sent from %s.%n",
                getAmount(), mobile);
    }

    // TODO 7(f)
    @Override
    public String refund() {
        return "GCash refund of PHP "
                + String.format("%.2f", getAmount())
                + " returned to " + mobile + ".";
    }

    // TODO 7(g)
    @Override
    public void printThankYou() {
        super.printThankYou();
        System.out.println(" An SMS receipt was sent to " + mobile);
    }
}
