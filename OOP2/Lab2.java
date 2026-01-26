public class Lab2 {
    public static void main(String[] args)
    {
        int a = 3;
        int b = 5;
        System.out.println("a is "+a+" b is "+b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a is "+a+" b is "+b);
    }
}