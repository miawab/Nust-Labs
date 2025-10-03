#include <iostream>
using namespace std;

int main() {
    int num,d1,d2,d4,d5;
    bool check;
    cout<<"enter a 5 digit number: ";
    cin>>num;
    d5 = num%10;
    d4 = (num/10)%10;
    d2 = (num/1000)%10;
    d1 = (num/10000)%10;
    cout<<num<<" is ";
    cout<<(d5 == d1 && d4 == d2? "a palindrome": "not a palindrome")<<endl;
    return 0;
}