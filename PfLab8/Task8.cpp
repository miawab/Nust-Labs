#include <iostream>
using namespace std;

int square(int a) {
    return a*a;
}
int cube (int a) {
    return a*a*a;
}

int main() {
    int a;
    cout<<"enter a number: ";
    cin>>a;
    cout<<"square of the number= "<<square(a)<<endl;
    cout<<"cube of the number= "<<cube(a)<<endl;
}