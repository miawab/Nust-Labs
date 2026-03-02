import java.util.Scanner;

class Applicant {
    String name;
    int age;
    double monthlyIncome;
    int creditScore;

    Applicant(String name, int age, double monthlyIncome, int creditScore){
        this.name = name;
        this.age = age;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
    }

    void display(){
        System.out.println("Name: " + name + " | Age: " + age + " | Income: " + monthlyIncome + " | Credit Score: " + creditScore);
    }
}

class LoanEvaluator {
    Applicant[] applicants;
    int count;

    LoanEvaluator(int size){
        applicants = new Applicant[size];
        count = 0;
    }

    void addApplicant(Applicant a){
        if(count < applicants.length){
            applicants[count] = a;
            count++;
        } else {
            System.out.println("Cannot add more applicants!");
        }
    }

    boolean checkEligibility(Applicant a){
        if(a.age >= 21 && a.monthlyIncome >= 50000 && a.creditScore >= 650)
            return true;
        return false;
    }

    void evaluateAll(){
        System.out.println("\n===== LOAN ELIGIBILITY REPORT =====");
        for(int i = 0; i < count; i++){
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

public class Task3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of applicants: ");
        int n = sc.nextInt();
        sc.nextLine();

        LoanEvaluator evaluator = new LoanEvaluator(n);

        for(int i = 0; i < n; i++){
            System.out.println("\n--- Applicant " + (i+1) + " ---");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Monthly income: ");
            double income = sc.nextDouble();
            System.out.print("Credit score: ");
            int credit = sc.nextInt();
            sc.nextLine();

            evaluator.addApplicant(new Applicant(name, age, income, credit));
        }

        evaluator.evaluateAll();
    }
}
