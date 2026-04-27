import java.sql.*;
import java.util.Scanner;

public class IssueTracker {
    static final String DB_URL = "jdbc:mysql://localhost:3306/IssueDB";
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
                System.out.println("1. Register User");
                System.out.println("2. Create Issue");
                System.out.println("3. Assign Issue");
                System.out.println("4. View Issues with Staff");
                System.out.println("5. Update Issue Status");
                System.out.println("6. Delete Issue");
                System.out.println("7. Search Issues");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        registerUser(conn, scanner);
                        break;
                    case 2:
                        createIssue(conn, scanner);
                        break;
                    case 3:
                        assignIssue(conn, scanner);
                        break;
                    case 4:
                        viewIssuesWithStaff(conn);
                        break;
                    case 5:
                        updateIssueStatus(conn, scanner);
                        break;
                    case 6:
                        deleteIssue(conn, scanner);
                        break;
                    case 7:
                        searchIssues(conn, scanner);
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 8);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { }
            scanner.close();
        }
    }

    static void registerUser(Connection conn, Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        if (email.isEmpty()) {
            System.out.println("Email cannot be empty.");
            return;
        }
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO User (name, email) VALUES (?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println("User registered.");
        } catch (SQLException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    static void createIssue(Connection conn, Scanner scanner) {
        System.out.print("Enter issue title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String desc = scanner.nextLine();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Issue (title, description, status) VALUES (?, ?, 'Pending')");
            ps.setString(1, title);
            ps.setString(2, desc);
            ps.executeUpdate();
            System.out.println("Issue created.");
        } catch (SQLException e) {
            System.out.println("Issue creation failed: " + e.getMessage());
        }
    }

    static void assignIssue(Connection conn, Scanner scanner) {
        System.out.println("All Issues:");
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT issue_id, title FROM Issue")) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " | Title: " + rs.getString(2));
            }
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); return; }
        System.out.println("All Staff:");
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT staff_id, name FROM Staff")) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " | Name: " + rs.getString(2));
            }
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); return; }
        System.out.print("Enter issue_id: ");
        int issueId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter staff_id: ");
        int staffId = scanner.nextInt();
        scanner.nextLine();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Assignment (issue_id, staff_id) VALUES (?, ?)");
            ps.setInt(1, issueId);
            ps.setInt(2, staffId);
            ps.executeUpdate();
            System.out.println("Issue assigned.");
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate"))
                System.out.println("This issue is already assigned.");
            else
                System.out.println("Assignment failed: " + e.getMessage());
        }
    }

    static void viewIssuesWithStaff(Connection conn) {
        String query = "SELECT i.title, i.status, s.name FROM Issue i LEFT JOIN Assignment a ON i.issue_id = a.issue_id LEFT JOIN Staff s ON a.staff_id = s.staff_id";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
            System.out.println("Title | Status | Staff");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + (rs.getString(3) == null ? "Unassigned" : rs.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println("View failed: " + e.getMessage());
        }
    }

    static void updateIssueStatus(Connection conn, Scanner scanner) {
        System.out.print("Enter issue_id: ");
        int issueId = scanner.nextInt();
        scanner.nextLine();
        String getStatus = "SELECT status FROM Issue WHERE issue_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(getStatus);
            ps.setInt(1, issueId);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Issue not found.");
                return;
            }
            String status = rs.getString(1);
            String newStatus = null;
            if (status.equals("Pending")) newStatus = "In Progress";
            else if (status.equals("In Progress")) newStatus = "Resolved";
            else if (status.equals("Resolved")) {
                System.out.println("Issue already resolved.");
                return;
            }
            if (newStatus != null) {
                PreparedStatement ups = conn.prepareStatement("UPDATE Issue SET status=? WHERE issue_id=?");
                ups.setString(1, newStatus);
                ups.setInt(2, issueId);
                ups.executeUpdate();
                System.out.println("Status updated to " + newStatus);
            }
        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    static void deleteIssue(Connection conn, Scanner scanner) {
        System.out.print("Enter issue_id to delete: ");
        int issueId = scanner.nextInt();
        scanner.nextLine();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Assignment WHERE issue_id=?");
            ps.setInt(1, issueId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Cannot delete assigned issue");
                return;
            }
            PreparedStatement del = conn.prepareStatement("DELETE FROM Issue WHERE issue_id=?");
            del.setInt(1, issueId);
            int rows = del.executeUpdate();
            if (rows > 0) System.out.println("Issue deleted.");
            else System.out.println("Issue not found.");
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }

    static void searchIssues(Connection conn, Scanner scanner) {
        System.out.println("Search by: 1. Status 2. Issue ID");
        int opt = scanner.nextInt();
        scanner.nextLine();
        String query = "";
        if (opt == 1) {
            System.out.print("Enter status (Pending/In Progress/Resolved): ");
            String status = scanner.nextLine();
            query = "SELECT * FROM Issue WHERE status=?";
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, status);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("issue_id") + ", Title: " + rs.getString("title") + ", Status: " + rs.getString("status"));
                }
            } catch (SQLException e) {
                System.out.println("Search failed: " + e.getMessage());
            }
        } else if (opt == 2) {
            System.out.print("Enter issue_id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            query = "SELECT * FROM Issue WHERE issue_id=?";
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("issue_id") + ", Title: " + rs.getString("title") + ", Status: " + rs.getString("status"));
                } else {
                    System.out.println("Issue not found.");
                }
            } catch (SQLException e) {
                System.out.println("Search failed: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid option.");
        }
    }
}
