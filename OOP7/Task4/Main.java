class Patient {
int patientID;
String name;
double temperature;
int heartRate;

Patient(int patientID,String name,double temperature,int heartRate){
this.patientID=patientID;
this.name=name;
this.temperature=temperature;
this.heartRate=heartRate;
}

boolean hasFever(){
return temperature>99;
}

boolean isCritical(){
return heartRate<50 || heartRate>120;
}

void display(){
System.out.println("ID: "+patientID+" | Name: "+name+" | Temp: "+temperature+" | HR: "+heartRate);
}
}

class HospitalSystem {
Patient[] patients;
int count;

HospitalSystem(int size){
patients=new Patient[size];
count=0;
}

void addPatient(Patient p){
if(count<patients.length){
patients[count]=p;
count++;
}else
System.out.println("No more space!");
}

int countCritical(){
int c=0;
for(int i=0;i<count;i++){
if(patients[i].isCritical())
c++;
}
return c;
}

void showFeverPatients(){
System.out.println("Patients with Fever:");
for(int i=0;i<count;i++){
if(patients[i].hasFever())
System.out.println("  - "+patients[i].name);
}
}

void analyze(){
System.out.println("===== PATIENT MONITORING REPORT =====");
for(int i=0;i<count;i++){
patients[i].display();
String status="";
if(patients[i].isCritical()) status+="CRITICAL ";
if(patients[i].hasFever()) status+="FEVER ";
if(status.equals("")) status="Normal";
System.out.println("  Status: "+status);
}
System.out.println("-------------------------------------");
System.out.println("Total Critical Patients: "+countCritical());
showFeverPatients();
System.out.println("=====================================");
}
}

public class Main {
public static void main(String[] args){
HospitalSystem hs = new HospitalSystem(5);

hs.addPatient(new Patient(101,"Zain Ahmed",101.5,75));
hs.addPatient(new Patient(102,"Fatima Noor",98.6,45));
hs.addPatient(new Patient(103,"Hamza Tariq",100.2,130));
hs.addPatient(new Patient(104,"Ayesha Iqbal",97.8,80));
hs.addPatient(new Patient(105,"Omar Farooq",102.0,90));

hs.analyze();
}
}
