#include <iostream>
using namespace std;

int main() {
    int n,i;
    int factorial = 1;
    cout<<"enter a number to find it\'s factorial: ";
    cin>>n;

    for(i=0;i<n;i++) {
        factorial= factorial*(i+1);
    }
    cout<<factorial<<endl;
}
