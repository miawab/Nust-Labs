#include <iostream>
using namespace std;

float area(float r);

int main(){  
    float radius;
    cout<<"Enter the radius : ";
    cin>>radius;
    area(radius);
    cout<<"Area of Circle = "<<area(radius)<<endl;
    return 0;
}

float area(float r) {
    return 3.14 * r * r;
}