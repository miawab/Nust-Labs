#include <iostream>
using namespace std;
int main() {
    int num,num2, sum, original, d,dnum,y;
    cout<<"enter a number: ";
    cin>>num;
    original=num;
    sum=0;
    num2= num;
    dnum=0;
    y=0;
    while(num2!=0) {
        num2= num2/10;
        dnum++;
    }
    num2=1;
    while(num!=0) {
        y=0;
        d=num%10;
        num2=1;
        while(y<dnum) {
            num2=num2*d;
            y++;
        }
        sum= sum+(num2);
        num/=10;
    }
    if (original == sum) {
        cout<<"armstrong";
    } else {
        cout<<"no";
    }
    cout<<endl;
    return 0;
}