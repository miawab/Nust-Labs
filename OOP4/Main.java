import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter s0: ");
        double s0 = sc.nextDouble();

        System.out.print("Enter v0: ");
        double v0 = sc.nextDouble();

        System.out.print("Enter a: ");
        double a = sc.nextDouble();

        System.out.print("Enter t: ");
        double t = sc.nextDouble();

        double s = s0 + v0*t + 0.5*a*t*t;

        System.out.println("s = " + s);
    }
}
