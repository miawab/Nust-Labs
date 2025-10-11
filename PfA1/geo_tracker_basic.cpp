#include <iostream>
#include <string>
using namespace std;
int main() {
    string name;
    float lon, lat;
    float Llon, Llat;
    Llon= 31.233334;
    Llat = 30.033333;
    cout<<"enter first name: ";
    cin>>name;
    cout<<"enter longitude and latitude respectively: ";
    cin>>lon>>lat;
    cout<<endl;

    cout<<name<<endl;
    cout<<"* Landmark is at latitude "<<Llat<<" and longitude "<<Llon<<endl;
    cout<<"* Current Latitude is "<<lat<<" and longitude is "<<lon<<endl<<endl;
    return 0;
}