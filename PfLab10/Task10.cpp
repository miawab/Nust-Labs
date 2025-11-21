#include <iostream>
using namespace std;

int main() {
    int arr1[20];
    int arr2[20];
    int x = 0;

    cout << "Enter 20 numbers for array: ";
    for (int i = 0; i < 20; i++) {
        cin >> arr1[i];
        bool isDuplicate = false;

        for (int j = 0; j < x; j++) {
            if (arr2[j] == arr1[i]) {
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            arr2[x] = arr1[i];
            x++;
        }
    }
    for (int j = 0; j < x; j++) {
        cout << arr2[j] << ", ";
    }
    cout<<endl;
}