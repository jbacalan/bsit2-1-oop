import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PaymentGateway gateway = new PaymentGateway();

        // Sample payments
        gateway.add(new GCashPayment(
                1001,
                "Ana",
                1500.00,
                "0917-555-0134"
        ));

        gateway.add(new MayaPayment(
                1002,
                "Jerome",
                899.50,
                "jerome@liceo.edu.ph"
        ));

        gateway.add(new CashPayment(
                1003,
                "Liza",
                250.00
        ));

        boolean running = true;

        System.out.println("======================================");
        System.out.println("            LICEO PAY");
        System.out.println("       Payment Gateway System");
        System.out.println("======================================");

        while (running) {

            System.out.println();
            System.out.println("1. Make Payment");
            System.out.println("2. Show All Receipts");
            System.out.println("3. Find Payment");
            System.out.println("4. Show Total Collected");
            System.out.println("5. Refund All Refundable Payments");
            System.out.println("6. Show Service Fees");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

            try {

                int choice = Integer.parseInt(input);

                switch (choice) {

                    case 1:
                        makePayment(scanner, gateway);
                        break;

                    case 2:
                        System.out.println();
                        System.out.println("All payment receipts:");
                        gateway.processAll();
                        break;

                    case 3:
                        findPayment(scanner, gateway);
                        break;

                    case 4:
                        System.out.println();
                        System.out.printf(
                                "Total collected: PHP %.2f%n",
                                gateway.totalCollected()
                        );
                        break;

                    case 5:
                        System.out.println();
                        System.out.println(
                                "Refunding every payment that can be refunded:"
                        );
                        gateway.refundAll();
                        break;

                    case 6:
                        System.out.println();
                        System.out.println(
                                "Service fees (the two serviceFee methods):"
                        );
                        gateway.showServiceFees();
                        break;

                    case 0:
                        running = false;
                        System.out.println("Thank you for using LICEO PAY.");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        scanner.close();
    }

    private static void makePayment(
            Scanner scanner,
            PaymentGateway gateway) {

        System.out.println();
        System.out.println("Choose payment method:");
        System.out.println("1. GCash");
        System.out.println("2. Maya");
        System.out.println("3. Cash");
        System.out.print("Enter choice: ");

        String methodInput = scanner.nextLine();

        try {

            int method = Integer.parseInt(methodInput);

            System.out.print("Enter payment ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter payer name: ");
            String payerName = scanner.nextLine();

            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            Payment payment;

            switch (method) {

                case 1:
                    System.out.print("Enter mobile number: ");
                    String mobile = scanner.nextLine();

                    payment = new GCashPayment(
                            id,
                            payerName,
                            amount,
                            mobile
                    );
                    break;

                case 2:
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    payment = new MayaPayment(
                            id,
                            payerName,
                            amount,
                            email
                    );
                    break;

                case 3:
                    payment = new CashPayment(
                            id,
                            payerName,
                            amount
                    );
                    break;

                default:
                    System.out.println("Invalid payment method.");
                    return;
            }

            gateway.add(payment);

            System.out.println();
            System.out.println("Payment added successfully.");
            payment.printReceipt();
            payment.printThankYou();

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Payment was not added.");
        }
    }

    private static void findPayment(
            Scanner scanner,
            PaymentGateway gateway) {

        System.out.println();
        System.out.print("Enter payment ID to find: ");

        try {

            int id = Integer.parseInt(scanner.nextLine());

            Payment payment = gateway.findById(id);

            if (payment == null) {
                System.out.println("Payment not found.");
            } else {
                System.out.println("Payment found:");
                payment.printReceipt();
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a number.");
        }
    }
}
