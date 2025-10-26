#include <iostream>
#include <cmath>
using namespace std;

int reversed (int num) {
    int sum = 0;
    while (num!=0) {
        sum = sum*10 +(num%10);
        num /= 10;
    }
    return sum;

}


int main() {
    int a;
    cout<<"enter a number between 1 and 9999: ";
    cin>>a;
    cout<<reversed(a)<<endl;
}