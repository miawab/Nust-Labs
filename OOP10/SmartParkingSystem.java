import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle {
    protected String vehicleNumber;
    protected int entryTime;

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.entryTime = -1;
    }

    abstract String getType();
    abstract String getSlotType();
    abstract double getHourlyRate();
    abstract double getExtraCharge();

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setEntryTime(int time) {
        this.entryTime = time;
    }

    public int getEntryTime() {
        return entryTime;
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    String getType() {
        return "Bike";
    }

    @Override
    String getSlotType() {
        return "Small";
    }

    @Override
    double getHourlyRate() {
        return 20.0;
    }

    @Override
    double getExtraCharge() {
        return 0;
    }
}

class Car extends Vehicle {
    public Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    String getType() {
        return "Car";
    }

    @Override
    String getSlotType() {
        return "Medium";
    }

    @Override
    double getHourlyRate() {
        return 50.0;
    }

    @Override
    double getExtraCharge() {
        return 0;
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    String getType() {
        return "Truck";
    }

    @Override
    String getSlotType() {
        return "Large";
    }

    @Override
    double getHourlyRate() {
        return 100.0;
    }

    @Override
    double getExtraCharge() {
        return 200;
    }
}

class ParkingSlot {
    private String slotId;
    private String slotType;
    private boolean isOccupied;
    private Vehicle occupiedBy;

    public ParkingSlot(String slotId, String slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.isOccupied = false;
        this.occupiedBy = null;
    }

    public String getSlotId() {
        return slotId;
    }

    public String getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (!isOccupied) {
            isOccupied = true;
            occupiedBy = vehicle;
        }
    }

    public Vehicle removeVehicle() {
        if (isOccupied) {
            Vehicle temp = occupiedBy;
            isOccupied = false;
            occupiedBy = null;
            return temp;
        }
        return null;
    }

    public Vehicle getVehicle() {
        return occupiedBy;
    }
}

class ParkingBill {
    private String vehicleNumber;
    private String vehicleType;
    private int exitTime;
    private int duration;
    private double hourlyRate;
    private double extraCharge;
    private double totalCost;

    public ParkingBill(String vehicleNumber, String vehicleType, int entryTime, int exitTime, double hourlyRate, double extraCharge) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.exitTime = exitTime;
        this.duration = exitTime - entryTime;
        this.hourlyRate = hourlyRate;
        this.extraCharge = extraCharge;
        this.totalCost = (duration * hourlyRate) + extraCharge;
    }

    public void display() {
        System.out.println("Vehicle: " + vehicleNumber + " (" + vehicleType + ")");
        System.out.println("Exit Time: " + formatTime(exitTime));
        System.out.println("Duration: " + duration + " hour" + (duration > 1 ? "s" : ""));
        System.out.println();
        System.out.println("--- Bill Breakdown ---");
        System.out.printf("Rate: %.0f/hour\n", hourlyRate);

        if (extraCharge > 0) {
            System.out.printf("Total = %d × %.0f = %.0f PKR\n", duration, hourlyRate, duration * hourlyRate);
            System.out.println("Extra Space Charge = " + (int)extraCharge);
            System.out.printf("Total = (%d × %.0f) + %.0f = %.0f PKR\n", duration, hourlyRate, extraCharge, totalCost);
        } else {
            System.out.printf("Total = %d × %.0f = %.0f PKR\n", duration, hourlyRate, totalCost);
        }
    }

    private String formatTime(int time) {
        int hours = 10 + (time / 60);
        int minutes = time % 60;
        String period = hours >= 12 ? "PM" : "AM";
        if (hours > 12) hours -= 12;
        return String.format("%d:%02d %s", hours, minutes, period);
    }

    public double getTotalCost() {
        return totalCost;
    }
}

class ParkingLot {
    private List<ParkingSlot> slots;
    private List<ParkingBill> bills;
    private List<Vehicle> parkedVehicles;

