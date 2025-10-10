#include <iostream>
using namespace std;
int main() {
    int fixednum, guess;
    fixednum = 7;
    guess=0;
    do {
        cout<<"Guess the number: ";
        cin>>guess;
        if (fixednum!=guess) {
            cout<<"Try again"<<endl;
        }
    } while (fixednum!=guess);
    cout<<"Correct, you win"<<endl;
    return 0;
}