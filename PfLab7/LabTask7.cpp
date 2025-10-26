#include <iostream>
using namespace std;

void printsquare (int side, char fill) {

    for(int i=0;i<side; i++) {
        for(int j=0; j<side; j++) {
            cout<<fill;
        }
        cout<<endl;
    }
}


int main() {
    int a; char b;
    cout<<"enter a number: ";cin>>a;
    cout<<"enter a character: ";cin>>b;
    printsquare(a,b);
    return 0;
}