    public ParkingLot(int smallSlots, int mediumSlots, int largeSlots) {
        this.slots = new ArrayList<>();
        this.bills = new ArrayList<>();
        this.parkedVehicles = new ArrayList<>();

        // Create slots
        for (int i = 1; i <= smallSlots; i++) {
            slots.add(new ParkingSlot("S" + i, "Small"));
        }
        for (int i = 1; i <= mediumSlots; i++) {
            slots.add(new ParkingSlot("M" + i, "Medium"));
        }
        for (int i = 1; i <= largeSlots; i++) {
            slots.add(new ParkingSlot("L" + i, "Large"));
        }
    }

    public void parkVehicle(Vehicle vehicle, int entryTime) {
        vehicle.setEntryTime(entryTime);

        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied() && slot.getSlotType().equals(vehicle.getSlotType())) {
                slot.parkVehicle(vehicle);
                parkedVehicles.add(vehicle);

                System.out.println("Vehicle Entered:");
                System.out.println("Type: " + vehicle.getType());
                System.out.println("Number: " + vehicle.getVehicleNumber());
                System.out.println();
                System.out.println("Assigned Slot: " + slot.getSlotId() + " (" + slot.getSlotType() + " Slot)");
                System.out.println("Entry Time: " + formatTime(entryTime));
                System.out.println();
                System.out.println("-----------------------------------------");
                System.out.println();
                return;
            }
        }

        System.out.println("No available slot for " + vehicle.getType());
    }

    public void removeVehicle(String vehicleNumber, int exitTime) {
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied() && slot.getVehicle().getVehicleNumber().equals(vehicleNumber)) {
                Vehicle vehicle = slot.removeVehicle();
                parkedVehicles.remove(vehicle);

                ParkingBill bill = new ParkingBill(vehicleNumber, vehicle.getType(), vehicle.getEntryTime(), exitTime, vehicle.getHourlyRate(), vehicle.getExtraCharge());
                bills.add(bill);

                bill.display();
                System.out.println();
                System.out.println("-----------------------------------------");
                System.out.println();
                return;
            }
        }
    }

    public int getAvailableSlots() {
        int available = 0;
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                available++;
            }
        }
        return available;
    }

    public int getTotalParkedVehicles() {
        return parkedVehicles.size();
    }

    public double getTotalRevenue() {
        double total = 0;
        for (ParkingBill bill : bills) {
            total += bill.getTotalCost();
        }
        return total;
    }

    private String formatTime(int time) {
        int hours = 10 + (time / 60);
        int minutes = time % 60;
        String period = hours >= 12 ? "PM" : "AM";
        if (hours > 12) hours -= 12;
        return String.format("%d:%02d %s", hours, minutes, period);
    }
}

class ParkingSystem {
    private ParkingLot parkingLot;

    public ParkingSystem() {
        this.parkingLot = new ParkingLot(3, 3, 2);
    }

    public void demonstrateSystem() {
        System.out.println("========== SMART PARKING SYSTEM ==========");
        System.out.println();

        // Vehicle entry
        Bike bike = new Bike("BK-101");
        Car car = new Car("CAR-202");
        Truck truck = new Truck("TRK-303");

        parkingLot.parkVehicle(bike, 0);      // 10:00 AM
        parkingLot.parkVehicle(car, 5);       // 10:05 AM
        parkingLot.parkVehicle(truck, 10);    // 10:10 AM

        System.out.println("=========================================");
        System.out.println("            VEHICLE EXIT");
        System.out.println("=========================================");
        System.out.println();

        // Vehicle exit
        parkingLot.removeVehicle("BK-101", 120);     // 12:00 PM (2 hours)
        parkingLot.removeVehicle("CAR-202", 185);    // 1:05 PM (3 hours)
        parkingLot.removeVehicle("TRK-303", 250);    // 2:10 PM (4 hours)

        System.out.println("=========================================");
        System.out.println("Summary:");
        System.out.println("Total Vehicles Parked: 3");
        System.out.println("Available Slots Remaining: " + parkingLot.getAvailableSlots());
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingSystem system = new ParkingSystem();
        system.demonstrateSystem();
        scanner.close();
    }
}
