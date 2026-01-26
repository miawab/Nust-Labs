public class Lab2 {
    public static void main(String[] args)
    {   
        int year = 2006;
        int q = 8;
        int m = 8;
        int j = year/100;
        int k = year%100;
        int h = (q + (26*(m+1)/10) + k + (k/4) + (j/4) + (5*j))%7;
        String day = "";

        if(q == 1){
            q = 13;
        }
        else if(q == 2){
            q = 14;
        }

        switch (h) {
            case 0:
                day = "Saturday";
                break;
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
        }
        System.out.println("Given Date: "+q+"/"+m+"/"+year);
        System.out.println("Day of the Week: "+day);
    }
}
