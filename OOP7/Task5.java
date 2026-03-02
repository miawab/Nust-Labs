import java.util.Scanner;

class Product {
    int productID;
    String name;
    double price;
    int quantity;

    Product(int productID, String name, double price, int quantity){
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double totalValue(){
        return price * quantity;
    }

    void display(){
        System.out.println("ID: " + productID + " | Name: " + name + " | Price: " + price + " | Qty: " + quantity + " | Total Value: " + totalValue());
    }
}

class Inventory {
    Product[] products;
    int count;

    Inventory(int size){
        products = new Product[size];
        count = 0;
    }

    void addProduct(Product p){
        if(count < products.length){
            products[count] = p;
            count++;
        } else {
            System.out.println("Inventory full!");
        }
    }

    Product highestValueProduct(){
        Product highest = products[0];
        for(int i = 1; i < count; i++){
            if(products[i].totalValue() > highest.totalValue())
                highest = products[i];
        }
        return highest;
    }

    double totalInventoryValue(){
        double total = 0;
        for(int i = 0; i < count; i++)
            total += products[i].totalValue();
        return total;
    }

    void generateReport(){
        System.out.println("\n===== INVENTORY REPORT =====");
        for(int i = 0; i < count; i++){
            products[i].display();
        }
        System.out.println("----------------------------");
        System.out.println("Total Inventory Value: " + totalInventoryValue());
        Product h = highestValueProduct();
        System.out.println("Highest Value Product: " + h.name + " (Value: " + h.totalValue() + ")");
        System.out.println("============================");
    }
}

public class Task5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Inventory inv = new Inventory(n);

        for(int i = 0; i < n; i++){
            System.out.println("\n--- Product " + (i+1) + " ---");
            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            inv.addProduct(new Product(id, name, price, qty));
        }

        inv.generateReport();
    }
}
