package atm;

public class ATMService {

    // ---------- OVERLOADING ----------

    public void deposit(Account account, double amount) {
        account.deposit(amount);

        System.out.printf(
                "Deposited PHP %.2f%n",
                amount
        );
    }

    public void deposit(Account account, double amount, String note) {
        account.deposit(amount);

        System.out.printf(
                "Deposited PHP %.2f%n",
                amount
        );

        System.out.println("Note: " + note);
    }

    // ---------- VARARGS ----------

    public double depositAll(Account account, double... amounts) {
        double total = 0;

        for (double amount : amounts) {
            account.deposit(amount);
            total += amount;
        }

        return total;
    }

    // ---------- PASS-BY-VALUE ----------

    public void tryToReplace(Account account) {
        account = new SavingsAccount(
                "XX-000",
                "Ghost Account",
                0,
                0
        );

        System.out.println("Inside the method : " + account);

        /*
         * Java is always pass-by-value. When an object is passed,
         * a copy of the reference is given to this method.
         * Reassigning this copied reference to a new object does
         * not change the caller's original variable.
         */
    }

    public void addBonus(Account account, double bonus) {
        account.deposit(bonus);

        /*
         * The reference itself is passed by value, but both the
         * caller's reference and this method's copied reference
         * point to the same object. Therefore, changing the
         * object's balance is visible to the caller.
         */
    }

    // ---------- TRANSFER ----------

    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {

        from.withdraw(amount);
        to.deposit(amount);
    }
}
