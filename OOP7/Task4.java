import java.util.Scanner;

class Patient {
    int patientID;
    String name;
    double temperature;
    int heartRate;

    Patient(int patientID, String name, double temperature, int heartRate){
        this.patientID = patientID;
        this.name = name;
        this.temperature = temperature;
        this.heartRate = heartRate;
    }

    boolean hasFever(){
        return temperature > 99;
    }

    boolean isCritical(){
        return heartRate < 50 || heartRate > 120;
    }

    void display(){
        System.out.println("ID: " + patientID + " | Name: " + name + " | Temp: " + temperature + " | HR: " + heartRate);
    }
}

class HospitalSystem {
    Patient[] patients;
    int count;

    HospitalSystem(int size){
        patients = new Patient[size];
        count = 0;
    }

    void addPatient(Patient p){
        if(count < patients.length){
            patients[count] = p;
            count++;
        } else {
            System.out.println("No more space!");
        }
    }

    int countCritical(){
        int c = 0;
        for(int i = 0; i < count; i++){
            if(patients[i].isCritical())
                c++;
        }
        return c;
    }

    void showFeverPatients(){
        System.out.println("Patients with Fever:");
        for(int i = 0; i < count; i++){
            if(patients[i].hasFever())
                System.out.println("  - " + patients[i].name);
        }
    }

    void analyze(){
        System.out.println("\n===== PATIENT MONITORING REPORT =====");
        for(int i = 0; i < count; i++){
            patients[i].display();
            String status = "";
            if(patients[i].isCritical()) status += "CRITICAL ";
            if(patients[i].hasFever()) status += "FEVER ";
            if(status.equals("")) status = "Normal";
            System.out.println("  Status: " + status);
        }
        System.out.println("-------------------------------------");
        System.out.println("Total Critical Patients: " + countCritical());
        showFeverPatients();
        System.out.println("=====================================");
    }
}

public class Task4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        HospitalSystem hs = new HospitalSystem(n);

        for(int i = 0; i < n; i++){
            System.out.println("\n--- Patient " + (i+1) + " ---");
            System.out.print("Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Temperature: ");
            double temp = sc.nextDouble();
            System.out.print("Heart rate: ");
            int hr = sc.nextInt();
            sc.nextLine();

            hs.addPatient(new Patient(id, name, temp, hr));
        }

        hs.analyze();
    }
}
