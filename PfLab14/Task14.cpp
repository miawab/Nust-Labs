#include <iostream>
using namespace std;

void reverseUsingPointers(int arr[], int size) {
    int *start = arr;
    int *end = arr + size - 1;
    while (start < end) {
        int temp = *start;
        *start = *end;
        *end = temp;
        start++;
        end--;
    }}

int main() {
    const int n = 10;
    int arr[n];
    cout << "Enter 10 integers:\n";
    int *p = arr;
    int *end = arr + n;
    for (; p < end; ++p) {
        cin >> *p;
    }
    reverseUsingPointers(arr,n);
    cout << "After reverse: ";
    p = arr;
    for (; p < end; ++p) cout << *p << ' ';
    cout << '\n';
    return 0;
}