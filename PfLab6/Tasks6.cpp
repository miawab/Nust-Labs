#include <iostream>
using namespace std;

int main() {
    int n, i, j;
    cout<<"enter number of rows: ";
    cin>>n;

    for (i=0;i<n;i++) {

        for (j=n-i;j>1;j--) {
            cout<<" ";
        }

        for (j=0;j<i+1;j++) {
            cout<<j+1;
        }

        for (j=i;j>0;j--) {
            cout<<j;
        }
        cout<<endl;
    }

    return 0;
}