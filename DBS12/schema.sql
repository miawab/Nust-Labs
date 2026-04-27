-- Database schema for the issue tracking system
CREATE TABLE IF NOT EXISTS User (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Staff (
    staff_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Issue (
    issue_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'Pending'
);

CREATE TABLE IF NOT EXISTS Assignment (
    assign_id INT PRIMARY KEY AUTO_INCREMENT,
    issue_id INT NOT NULL,
    staff_id INT NOT NULL,
    FOREIGN KEY (issue_id) REFERENCES Issue(issue_id) ON DELETE CASCADE,
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id) ON DELETE CASCADE,
    UNIQUE(issue_id)
);
