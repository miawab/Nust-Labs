#include <iostream>
using namespace std;


int main(){
    int arr1[10];
    int sum = 0;
    for(int i = 0; i <10; i++) {
        cout<<"enter number: ";
        cin>>arr1[i];
        sum += arr1[i];
    }
    int avg = sum/ 10;
    cout<<"average is "<<avg<<endl;
}



