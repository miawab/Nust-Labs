#include <iostream>
using namespace std;

int main() {
    int x, y, z, smallest, largest;
    cout<<"input 3 numbers";
    cin>>x>>y>>z;
    largest = x;
    smallest = z;
    if (y>largest) {
        largest = y;
    }
    if (z>largest) {
        largest = z;
    }
    if (y<smallest) {
        smallest = y;
    }
    if (x<smallest) {
        smallest = x;
    }

    cout<<"largest is: "<<largest<<"\nsmallest is:"<<smallest<<endl;

    return 0;
}