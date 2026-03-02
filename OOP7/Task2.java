import java.util.Scanner;

class Vehicle {
    String vehicleNum;
    String ownerName;
    int speedRecorded;
    int allowedSpeed;
    int previousViolations;

    Vehicle(String vehicleNum, String ownerName, int speedRecorded, int allowedSpeed, int previousViolations){
        this.vehicleNum = vehicleNum;
        this.ownerName = ownerName;
        this.speedRecorded = speedRecorded;
        this.allowedSpeed = allowedSpeed;
        this.previousViolations = previousViolations;
    }

    boolean isViolation(){
        return speedRecorded > allowedSpeed;
    }

    int calcFine(){
        if(!isViolation())
            return 0;
        int excess = speedRecorded - allowedSpeed;
        int fine = 0;
        if(excess <= 20)
            fine = 1000;
        else
            fine = 2500;
        fine += previousViolations * 500;
        return fine;
    }

    void display(){
        System.out.println("Vehicle: " + vehicleNum + " | Owner: " + ownerName + " | Speed: " + speedRecorded + " | Allowed: " + allowedSpeed + " | Violations: " + previousViolations + " | Fine: Rs." + calcFine());
    }
}

class TrafficSystem {
    Vehicle[] vehicles;
    int count;

    TrafficSystem(int size){
        vehicles = new Vehicle[size];
        count = 0;
    }

    void addVehicle(Vehicle v){
        if(count < vehicles.length){
            vehicles[count] = v;
            count++;
        } else {
            System.out.println("Array full!");
        }
    }

    int totalFines(){
        int total = 0;
        for(int i = 0; i < count; i++){
            total += vehicles[i].calcFine();
        }
        return total;
    }

    Vehicle highestFineVehicle(){
        Vehicle highest = vehicles[0];
        for(int i = 1; i < count; i++){
            if(vehicles[i].calcFine() > highest.calcFine())
                highest = vehicles[i];
        }
        return highest;
    }

    void generateReport(){
        System.out.println("\n===== VIOLATION SUMMARY REPORT =====");
        for(int i = 0; i < count; i++){
            if(vehicles[i].isViolation())
                vehicles[i].display();
        }
        System.out.println("------------------------------------");
        System.out.println("Total Fines Collected: Rs." + totalFines());
        Vehicle h = highestFineVehicle();
        System.out.println("Highest Fine Vehicle: " + h.vehicleNum + " (" + h.ownerName + ") - Rs." + h.calcFine());
        System.out.println("====================================");
    }
}

public class Task2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        TrafficSystem ts = new TrafficSystem(n);

        for(int i = 0; i < n; i++){
            System.out.println("\n--- Vehicle " + (i+1) + " ---");
            System.out.print("Vehicle number: ");
            String num = sc.nextLine();
            System.out.print("Owner name: ");
            String owner = sc.nextLine();
            System.out.print("Speed recorded: ");
            int speed = sc.nextInt();
            System.out.print("Allowed speed: ");
            int allowed = sc.nextInt();
            System.out.print("Previous violations: ");
            int prev = sc.nextInt();
            sc.nextLine();

            ts.addVehicle(new Vehicle(num, owner, speed, allowed, prev));
        }

        ts.generateReport();

        System.out.println("\n--- Individual Vehicle Check ---");
        System.out.print("Vehicle number: ");
        String vNum = sc.nextLine();
        System.out.print("Owner: ");
        String vOwner = sc.nextLine();
        System.out.print("Speed: ");
        int vSpeed = sc.nextInt();
        System.out.print("Allowed speed: ");
        int vAllowed = sc.nextInt();
        System.out.print("Previous violations: ");
        int vPrev = sc.nextInt();

        Vehicle v = new Vehicle(vNum, vOwner, vSpeed, vAllowed, vPrev);
        v.display();
        if(v.isViolation())
            System.out.println("This vehicle has violated the speed limit!");
        else
            System.out.println("No violation.");
    }
}
