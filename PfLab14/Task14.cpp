#include <iostream>
using namespace std;

void displayWithPointers(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        int *p = arr + i; 
        cout <<"Element "<<i<< ": "<<*p<< " AND Address: "<< p << '\n';
    }
}
int main() {
    int arr[] = {10, 20, 30, 40, 50};
    int n = sizeof(arr) / sizeof(arr[0]);
    displayWithPointers(arr, n);

    return 0;
}