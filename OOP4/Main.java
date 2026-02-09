import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        double[] arr = new double[10];

        for(int i =0;i<10;i++){
            System.out.print("Enter number: ");
            arr[i] = sc.nextDouble();
            sum = sum + arr[i];
        }

        double mean = sum / 10;
        double temp = 0;

        for(int i =0;i<10;i++){
            temp = temp + Math.pow(arr[i] - mean, 2);
        }

        double deviation = Math.sqrt(temp / 10);

        System.out.println("Mean: " + mean);
        System.out.println("Deviation: " + deviation);
    }
}
