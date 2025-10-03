#include <iostream>
using namespace std;

int main() {
    int angle1, angle2, angle3;
    cout<<"enter 3 angles: ";
    cin>>angle1>>angle2>>angle3;
    if (angle1+angle2+angle3 == 180) {
        cout<<"it is a triangle"<<endl;
    } else {
        cout<<"not a triangle"<<endl;
    }

    
    return 0;
}