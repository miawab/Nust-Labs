#include <iostream>
using namespace std;

int main() {
    int length, width, area, perimeter;
    cout<<"enter length and width: ";
    cin>>length>>width;
    area = length*width;
    perimeter = 2*(length + width) ;
    if (area>length) {
        cout<<"area > length"<<endl;
    } else {
        cout<<"area < length"<<endl;
    }
    return 0;
}