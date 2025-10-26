#include <iostream>
#include <cmath>
using namespace std;

float hypotenuse (float side1, float side2) {

    side1 = (pow(side1,2) + pow(side2,2));
    side1 = sqrt(side1);

    return side1;
}


int main() {
    float a; float b;
    cout<<"enter 2 sides of a triangle: ";
    cin>>a>>b;
    cout<<hypotenuse(a,b)<<endl;
}