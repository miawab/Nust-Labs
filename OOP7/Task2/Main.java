class Vehicle {
String vehicleNum;
String ownerName;
int speedRecorded;
int allowedSpeed;
int previousViolations;

Vehicle(String vehicleNum,String ownerName,int speedRecorded,int allowedSpeed,int previousViolations){
this.vehicleNum=vehicleNum;
this.ownerName=ownerName;
this.speedRecorded=speedRecorded;
this.allowedSpeed=allowedSpeed;
this.previousViolations=previousViolations;
}

boolean isViolation(){
return speedRecorded>allowedSpeed;
}

int calcFine(){
if(!isViolation())
return 0;
int excess = speedRecorded-allowedSpeed;
int fine=0;
if(excess<=20)
fine=1000;
else
fine=2500;
fine += previousViolations*500;
return fine;
}

void display(){
System.out.println("Vehicle: "+vehicleNum+" | Owner: "+ownerName+" | Speed: "+speedRecorded+" | Allowed: "+allowedSpeed+" | Violations: "+previousViolations+" | Fine: Rs."+calcFine());
}
}

class TrafficSystem {
Vehicle[] vehicles;
int count;

TrafficSystem(int size){
vehicles=new Vehicle[size];
count=0;
}

void addVehicle(Vehicle v){
if(count<vehicles.length){
vehicles[count]=v;
count++;
}else
System.out.println("Array full!");
}

int totalFines(){
int total=0;
for(int i=0;i<count;i++){
total+=vehicles[i].calcFine();
}
return total;
}

Vehicle highestFineVehicle(){
Vehicle highest=vehicles[0];
for(int i=1;i<count;i++){
if(vehicles[i].calcFine()>highest.calcFine())
highest=vehicles[i];
}
return highest;
}

void generateReport(){
System.out.println("===== VIOLATION SUMMARY REPORT =====");
for(int i=0;i<count;i++){
if(vehicles[i].isViolation())
vehicles[i].display();
}
System.out.println("------------------------------------");
System.out.println("Total Fines Collected: Rs."+totalFines());
Vehicle h=highestFineVehicle();
System.out.println("Highest Fine Vehicle: "+h.vehicleNum+" ("+h.ownerName+") - Rs."+h.calcFine());
System.out.println("====================================");
}
}

public class Main {
public static void main(String[]args){
TrafficSystem ts = new TrafficSystem(5);

ts.addVehicle(new Vehicle("ABC-123","Hamza Ali",90,60,2));
ts.addVehicle(new Vehicle("XYZ-456","Sara Khan",55,60,0));
ts.addVehicle(new Vehicle("LMN-789","Usman Raza",100,80,3));
ts.addVehicle(new Vehicle("DEF-321","Ayesha Noor",130,80,1));
ts.addVehicle(new Vehicle("GHI-654","Faisal Ahmed",70,60,0));

ts.generateReport();

System.out.println("\n--- Individual Vehicle Check ---");
Vehicle v = new Vehicle("PKR-999","Zubair Iqbal",120,80,4);
v.display();
if(v.isViolation())
System.out.println("This vehicle has violated the speed limit!");
else
System.out.println("No violation.");
}
}
