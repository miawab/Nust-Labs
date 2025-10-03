#include <iostream>
using namespace std;

int main() {
    char input;
    cout<<"enter a character: ";
    cin>>input;
    if (input >=65 && input <=90){
        cout<<"is a capital letter"<<endl;
    } else if (input >=97 && input <=122) {
        cout<<"is a lower case letter"<<endl;
    } else if (input >=48 && input <=57){
        cout<<"is a number"<<endl;
    } else {
        cout<<"is a special character"<<endl;
    }
    return 0;
}