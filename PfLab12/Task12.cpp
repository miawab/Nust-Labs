#include <iostream>
using namespace std;

int main() {
    int arr1[25], arr2[5][5];
    cout << "Enter 25 elements:" << endl;
    for (int i = 0; i < 25; i++) cin >> arr1[i];
    int i = 0;
    int top = 0, bottom = 4, left = 0, right = 4;
    while (top<=bottom && left<= right) {
        for (int j=left;j<=right;j++) arr2[top][j] = arr1[i++];
        top++;
        for (int j = top; j <= bottom; j++) arr2[j][right] = arr1[i++];
        right--;
        if (top <= bottom) {
            for (int j=right; j>=left; j--) arr2[bottom][j] = arr1[i++];
            bottom--;
        }
        if (left <= right) {
            for (int j=bottom;j>=top;j--) arr2[j][left] = arr1[i++];
            left++;
        }
    }
    cout <<endl<<"Spiral form:"<<endl;
    for (int i2 = 0; i2 < 5; i2++) {
        for (int j = 0; j < 5; j++) cout << arr2[i2][j] << " ";
        cout << endl;
    }

    return 0;
}