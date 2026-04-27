import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String DB_URL = "jdbc:mysql://localhost:3306/CollegeDB";
    static final String USER = "root";
    static final String PASS = "03345257340";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database successfully!");
            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Insert Record");
                System.out.println("2. View Records");
                System.out.println("3. Update Record");
                System.out.println("4. Delete Record");
                System.out.println("5. View Joined Data");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                switch (choice) {
                    case 1:
                        insertRecord(conn, scanner);
                        break;
                    case 2:
                        viewRecords(conn);
                        break;
                    case 3:
                        updateRecord(conn, scanner);
                        break;
                    case 4:
                        deleteRecord(conn, scanner);
                        break;
                    case 5:
                        viewJoinedData(conn);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 6);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { }
            scanner.close();
        }
    }

    static void insertRecord(Connection conn, Scanner scanner) {
        System.out.println("Insert into: 1. Student 2. Course 3. Enrollment");
        int table = scanner.nextInt();
        scanner.nextLine();
        try {
            if (table == 1) {
                System.out.print("Student ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Department: ");
                String dept = scanner.nextLine();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Student VALUES (?, ?, ?, ?)");
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setString(4, dept);
                ps.executeUpdate();
                System.out.println("Student inserted.");
            } else if (table == 2) {
                System.out.print("Course ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Course Name: ");
                String name = scanner.nextLine();
                System.out.print("Credits: ");
                int credits = scanner.nextInt();
                scanner.nextLine();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Course VALUES (?, ?, ?)");
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, credits);
                ps.executeUpdate();
                System.out.println("Course inserted.");
            } else if (table == 3) {
                System.out.print("Enrollment ID: ");
                int eid = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Student ID: ");
                int sid = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Course ID: ");
                int cid = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enrollment Date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Enrollment VALUES (?, ?, ?, ?)");
                ps.setInt(1, eid);
                ps.setInt(2, sid);
                ps.setInt(3, cid);
                ps.setString(4, date);
                ps.executeUpdate();
                System.out.println("Enrollment inserted.");
            } else {
                System.out.println("Invalid table.");
            }
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    static void viewRecords(Connection conn) {
        System.out.println("View: 1. Students 2. Courses 3. Enrollments");
        Scanner scanner = new Scanner(System.in);
        int table = scanner.nextInt();
        scanner.nextLine();
        String query = "";
        if (table == 1) query = "SELECT * FROM Student";
        else if (table == 2) query = "SELECT * FROM Course";
        else if (table == 3) query = "SELECT * FROM Enrollment";
        else { System.out.println("Invalid table."); return; }
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    System.out.print(md.getColumnName(i) + ": " + rs.getString(i) + "  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("View failed: " + e.getMessage());
        }
    }

    static void updateRecord(Connection conn, Scanner scanner) {
        System.out.println("Update: 1. Student Name 2. Course Name");
        int table = scanner.nextInt();
        scanner.nextLine();
        try {
            if (table == 1) {
                System.out.print("Student ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("New Name: ");
                String name = scanner.nextLine();
                PreparedStatement ps = conn.prepareStatement("UPDATE Student SET Name=? WHERE Student_ID=?");
                ps.setString(1, name);
                ps.setInt(2, id);
                int rows = ps.executeUpdate();
                if (rows > 0) System.out.println("Student updated.");
                else System.out.println("Student not found.");
            } else if (table == 2) {
                System.out.print("Course ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("New Course Name: ");
                String name = scanner.nextLine();
                PreparedStatement ps = conn.prepareStatement("UPDATE Course SET Course_Name=? WHERE Course_ID=?");
                ps.setString(1, name);
                ps.setInt(2, id);
                int rows = ps.executeUpdate();
                if (rows > 0) System.out.println("Course updated.");
                else System.out.println("Course not found.");
            } else {
                System.out.println("Invalid option.");
            }
        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    static void deleteRecord(Connection conn, Scanner scanner) {
        System.out.println("Delete from: 1. Student 2. Course 3. Enrollment");
        int table = scanner.nextInt();
        scanner.nextLine();
        try {
            if (table == 1) {
                System.out.print("Student ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Student WHERE Student_ID=?");
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                if (rows > 0) System.out.println("Student deleted.");
                else System.out.println("Student not found.");
            } else if (table == 2) {
                System.out.print("Course ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Course WHERE Course_ID=?");
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                if (rows > 0) System.out.println("Course deleted.");
                else System.out.println("Course not found.");
            } else if (table == 3) {
                System.out.print("Enrollment ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Enrollment WHERE Enrollment_ID=?");
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                if (rows > 0) System.out.println("Enrollment deleted.");
                else System.out.println("Enrollment not found.");
            } else {
                System.out.println("Invalid table.");
            }
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }

    static void viewJoinedData(Connection conn) {
        String query = "SELECT s.Name, c.Course_Name, e.Enrollment_Date FROM Student s JOIN Enrollment e ON s.Student_ID = e.Student_ID JOIN Course c ON e.Course_ID = c.Course_ID";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
            System.out.println("Student | Course | Enrollment Date");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("Join view failed: " + e.getMessage());
        }
    }
}
