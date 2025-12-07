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
    int count = 0;

    for(int i =0; i<5; i++){
        for(int j =0; j<5; j++){
            int num = arr[i][j];
            if(num <= 1) continue;
            bool prime = true;
            for(int k = 2; k*k <= num; k++){
                if(num % k == 0){ prime = false; break; }
            }
            if(prime) count++;
        }
    }

    cout<<"prime count: "<<count<<endl;

    return 0;
}