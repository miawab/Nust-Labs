#include <iostream>
using namespace std;

bool is_prime (int num) {
    for (int i=2; i<num ; i++){
        if (num%i == 0) {
            return 0;
        }
    }
    return 1;
}


int main() {
    for (int i=2; i<1000; i++) {
        if (is_prime(i) == 1) {
            cout<<i<<", ";
        }
    }
}