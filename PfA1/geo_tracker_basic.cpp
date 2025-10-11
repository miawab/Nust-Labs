#include <iostream>
#include <string>
#include <cmath>
using namespace std;
int main() {
    int p, a;
    string name, status;
    string yesno, data;
    float dist, x1, x2;
    float lon, lat;
    float Llon, Llat;
    bool attendance, cont;

    Llon= 72.990345;
    Llat = 33.645572;
    attendance = 0;
    a=0;
    p=0;

    do {
        cout<<"----------------------------------------------------------"<<endl;
        cout<<"enter name: ";
        getline(cin, name);
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
            status= "present";
            p++;
        } 
        else {
            status= "absent";
            a++;
        }
        cout<<"status: "<<status<<endl<<endl;
        cout<<"continue? y/n"<<endl;
        cin>>yesno;

        if (yesno == "y" || yesno == "Y") {
            cont= 1;
        } else {
            cont= 0;
        }
        data += "name: " + name + ", status: " + status + "\n";
        cin.ignore();
    } while (cont == 1 );

    cout<<endl<<"user info\n**********************************************************"<<endl<<data;
    cout<<"total present: "<<p<<endl<<"total absent: "<<a<<endl<<endl;

    return 0;
}   