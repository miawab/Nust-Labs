import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Customer {
    protected int id;
    protected String name;
    protected int unitsConsumed;

    public Customer(int id, String name, int unitsConsumed) {
        this.id = id;
        this.name = name;
        this.unitsConsumed = unitsConsumed;
    }

    abstract Bill calculateBill();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int units) {
        this.unitsConsumed = units;
    }

    public abstract String getType();
}

class ResidentialCustomer extends Customer {
    private static final int BASIC_RATE_THRESHOLD = 100;
    private static final double BASIC_RATE = 5.0;
    private static final double EXCESS_RATE = 8.0;
    private static final double SUBSIDY_PERCENTAGE = 0.10;

    public ResidentialCustomer(int id, String name, int unitsConsumed) {
        super(id, name, unitsConsumed);
    }

    @Override
    public Bill calculateBill() {
        double basicCharge = 0;
        double excessCharge = 0;

        if (unitsConsumed <= BASIC_RATE_THRESHOLD) {
            basicCharge = unitsConsumed * BASIC_RATE;
        } else {
            basicCharge = BASIC_RATE_THRESHOLD * BASIC_RATE;
            int excessUnits = unitsConsumed - BASIC_RATE_THRESHOLD;
            excessCharge = excessUnits * EXCESS_RATE;
        }

        double subtotal = basicCharge + excessCharge;
        double subsidy = subtotal * SUBSIDY_PERCENTAGE;
        double totalCost = subtotal - subsidy;

        Bill bill = new Bill();
        bill.setId(id);
        bill.setName(name);
        bill.setType("Residential");
        bill.setUnitsConsumed(unitsConsumed);
        bill.setTotalCost(totalCost);
        bill.addBreakdown("First " + BASIC_RATE_THRESHOLD + " units @ " + BASIC_RATE + "/unit", basicCharge);
        if (unitsConsumed > BASIC_RATE_THRESHOLD) {
            int excessUnits = unitsConsumed - BASIC_RATE_THRESHOLD;
            bill.addBreakdown("Remaining " + excessUnits + " units @ " + EXCESS_RATE + "/unit", excessCharge);
        }
        bill.addBreakdown("Subtotal", subtotal);
        bill.addBreakdown("Subsidy (-10%)", -subsidy);

        return bill;
    }

    @Override
    public String getType() {
        return "Residential";
    }
}

class CommercialCustomer extends Customer {
    private static final double UNIT_RATE = 10.0;
    private static final double SERVICE_CHARGE = 200.0;
    private static final double TAX_PERCENTAGE = 0.05;

    public CommercialCustomer(int id, String name, int unitsConsumed) {
        super(id, name, unitsConsumed);
    }

    @Override
    public Bill calculateBill() {
        double unitCharge = unitsConsumed * UNIT_RATE;
        double subtotal = unitCharge + SERVICE_CHARGE;
        double tax = (unitCharge + SERVICE_CHARGE) * TAX_PERCENTAGE;
        double totalCost = subtotal + tax;

        Bill bill = new Bill();
        bill.setId(id);
        bill.setName(name);
        bill.setType("Commercial");
        bill.setUnitsConsumed(unitsConsumed);
        bill.setTotalCost(totalCost);
        bill.addBreakdown("All units @ " + UNIT_RATE + "/unit", unitCharge);
        bill.addBreakdown("Service Charges", SERVICE_CHARGE);
        bill.addBreakdown("Tax (5%)", tax);

        return bill;
    }

    @Override
    public String getType() {
        return "Commercial";
    }
}

class IndustrialCustomer extends Customer {
    private static final double UNIT_RATE = 12.0;
    private static final double PEAK_HOUR_CHARGE = 300.0;
    private static final double TAX_PERCENTAGE = 0.10;

    public IndustrialCustomer(int id, String name, int unitsConsumed) {
        super(id, name, unitsConsumed);
    }

    @Override
    public Bill calculateBill() {
        double unitCharge = unitsConsumed * UNIT_RATE;
        double subtotal = unitCharge + PEAK_HOUR_CHARGE;
        double tax = (unitCharge + PEAK_HOUR_CHARGE) * TAX_PERCENTAGE;
        double totalCost = subtotal + tax;

        Bill bill = new Bill();
        bill.setId(id);
        bill.setName(name);
        bill.setType("Industrial");
        bill.setUnitsConsumed(unitsConsumed);
        bill.setTotalCost(totalCost);
        bill.addBreakdown("All units @ " + UNIT_RATE + "/unit", unitCharge);
        bill.addBreakdown("Peak Hour Charges", PEAK_HOUR_CHARGE);
        bill.addBreakdown("Tax (10%)", tax);

        return bill;
    }

    @Override
    public String getType() {
        return "Industrial";
    }
}

class Bill {
    private int id;
    private String name;
    private String type;
    private int unitsConsumed;
    private double totalCost;
    private List<String> breakdownLabels;
    private List<Double> breakdownValues;

    public Bill() {
        this.breakdownLabels = new ArrayList<>();
        this.breakdownValues = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUnitsConsumed(int units) {
        this.unitsConsumed = units;
    }

    public void setTotalCost(double cost) {
        this.totalCost = cost;
    }

    public void addBreakdown(String label, double value) {
        breakdownLabels.add(label);
        breakdownValues.add(value);
    }

    public void display() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println();
        System.out.println("--- Bill Breakdown ---");

        for (int i = 0; i < breakdownLabels.size() - 1; i++) {
            System.out.printf("%-30s = %.0f\n", breakdownLabels.get(i), breakdownValues.get(i));
        }

        System.out.println("---------------------------------");
        System.out.printf("%-30s = %.0f PKR\n", "Total Bill", totalCost);
    }

    public double getTotalCost() {
        return totalCost;
    }
}

class BillingSystem {
    private List<Customer> customers;

    public BillingSystem() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void generateAllBills() {
        System.out.println("========== ELECTRICITY BILLING SYSTEM ==========");
        System.out.println();

        for (Customer customer : customers) {
            Bill bill = customer.calculateBill();
            bill.display();
            System.out.println("-----------------------------------------------");
            System.out.println();
        }

        System.out.println("===============================================");
        System.out.println("Summary:");
        System.out.println("Total Customers Processed: " + customers.size());
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillingSystem system = new BillingSystem();

        // Create sample customers
        ResidentialCustomer res = new ResidentialCustomer(101, "Ali Khan", 120);
        CommercialCustomer com = new CommercialCustomer(102, "Sara Ahmed", 120);
        IndustrialCustomer ind = new IndustrialCustomer(103, "Usman Tariq", 120);

        system.addCustomer(res);
        system.addCustomer(com);
        system.addCustomer(ind);

        system.generateAllBills();

        scanner.close();
    }
}
