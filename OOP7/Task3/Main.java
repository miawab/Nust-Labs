class Applicant {
String name;
int age;
double monthlyIncome;
int creditScore;

Applicant(String name,int age,double monthlyIncome,int creditScore){
this.name=name;
this.age=age;
this.monthlyIncome=monthlyIncome;
this.creditScore=creditScore;
}

void display(){
System.out.println("Name: "+name+" | Age: "+age+" | Income: "+monthlyIncome+" | Credit Score: "+creditScore);
}
}

class LoanEvaluator {
Applicant[] applicants;
int count;

LoanEvaluator(int size){
applicants=new Applicant[size];
count=0;
}

void addApplicant(Applicant a){
if(count<applicants.length){
applicants[count]=a;
count++;
}else
System.out.println("Cannot add more applicants!");
}

boolean checkEligibility(Applicant a){
if(a.age>=21 && a.monthlyIncome>=50000 && a.creditScore>=650)
return true;
return false;
}

void evaluateAll(){
System.out.println("===== LOAN ELIGIBILITY REPORT =====");
for(int i=0;i<count;i++){
applicants[i].display();
if(checkEligibility(applicants[i]))
System.out.println("  --> ELIGIBLE for loan");
else
System.out.println("  --> NOT ELIGIBLE for loan");
System.out.println();
}
System.out.println("===================================");
}
}

public class Main {
public static void main(String[] args){
LoanEvaluator evaluator = new LoanEvaluator(5);

evaluator.addApplicant(new Applicant("Ahmed Raza",25,60000,700));
evaluator.addApplicant(new Applicant("Sara Malik",19,55000,680));
evaluator.addApplicant(new Applicant("Bilal Khan",30,45000,720));
evaluator.addApplicant(new Applicant("Hina Shah",22,75000,600));
evaluator.addApplicant(new Applicant("Usman Ali",35,90000,750));

evaluator.evaluateAll();
}
}
