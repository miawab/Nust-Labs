#include <iostream>
using namespace std;

int main(){
    int arr[10];

    cout << "Enter 10 integers: ";
    for(int i = 0; i < 10; i++) cin >> arr[i];

    cout << "\nData items in original order\n";
    for(int i = 0; i < 10; i++) cout << arr[i] << " ";
    cout << "\n\n";

    for(int pass = 0; pass < 9; pass++){
        bool swapped = false; //b
        for(int j = 0; j < 9 - pass; j++){ //a
            if(arr[j] > arr[j+1]){ 
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
                swapped = true;
            }
        }

        cout << "After Pass " << (pass + 1) << ": ";
        for(int i = 0; i < 10; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";

        if(!swapped) break;
    }

    cout << "\nData items"<<endl;
    for(int i = 0; i < 10; i++) cout << arr[i] << " ";
    cout << endl;

    return 0;
}