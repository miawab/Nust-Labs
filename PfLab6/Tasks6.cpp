#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int d,n,num,temp, power;

    cout<<"input: ";
    cin>>n;
    num = n;
    cout<<"output: ";

    for(d=0;n>0;d++) {
        n /= 10;
    }

    for(;d>0;d--) {

        temp = num/10 ;
        power = pow(10,d-1);
        switch ((num/power)%10) {
            case 0:
            cout<<"zero, ";
            break;

            case 1: 
            cout<<"one, ";
            break;

            case 2: 
            cout<<"two, ";
            break;

            case 3: 
            cout<<"three, ";
            break;

            case 4: 
            cout<<"four, ";
            break;

            case 5: 
            cout<<"five, ";
            break;

            case 6: 
            cout<<"six, ";
            break;

            case 7: 
            cout<<"seven, ";
            break;

            case 8: 
            cout<<"eight, ";
            break;

            case 9: 
            cout<<"nine, ";
            break;
        }

    }
    cout<<endl;

    return 0;
}