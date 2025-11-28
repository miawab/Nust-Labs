#include <iostream>
using namespace std;

int main(){
    int A[3][3], B[3][3], C[3][3];

    cout << "Enter first 3x3 matrix (9 integers), row by row:\n";
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cin >> A[i][j];
        }
    }

    cout << "Enter second 3x3 matrix (9 integers), row by row:\n";
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cin >> B[i][j];
        }
    }

    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            C[i][j] = 0;
            for(int k=0;k<3;k++){
                C[i][j] += A[i][k] * B[k][j];
            }
        }
    }

    cout << "\nFirst matrix:\n";
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++) cout << A[i][j] << " ";
        cout << '\n';
    }

    cout << "\nSecond matrix:\n";
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++) cout << B[i][j] << " ";
        cout << '\n';
    }

    cout << "\nProduct matrix:\n";
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++) cout << C[i][j] << " ";
        cout << '\n';
    }

    return 0;
}