#include <iostream>
using namespace std;


int main(){
    int arr1[10];
    int arr2[10];    
    int arr3[10];
    int i3 = 0;

    cout<< "Enter 10 numbers for set 1: ";
    for (int i = 0; i < 10; i++) 
        cin >> arr1[i];
    
    cout << "Enter 10 numbers for set 2: ";
    for (int i = 0; i < 10; i++) 
        cin >> arr2[i];


    for(int i =0;i<10;i++){
        for(int x=0;x<i3+1;x++){
            if(arr1[i]==arr3[x]){
            i++;
            break;
            }
        }
        for(int j=0;j<10;j++){
            if (arr1[i] == arr2[j] ){
                arr3[i3] = arr1[i];
                i3++;
                break;
            }
        }
    }

    for(int x=0;x<i3;x++){
        cout<<arr3[x]<<", ";
    }
    cout<<endl;
}


