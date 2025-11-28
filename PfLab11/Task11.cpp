#include <iostream>
using namespace std;

double det2(int arr[3][3], int skip_row, int skip_col){
    double vals[4];
    int idx = 0;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(i==skip_row || j==skip_col) continue;
            vals[idx++] = arr[i][j];
        }
    }
    return vals[0]*vals[3] - vals[1]*vals[2];
}

double det3(int arr[3][3]){
    double det = 0;
    for(int j=0;j<3;j++){
        int sign = (j % 2 == 0) ? 1 : -1;
        det += sign * arr[0][j] * det2(arr, 0, j);
    }
    return det;
}

int main(){
    int arr[3][3];

    cout << "Enter a 3x3 matrix, row by row (9 integers):" << endl;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cin >> arr[i][j];
        }
    }

    cout << "\nOriginal matrix:\n";
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cout << arr[i][j] << " ";
        }
        cout << '\n';
    }

    double det = det3(arr);
    if(det == 0){
        cout << "\nDeterminant is 0. Matrix is singular and not invertible.\n";
        return 0;
    }

    double adj[3][3];
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            int sign = ((i + j) % 2 == 0) ? 1 : -1;
            double cof = sign * det2(arr, i, j);
            adj[j][i] = cof; // transpose to get adjugate
        }
    }

    double inv[3][3];
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            inv[i][j] = adj[i][j] / det;
        }
    }

    cout << "\nInverse matrix:\n";
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cout << inv[i][j] << " ";
        }
        cout << '\n';
    }

    return 0;
}