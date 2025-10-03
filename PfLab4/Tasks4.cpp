#include <iostream>
using namespace std;

int main() {
    int year;
    bool leap = 0;
    cout<<"input year: ";
    cin>>year;
    if (year%4 == 0) {
        leap = 1;
        if (year%100 == 0) {
            leap = 0;
        }
    }
    if (leap == 1) {
        cout<<"is leap"<<endl;
    } else {
        cout<<"not leap"<<endl;
    }
    

    return 0;
}