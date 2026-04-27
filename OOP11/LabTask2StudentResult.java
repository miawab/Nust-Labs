import java.util.Scanner;

public class LabTask2StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            if (subjects < 0) {
                throw new IllegalArgumentException("Number of subjects cannot be negative");
            }

            int total = 0;

            for (int i = 1; i <= subjects; i++) {
                System.out.print("Enter marks of subject " + i + " (0 to 100): ");
                int marks = sc.nextInt();

                if (marks < 0 || marks > 100) {
                    throw new IllegalArgumentException("Invalid marks at subject " + i);
                }

                total += marks;
            }

            int average = total / subjects;

            System.out.println("Total marks: " + total);
            System.out.println("Average marks: " + average);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero. Subjects cannot be zero.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input type. Please enter numeric values.");
        } finally {
            sc.close();
        }
    }
}
