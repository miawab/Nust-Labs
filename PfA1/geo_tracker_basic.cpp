#include <iostream>
#include <string>
#include <cmath>
using namespace std;
int main() {
    string name;
    float dist, x1, x2;
    float lon, lat;
    float Llon, Llat;
    Llon= 31;
    Llat = 31;

    cout<<"enter first name: ";
    cin>>name;
    cout<<"enter latitude and longitude respectively: ";
    cin>>lat>>lon;
    cout<<endl;

    cout<<name<<endl;
    cout<<"* Landmark is at latitude "<<Llat<<" and longitude "<<Llon<<endl;
    cout<<"* Current Latitude is "<<lat<<" and longitude is "<<lon<<endl<<endl;

    x1 = abs(Llon-lon);
    x2 = 360 -(abs(Llon -lon));
    
    if (x2<x1) {
        x1 = x2;
    } 

    dist = sqrt(pow((Llat-lat), 2) + pow((x1),2));
    cout<<dist<<endl;

    return 0;
}