// Refundable.java
// An INTERFACE = a list of promises. It says WHAT, never HOW.

public interface Refundable {

    // TODO 1
    String refund();

    // TODO 2
    default void printRefundNotice() {
        System.out.println("   " + refund());
    }
}
