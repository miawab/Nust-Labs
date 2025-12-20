#include <iostream>
using namespace std;

void print2x3(int arr[2][3]) {
    int *p = (int*)arr;            
    int *end = p + (2 * 3);
    for (; p < end; ++p) {
        cout << *p << ' ';
    }
    cout << '\n';
}

int main() {
    int arr[2][3] = { {1, 2, 3}, {4, 5, 6} };
    print2x3(arr);
    return 0;
}