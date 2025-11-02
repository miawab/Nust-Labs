#include <iostream>
using namespace std;

int multiply(int a=1,int b=1,int c=1,int d=1,int e=1) {
    return a*b*c*d*e;
}

int main() {
    int num,a,b,c,d,e;
    cout<<"enter the amount of numbers to mulitply (2-5): ";
    cin>>num;

    cout<<"enter your numbers: ";
    switch (num){
        case 2:
            cin>>a>>b;
            cout<<"ANS: "<<multiply(a,b)<<endl;
            break;
        case 3:
            cin>>a>>b>>c;
            cout<<"ANS: "<<multiply(a,b,c)<<endl;
            break;
        case 4:
            cin>>a>>b>>c>>d;
            cout<<"ANS: "<<multiply(a,b,c,d)<<endl;
            break;
        case 5:
            cin>>a>>b>>c>>d>>e;
            cout<<"ANS: "<<multiply(a,b,c,d,e)<<endl;
            break;
        default:
            cout<<"ERROR! run the command again"<<endl;

    }


    return 0;
}