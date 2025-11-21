#include <iostream>
#include <cctype>
using namespace std;

int main() {
    char arr[10];

    cout << "Enter 10 characters:\n";
    for (int i = 0; i < 10; i++) {
        cin >> arr[i];
    }

    int lowerCount = 0;
    int upperCount = 0;
    int digitCount = 0;
    int specialCount = 0;

    for (int i = 0; i < 10; i++) {
        if (islower(arr[i])) {
            lowerCount++;
        }
        else if (isupper(arr[i])) {
            upperCount++;
        }
        else if (isdigit(arr[i])) {
            digitCount++;
        }
        else {
            specialCount++;
        }
    }

    cout << "\nLowercase: " << lowerCount << endl;
    cout << "Uppercase: " << upperCount << endl;
    cout << "Digits: " << digitCount << endl;
    cout << "Special: " << specialCount << endl;

    return 0;
}