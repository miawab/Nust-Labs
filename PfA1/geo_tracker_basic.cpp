#include <iostream>
#include <string>
#include <cmath>
using namespace std;
int main() {
    string name;
    float dist, x1, x2;
    float lon, lat;
    float Llon, Llat;
    bool attendance = 0;
    Llon= 72.990345;
    Llat = 33.645572;

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

    cout<<"you are "<<dist*111<<"km away from landmark."<<endl;

    if (dist<0.5) {
        attendance = 1;
        cout<<"status: present"<<endl;
    } 
    else {
        cout<<"status: absent"<<endl;
    }


    return 0;
}