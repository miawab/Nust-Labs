class Family {
String headName;
int members;
int severity;
int daysSinceAid;

Family(String headName,int members,int severity,int daysSinceAid){
this.headName=headName;
this.members=members;
this.severity=severity;
this.daysSinceAid=daysSinceAid;
}

int calcPackages(){
int packages = members/2;
if(members%2!=0)
packages++;
if(severity==3)
packages+=2;
return packages;
}

void display(){
System.out.println("Head: "+headName+" | Members: "+members+" | Severity: "+severity+" | Days Since Aid: "+daysSinceAid+" | Packages: "+calcPackages());
}
}

class ReliefSystem {
Family[] families;
int count;

ReliefSystem(int size){
families = new Family[size];
count=0;
}

void addFamily(Family f){
if(count<families.length){
families[count]=f;
count++;
}else{
System.out.println("Array is full!");
}
}

int totalPackages(){
int total=0;
for(int i=0;i<count;i++){
total+=families[i].calcPackages();
}
return total;
}

Family getImmediatePriority(){
Family priority=families[0];
for(int i=1;i<count;i++){
if(families[i].severity>priority.severity){
priority=families[i];
}else if(families[i].severity==priority.severity){
if(families[i].daysSinceAid>priority.daysSinceAid)
priority=families[i];
}
}
return priority;
}

void printReport(){
System.out.println("===== ALLOCATION REPORT =====");
for(int i=0;i<count;i++){
families[i].display();
}
System.out.println("-----------------------------");
System.out.println("Total Packages Required: "+totalPackages());
Family p = getImmediatePriority();
System.out.println("Immediate Priority: "+p.headName+" (Severity: "+p.severity+", Days since aid: "+p.daysSinceAid+")");
System.out.println("=============================");
}
}

public class Main {
public static void main(String[] args){
ReliefSystem system = new ReliefSystem(5);

system.addFamily(new Family("Ahmed Khan",6,3,10));
system.addFamily(new Family("Ali Raza",4,1,3));
system.addFamily(new Family("Bilal Shah",5,2,7));
system.addFamily(new Family("Usman Tariq",3,3,15));
system.addFamily(new Family("Hamza Siddiqui",7,2,5));

system.printReport();

System.out.println("\n--- Single Family Analysis ---");
Family single = new Family("Zain Malik",8,3,20);
single.display();
System.out.println("Packages needed: "+single.calcPackages());
}
}
