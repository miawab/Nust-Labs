import java.util.Scanner;

class Family {
    String headName;
    int members;
    int severity;
    int daysSinceAid;

    Family(String headName, int members, int severity, int daysSinceAid){
        this.headName = headName;
        this.members = members;
        this.severity = severity;
        this.daysSinceAid = daysSinceAid;
    }

    int calcPackages(){
        int packages = members / 2;
        if(members % 2 != 0)
            packages++;
        if(severity == 3)
            packages += 2;
        return packages;
    }

    void display(){
        System.out.println("Head: " + headName + " | Members: " + members + " | Severity: " + severity + " | Days Since Aid: " + daysSinceAid + " | Packages: " + calcPackages());
    }
}

class ReliefSystem {
    Family[] families;
    int count;

    ReliefSystem(int size){
        families = new Family[size];
        count = 0;
    }

    void addFamily(Family f){
        if(count < families.length){
            families[count] = f;
            count++;
        } else {
            System.out.println("Array is full!");
        }
    }

    int totalPackages(){
        int total = 0;
        for(int i = 0; i < count; i++){
            total += families[i].calcPackages();
        }
        return total;
    }

    Family getImmediatePriority(){
        Family priority = families[0];
        for(int i = 1; i < count; i++){
            if(families[i].severity > priority.severity){
                priority = families[i];
            } else if(families[i].severity == priority.severity){
                if(families[i].daysSinceAid > priority.daysSinceAid)
                    priority = families[i];
            }
        }
        return priority;
    }

    void printReport(){
        System.out.println("\n===== ALLOCATION REPORT =====");
        for(int i = 0; i < count; i++){
            families[i].display();
        }
        System.out.println("-----------------------------");
        System.out.println("Total Packages Required: " + totalPackages());
        Family p = getImmediatePriority();
        System.out.println("Immediate Priority: " + p.headName + " (Severity: " + p.severity + ", Days since aid: " + p.daysSinceAid + ")");
        System.out.println("=============================");
    }
}

public class Task1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of families: ");
        int n = sc.nextInt();
        sc.nextLine();

        ReliefSystem system = new ReliefSystem(n);

        for(int i = 0; i < n; i++){
            System.out.println("\n--- Family " + (i+1) + " ---");
            System.out.print("Head of family name: ");
            String name = sc.nextLine();
            System.out.print("Number of members: ");
            int members = sc.nextInt();
            System.out.print("Severity level (1=Low, 2=Medium, 3=Critical): ");
            int severity = sc.nextInt();
            System.out.print("Days since last aid: ");
            int days = sc.nextInt();
            sc.nextLine();

            system.addFamily(new Family(name, members, severity, days));
        }

        system.printReport();

        System.out.println("\n--- Single Family Analysis ---");
        System.out.print("Enter family head name: ");
        String sName = sc.nextLine();
        System.out.print("Members: ");
        int sMembers = sc.nextInt();
        System.out.print("Severity: ");
        int sSeverity = sc.nextInt();
        System.out.print("Days since aid: ");
        int sDays = sc.nextInt();

        Family single = new Family(sName, sMembers, sSeverity, sDays);
        single.display();
        System.out.println("Packages needed: " + single.calcPackages());
    }
}
