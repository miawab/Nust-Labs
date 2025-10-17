#include <iostream>
using namespace std;

int main() {
    int i;
    for(i=1;i<300000001;i++) {

        if(i%100000000 == 0) {
            cout<<i/100000000<<endl;
        }

    }
}
//2.30 seconds to count till 300,000,000