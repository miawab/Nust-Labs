import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter loan amount: ");
        double loan = sc.nextDouble();

        System.out.print("Enter years: ");
        int years = sc.nextInt();

        for(double rate =5;rate<=10;rate+=0.25){

            double monthlyRate = rate / 1200;
            int months = years * 12;

            double monthlyPayment = loan * monthlyRate /
            (1 - 1 / Math.pow(1 + monthlyRate, months));

            double totalPayment = monthlyPayment * months;

            System.out.println(rate + " " + monthlyPayment + " " + totalPayment);
        }
    }
}
