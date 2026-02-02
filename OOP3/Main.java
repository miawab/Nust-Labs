import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i =0;i<n;i++){
            System.out.println("Enter item: ");
            arr1[i] = sc.nextInt();
        }

        int temp = arr1[0];
        arr1[0] = arr1[n-1];
        arr1[n-1] = temp;

        System.out.println("Array: ");

        for(int i =0;i<n;i++){
            System.out.print(arr1[i]+"\t");
        }
        System.out.println("\n");
    }
}
