// ...existing code...
#include <iostream>
#include <iomanip>
using namespace std;

int det2(int arr[3][3], int skip_row,int skip_col){
    int vals[4];
    int idx=0;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(i==skip_row || j==skip_col) continue;
            vals[idx++] = arr[i][j];
        }
    }
    return vals[0]*vals[3] - vals[1]*vals[2];
}

int det3(int arr[3][3]){
    int det = 0;
    for(int j=0;j<3;j++){
        int sign = (j % 2 == 0) ? 1 : -1;
        det += sign * arr[0][j] * det2(arr, 0, j);
    }
    return det;
}

int main(){
    int arr[3][3];

    cout << "enter line by line, a 3x3 matrix: " << endl;
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            cin >> arr[i][j];
        }
    }

    cout << "\nOriginal matrix:\n";
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }

    int det = det3(arr);
    if(det == 0){
        cout << "\nDeterminant is 0. Matrix is singular and not invertible.\n";
        return 0;
    }

    double adj[3][3];
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            int sign = ((i + j) % 2 == 0) ? 1 : -1;
            int cof = sign * det2(arr, i, j);
            adj[j][i] = cof; 
        }
    }

    double inv[3][3];
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            inv[i][j] = adj[i][j] / static_cast<double>(det);
        }
    }

    cout << "\nInverse matrix:\n";
    cout << fixed << setprecision(4);
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cout << inv[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}
