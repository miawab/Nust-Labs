import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int count = 0;
        for(int i =0;i<n;i++){
            System.out.println("Enter item: ");
            arr1[i] = sc.nextInt();
            if(arr1[i]>=10){
                count++;
            }
        }
        System.out.println("there are "+count+" integers in this array >= 10");
    }
}
