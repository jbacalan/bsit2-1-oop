// Exportable.java
// An INTERFACE = a list of promises. It says WHAT, never HOW.
//
// Any class that implements Exportable promises it can turn itself
// into one line of CSV text, for example: 1,Razz,razz@liceo.edu.ph,ADMIN
public interface Exportable {

    // TODO 1
    String toCsv();

    // TODO 2
    default void printExport() {
        System.out.println(toCsv());
    }
}

