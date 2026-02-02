import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Enter length of Array: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        populateArray(arr1,n);
        sortArray(arr1,n);

        System.out.println("Enter element to find: ");
        int x = sc.nextInt();
        findElement(arr1,x);

        printArray(arr1,n);
    }

    static void populateArray(int[] array, int N){
    for(int i =0;i<N;i++){
        System.out.println("Enter item: ");
        array[i] = sc.nextInt();
        }
    }

    static void printArray(int[] array, int N){
        System.out.println("Array: ");
            for(int i =0;i<N;i++){
                System.out.print(array[i]+"\t");
            }
            System.out.print("\n");
    }

    static void sortArray(int[] array, int N){
        int temp;
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N-i-1;j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

    }

    public static boolean findElement(int[] array, int x){
        for(int i=0;i<array.length;i++){
            if(array[i]== x){
                System.out.println("Found");
                return true;
            }
        }
        System.out.println("Not found");
        return false;
    }
}
