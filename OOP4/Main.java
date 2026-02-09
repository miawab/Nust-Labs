import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String topName = "";
        int topScore = 0;

        for(int i =0;i<n;i++){
            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter score: ");
            int score = sc.nextInt();

            if(score > topScore){
                topScore = score;
                topName = name;
            }
        }

        System.out.println("Top student: " + topName);
        System.out.println("Highest score: " + topScore);
    }
}
