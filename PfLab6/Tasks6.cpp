#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int n, i ,prod;
    cout<<"enter a number: ";
    cin>>n;
    for(i=0;i<10;i++) {

        prod = n*(i+1);
        cout<<n<<" x "<<i+1<<" = "<<prod<<endl;

        }

    return 0;
}