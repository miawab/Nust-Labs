#include <iostream>
using namespace std;

int main(){

    struct product {
        int productID;
        char productName[30];
        float price;
        int quantity;
        float totalValue;
    };

    int maxPrice = 0;
    int maxValue = 0;
    int N = 4;
    product p[N];
    

    for (int i = 0; i < N; i++) {
        cout << "Enter productID: ";
        cin >> p[i].productID;
        cout << "Enter product name: ";
        cin >> p[i].productName;
        cout << "Enter price: ";
        cin >> p[i].price;
        cout << "Enter quantity: ";
        cin >> p[i].quantity;

        p[i].totalValue = p[i].price * p[i].quantity;

        if (p[i].price > p[maxPrice].price){ 
            maxPrice = i;
        }
        if (p[i].totalValue > p[maxValue].totalValue){
            maxValue = i;
        }

        cout << endl;
    }

    cout << "ID\tName\t\tPrice\tQty\tTotal Value\n";
    cout << "--------------------------------------------------------\n";

    for (int i = 0; i < N; ++i) {
        cout << p[i].productID << "\t"
             << p[i].productName << "\t\t"
             << p[i].price << "\t"
             << p[i].quantity << "\t"
             << p[i].totalValue << "\n";
    }

    cout << "\nMost expensive product: " << p[maxPrice].productName
         << " (ID: " << p[maxPrice].productID << ", Price: " << p[maxPrice].price << ")\n";

    cout << "Product with largest stock value: " << p[maxValue].productName
         << " (ID: " << p[maxValue].productID << ", Total Value: " << p[maxValue].totalValue << ")\n";

    return 0;
}
