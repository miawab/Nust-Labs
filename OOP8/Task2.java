public class Task2 {
    public static void main(String[] args) {
        Patient[] p = new Patient[4];
        p[0] = new CardiacPatient("P1", "Ali", 170, 102, 105, 6);
        p[1] = new DiabeticPatient("P2", "Sara", 230, 280, 5);
        p[2] = new RespiratoryPatient("P3", "Hassan", 89, 28, 8);
        p[3] = new CardiacPatient("P4", "Ayesha", 130, 84, 76, 2);

        HealthReport[] r = new HealthReport[p.length];
        int i;
        int critical = 0;
        int warning = 0;
        int stable = 0;

        for (i = 0; i < p.length; i++) {
            r[i] = p[i].evaluateHealth();
            System.out.println(r[i]);
            if (r[i].status.equals("Critical")) critical++;
            else if (r[i].status.equals("Warning")) warning++;
            else stable++;
        }

        Patient single = new DiabeticPatient("P99", "Single", 140, 210, 3);
        HealthReport one = single.evaluateHealth();
        System.out.println("Single patient: " + one);

        System.out.println("Critical cases list:");
        for (i = 0; i < r.length; i++) {
            if (r[i].status.equals("Critical")) {
                System.out.println(r[i].id + " " + r[i].name);
            }
        }

        System.out.println("Critical: " + critical);
        System.out.println("Warning: " + warning);
        System.out.println("Stable: " + stable);
    }
}

class HealthReport {
    String id;
    String name;
    String status;
    String note;

    HealthReport(String id, String name, String status, String note) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.note = note;
    }

    public String toString() {
        return id + " " + name + " " + status + " " + note;
    }
}

abstract class Patient {
    String id;
    String name;
    int checksPerDay;

    Patient(String id, String name, int checksPerDay) {
        this.id = id;
        this.name = name;
        this.checksPerDay = checksPerDay;
    }

    abstract HealthReport evaluateHealth();
}

class CardiacPatient extends Patient {
    int sys;
    int dia;
    int hr;

    CardiacPatient(String id, String name, int sys, int dia, int hr, int checksPerDay) {
        super(id, name, checksPerDay);
        this.sys = sys;
        this.dia = dia;
        this.hr = hr;
    }

    HealthReport evaluateHealth() {
        if (sys >= 180 || dia >= 120 || hr > 120) return new HealthReport(id, name, "Critical", "High BP/HR, checks/day " + checksPerDay);
        if (sys >= 140 || dia >= 90 || hr > 100) return new HealthReport(id, name, "Warning", "Need monitoring, checks/day " + checksPerDay);
        return new HealthReport(id, name, "Stable", "Normal, checks/day " + checksPerDay);
    }
}

class DiabeticPatient extends Patient {
    int fasting;
    int random;

    DiabeticPatient(String id, String name, int fasting, int random, int checksPerDay) {
        super(id, name, checksPerDay);
        this.fasting = fasting;
        this.random = random;
    }

    HealthReport evaluateHealth() {
        if (fasting >= 220 || random >= 300) return new HealthReport(id, name, "Critical", "Sugar very high, checks/day " + checksPerDay);
        if (fasting >= 126 || random >= 200) return new HealthReport(id, name, "Warning", "Sugar high, checks/day " + checksPerDay);
        return new HealthReport(id, name, "Stable", "Controlled, checks/day " + checksPerDay);
    }
}

class RespiratoryPatient extends Patient {
    int spo2;
    int rr;

    RespiratoryPatient(String id, String name, int spo2, int rr, int checksPerDay) {
        super(id, name, checksPerDay);
        this.spo2 = spo2;
        this.rr = rr;
    }

    HealthReport evaluateHealth() {
        if (spo2 < 85 || rr > 32) return new HealthReport(id, name, "Critical", "Breathing risk, checks/day " + checksPerDay);
        if (spo2 < 92 || rr > 24) return new HealthReport(id, name, "Warning", "Observe patient, checks/day " + checksPerDay);
        return new HealthReport(id, name, "Stable", "Fine, checks/day " + checksPerDay);
    }
}