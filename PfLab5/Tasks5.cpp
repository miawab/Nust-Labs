#include <iostream>
using namespace std;
int main() {
    long long int num;
    cout<<"enter a number: ";
    cin>>num;
    while(num!=0) { 
        if(num%10!=0) {
            cout<<(num%10);
        }
        else {
            cout<<0;
        }
        num=num/10;
    }
    cout<<endl;
    return 0;
}