#include <iostream>
using namespace std;

int gcd (int num1, int num2) {
    for (int i=num1; i>=2; i--) {
        if (num1%i == 0 && num2%i == 0) {
            return i;
        }
    }
    return 0;
}


int main() {
    int a, b;
    cout<<"enter two digits: ";
    cin>>a>>b;
    cout<<gcd(a,b)<<endl;
    
}