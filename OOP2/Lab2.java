public class Lab2 {
    public static void main(String[] args)
    {
        int a = 7;
        int factorial = 1;
        for(int i=1;i<a+1;i++){
            factorial = factorial*i;
        }
        System.out.println("factorial of "+a+" is "+factorial);
    }
}