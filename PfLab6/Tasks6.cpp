#include <iostream>
using namespace std;

int main() {
    int n,i,j, sum;
    bool prime = 1;
    sum=0;

    cout<<"Input: ";
    cin>>n;

    cout<<"Prime numbers:";

    for (i=2;i<n;i++) {
        prime = 1;

        for(j=2;j<i;j++) {

            if((i%j == 0)) {
                prime = 0;
            }
        }

        if (prime == 1) {
                cout<<i<<", ";
                sum= sum + i;
            }

    }
    cout<<endl<<"sum is: "<<sum<<endl;
}