#include <iostream>
using namespace std;
int main(){
    int n;
    cout<<"enter size of matrix: ";
    cin>>n;  
    int arr[10][10];
    
    cout<<"enter elements: "<<endl;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin>>arr[i][j];
        }
    }
    
    bool found = false;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            bool minRow = true;
            bool maxCol = true; 
            for(int k = 0; k < n; k++){
                if(arr[i][k] < arr[i][j]){
                    minRow = false;
                }
            }
            
            for(int k = 0; k < n; k++){
                if(arr[k][j] > arr[i][j]){
                    maxCol = false;
                }
            }
            
            if(minRow && maxCol){
                cout<<"saddle point at row "<<i+1<<" and column "<<j+1<<" = "<<arr[i][j]<<endl;
                found = true;
            }
        }
    }
    
    if(found == false){
        cout<<"No saddle point"<<endl;
    }
    
    return 0;
}