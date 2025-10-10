#include <iostream>
using namespace std;
int main() {
    int lines=10;
    int i=1;
    int x=0;
    while (i<=lines) {
        x=0;
        while (x<i) {
            cout<<"*";
            x++;
        }
        cout<<endl;
        i++;
    }

    cout<<endl;
    i=10;
        while (i>=0) {
        x=0;
        while (x<i) {
            cout<<"*";
            x++;
        }
        cout<<endl;
        i--;
    }


    cout<<endl;
    lines=10;
    i=1;
    x=0;
    while (i<=lines) {
        x=0;
        while (x<i-1) {
            cout<<" ";
            x++;
        }
        x=0;
        while(x<lines-i+1){
            cout<<"*";
            x++;
        }
        cout<<endl;
        i++;

    }

    cout<<endl;
    lines=10;
    i=1;
    x=0;
    while (i<=lines) { 
        x=0;
        while(x<lines-i){
            cout<<" ";
            x++;
        }
        x=0;
        while (x<i) {
            cout<<"*";
            x++;
        }
       
        cout<<endl;
        i++;

    }

    return 0;
}