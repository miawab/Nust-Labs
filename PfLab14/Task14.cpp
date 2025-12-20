#include <iostream>
using namespace std;

void inputArrayPointer(int arr[], int size) {
    int *p = arr;
    int *end = arr + size;
    for (; p < end; ++p) {
        cin >> *p;
    }
}

void printArrayPointer(int arr[], int size) {
    int *p = arr;
    int *end = arr + size;
    for (; p < end; ++p) {
        cout << *p << ' ';
    }
    cout << '\n';
}

int main() {
    int arr[10];
    int n = 10;
    cout << "Enter 10 integers:\n";
    inputArrayPointer(arr, n);
    cout << "Array contents: ";
    printArrayPointer(arr, n);
    return 0;
}