// Name: Jonathan Bacalan
// Activity: Lab Activity 4 - Java Toolbox

public class Book {
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Arrays to store up to 10 students
            int[] studentID = new int[10];
            String[] fullName = new String[10];
            int[] age = new int[10];
            String[] course = new String[10];
            double[] grade = new double[10];
            boolean[] enrolled = new boolean[10];

            int count = 0;
            int choice;

            do {
                System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. View Statistics");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // Clear buffer

                switch (choice) {

                    case 1:
                        if (count >= 10) {
                            System.out.println("Student list is already full!");
                            break;
                        }

                        System.out.print("Enter Student ID: ");
                        studentID[count] = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Full Name: ");
                        fullName[count] = sc.nextLine();

                        do {
                            System.out.print("Enter Age: ");
                            age[count] = sc.nextInt();

                            if (age[count] <= 0) {
                                System.out.println("Age must be positive.");
                            }
                        } while (age[count] <= 0);

                        sc.nextLine();

                        System.out.print("Enter Course: ");
                        course[count] = sc.nextLine();

                        do {
                            System.out.print("Enter Grade: ");
                            grade[count] = sc.nextDouble();

                            if (grade[count] < 0 || grade[count] > 100) {
                                System.out.println("Grade must be between 0 and 100.");
                            }

                        } while (grade[count] < 0 || grade[count] > 100);

                        System.out.print("Enrolled? (true/false): ");
                        enrolled[count] = sc.nextBoolean();

                        count++;

                        System.out.println("Student added successfully!");
                        break;


                    case 2:

                        if (count == 0) {
                            System.out.println("No students available.");
                            break;
                        }

                        System.out.println("\n--------------------------------------------------------------------------------------------");
                        System.out.printf("%-8s %-20s %-5s %-15s %-8s %-10s %-15s\n",
                                "ID", "Name", "Age", "Course", "Grade", "Status", "Standing");
                        System.out.println("--------------------------------------------------------------------------------------------");

                        for (int i = 0; i < count; i++) {

                            String standing;

                            if (grade[i] >= 90) {
                                standing = "Dean's Lister";
                            } else if (grade[i] >= 75) {
                                standing = "Passed";
                            } else {
                                standing = "Failed";
                            }

                            System.out.printf("%-8d %-20s %-5d %-15s %-8.2f %-10b %-15s\n",
                                    studentID[i],
                                    fullName[i],
                                    age[i],
                                    course[i],
                                    grade[i],
                                    enrolled[i],
                                    standing);
                        }

                        break;


                    case 3:

                        if (count == 0) {
                            System.out.println("No students available.");
                            break;
                        }

                        System.out.print("Enter Student ID to search: ");
                        int searchID = sc.nextInt();

                        boolean found = false;

                        for (int i = 0; i < count; i++) {

                            if (studentID[i] == searchID) {

                                System.out.println("\nStudent Found:");
                                System.out.println("ID: " + studentID[i]);
                                System.out.println("Name: " + fullName[i]);
                                System.out.println("Age: " + age[i]);
                                System.out.println("Course: " + course[i]);
                                System.out.println("Grade: " + grade[i]);
                                System.out.println("Enrolled: " + enrolled[i]);

                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Student not found.");
                        }

                        break;


                    case 4:

                        if (count == 0) {
                            System.out.println("No students available.");
                            break;
                        }

                        double total = 0;
                        double highestGrade = grade[0];
                        String topStudent = fullName[0];

                        for (int i = 0; i < count; i++) {

                            total += grade[i];

                            if (grade[i] > highestGrade) {
                                highestGrade = grade[i];
                                topStudent = fullName[i];
                            }
                        }

                        double average = total / count;

                        System.out.println("\n===== CLASS STATISTICS =====");
                        System.out.println("Total Students : " + count);
                        System.out.printf("Average Grade : %.2f\n", average);
                        System.out.println("Top Student : " + topStudent);
                        System.out.printf("Top Grade : %.2f\n", highestGrade);

                        break;


                    case 5:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 5);

            sc.close();
        }
    }}
