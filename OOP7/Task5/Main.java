class Product {
int productID;
String name;
double price;
int quantity;

Product(int productID,String name,double price,int quantity){
this.productID=productID;
this.name=name;
this.price=price;
this.quantity=quantity;
}

double totalValue(){
return price*quantity;
}

void display(){
System.out.println("ID: "+productID+" | Name: "+name+" | Price: "+price+" | Qty: "+quantity+" | Total Value: "+totalValue());
}
}

class Inventory {
Product[] products;
int count;

Inventory(int size){
products=new Product[size];
count=0;
}

void addProduct(Product p){
if(count<products.length){
products[count]=p;
count++;
}else
System.out.println("Inventory full!");
}

Product highestValueProduct(){
Product highest=products[0];
for(int i=1;i<count;i++){
if(products[i].totalValue()>highest.totalValue())
highest=products[i];
}
return highest;
}

double totalInventoryValue(){
double total=0;
for(int i=0;i<count;i++)
total+=products[i].totalValue();
return total;
}

void generateReport(){
System.out.println("===== INVENTORY REPORT =====");
for(int i=0;i<count;i++){
products[i].display();
}
System.out.println("----------------------------");
System.out.println("Total Inventory Value: "+totalInventoryValue());
Product h=highestValueProduct();
System.out.println("Highest Value Product: "+h.name+" (Value: "+h.totalValue()+")");
System.out.println("============================");
}
}

public class Main {
public static void main(String[] args){
Inventory inv = new Inventory(5);

inv.addProduct(new Product(1,"Laptop",75000,10));
inv.addProduct(new Product(2,"Mouse",1500,50));
inv.addProduct(new Product(3,"Keyboard",3500,30));
inv.addProduct(new Product(4,"Monitor",45000,15));
inv.addProduct(new Product(5,"Headphones",5000,25));

inv.generateReport();
}
}
