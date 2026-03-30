public class Task3 {
    public static void main(String[] args) {
        Student[] s = new Student[5];
        s[0] = new ExamOnlyStudent("S1", "Ali", 86);
        s[1] = new QuizProjectPresentationStudent("S2", "Sara", 70, 85, 90);
        s[2] = new AttendanceBasedStudent("S3", "Hassan", 75, 95);
        s[3] = new QuizProjectPresentationStudent("S4", "Ayesha", 92, 90, 88);
        s[4] = new ExamOnlyStudent("S5", "Bilal", 92);

        Result[] r = new Result[s.length];
        int i;
        double top = -1;

        for (i = 0; i < s.length; i++) {
            r[i] = s[i].evaluate();
            System.out.println(r[i]);
            if (r[i].score > top) top = r[i].score;
        }

        System.out.println("Top students:");
        for (i = 0; i < r.length; i++) {
            if (r[i].score == top) System.out.println(r[i].id + " " + r[i].name + " " + r[i].score + " " + r[i].category);
        }

        Student single = new AttendanceBasedStudent("S99", "Single", 64, 88);
        System.out.println("Single student: " + single.evaluate());
    }
}

class Result {
    String id;
    String name;
    double score;
    String category;

    Result(String id, String name, double score, String category) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.category = category;
    }

    public String toString() {
        return id + " " + name + " " + score + " " + category;
    }
}

interface Strategy {
    double calc(Student s);
}

abstract class Student {
    String id;
    String name;
    Strategy strategy;

    Student(String id, String name, Strategy strategy) {
        this.id = id;
        this.name = name;
        this.strategy = strategy;
    }

    Result evaluate() {
        double score = strategy.calc(this);
        return new Result(id, name, score, category(score));
    }

    String category(double score) {
        if (score >= 85) return "Excellent";
        if (score >= 65) return "Good";
        return "Needs Improvement";
    }
}

class ExamOnlyStudent extends Student {
    double exam;

    ExamOnlyStudent(String id, String name, double exam) {
        super(id, name, new ExamStrategy());
        this.exam = exam;
    }
}

class QuizProjectPresentationStudent extends Student {
    double quiz;
    double project;
    double presentation;

    QuizProjectPresentationStudent(String id, String name, double quiz, double project, double presentation) {
        super(id, name, new CwStrategy());
        this.quiz = quiz;
        this.project = project;
        this.presentation = presentation;
    }
}

class AttendanceBasedStudent extends Student {
    double performance;
    double attendance;

    AttendanceBasedStudent(String id, String name, double performance, double attendance) {
        super(id, name, new AttendanceStrategy());
        this.performance = performance;
        this.attendance = attendance;
    }
}

class ExamStrategy implements Strategy {
    public double calc(Student s) {
        return ((ExamOnlyStudent) s).exam;
    }
}

class CwStrategy implements Strategy {
    public double calc(Student s) {
        QuizProjectPresentationStudent x = (QuizProjectPresentationStudent) s;
        return x.quiz * 0.30 + x.project * 0.45 + x.presentation * 0.25;
    }
}

class AttendanceStrategy implements Strategy {
    public double calc(Student s) {
        AttendanceBasedStudent x = (AttendanceBasedStudent) s;
        return x.performance * 0.80 + x.attendance * 0.20;
    }
}