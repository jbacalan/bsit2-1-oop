// MayaPayment.java
// Another CHILD of Payment that can also be refunded.

public class MayaPayment extends Payment implements Refundable {

    // TODO 8(a)
    private String email;

    // TODO 8(b)
    public MayaPayment(int id, String payerName, double amount, String email) {
        super(id, payerName, amount);
        this.email = email;
    }

    // TODO 8(c)
    public String getEmail() {
        return email;
    }

    // TODO 8(d)
    @Override
    public String provider() {
        return "MAYA";
    }

    // TODO 8(e)
    @Override
    public void pay() {
        System.out.printf(" Maya: PHP %.2f charged to the wallet of %s.%n",
                getAmount(), email);
    }

    // TODO 8(f)
    @Override
    public String refund() {
        return "Maya refund of PHP "
                + String.format("%.2f", getAmount())
                + " emailed to " + email + ".";
    }

    // No printThankYou() override.
    // Maya inherits the parent's version.
}
