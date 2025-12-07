#include <iostream>
using namespace std;
int main(){
    int arr[5][5];
    cout<<"enter your 5 by 5 array: ";
    for(int i =0; i<5; i++){
        for(int j =0; j<5; j++){
            cin>>arr[i][j];
        }
    }

    int check;
    cout<<"enter a number to check in array: ";
    cin>>check;

    for(int i =0; i<5; i++){
        for(int j =0; j<5; j++){
            if(check == arr[i][j]) {
                cout<<"row is "<<i<<" and column is "<<j<<endl;
                break;
            }
        }
    }
    cout<<"no more found"<<endl;

    return 0;
}
