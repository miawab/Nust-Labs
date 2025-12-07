#include <iostream>
using namespace std;
int main(){
    int A[2][3];
    int B[3][2];
    int result[2][2];
    cout<<"enter your 2 by 3 array: "<<endl;
    for(int i =0; i<2; i++){
        for(int j =0; j<3; j++){
            cin>>A[i][j];
        }
    }
    cout<<"enter your 3 by 2 array: "<<endl;
    for(int i =0; i<3; i++){
        for(int j =0; j<2; j++){
            cin>>B[i][j];
        }
    }
    cout<<endl;
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            result[i][j] = 0;
            for(int k = 0; k < 3; k++){
                result[i][j] += A[i][k] * B[k][j];
            }
        }
    }
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            cout<<result[i][j]<<", ";
        }
        cout<<endl;
    }


    return 0;
}
