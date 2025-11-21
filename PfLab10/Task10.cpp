#include <iostream>
using namespace std;


int main(){
    int arr1[10];
    int large = 0;

    cout<<"enter number: ";
    cin>>arr1[0];

    for(int i = 1; i <10; i++) {
        cout<<"enter number: ";
        cin>>arr1[i];
        if (large < arr1[i])
            large = arr1[i];    
    }

    for (int i = 1; i<10; i++) {
        if(arr1[i] != large)
            continue;
        cout<<large<<" is the largest num and "<<i<<" is it's index\n"<<endl;  
        break;      
    }
}


