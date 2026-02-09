public class Main {
    public static void main(String[] args){

        double tuition = 10000;
        double rate = 0.06;

        for(int i =0;i<10;i++){
            tuition = tuition + tuition * rate;
        }

        System.out.println("Tuition after 10 years: " + tuition);

        double total = 0;

        for(int i =0;i<4;i++){
            total = total + tuition;
            tuition = tuition + tuition * rate;
        }

        System.out.println("Total cost of 4 years: " + total);
    }
}
