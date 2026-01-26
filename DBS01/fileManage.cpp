#include <iostream>
#include <fstream>
#include <string>
using namespace std;
int main(){
    int i;
    int size;
    cout<<"enter array size: ";
    cin>>size;

    int* arr = new int[size];

    for(i = 0;i<size;i++){
        cout<<"enter "<<i+1<<"th item of array: ";
        cin>>*(arr+i);
    }

    ofstream writefile("array.bin", ios::binary);
    writefile.write((char*)&size, sizeof(size));
    writefile.write((char*)arr, size * sizeof(int));
    writefile.close();
    delete[] arr;

    string item;

    ifstream readfile("array.bin", ios::binary);

    int newSize;
    readfile.read((char*)&newSize, sizeof(newSize));

    int* arr2 = new int[newSize];
    readfile.read((char*)arr2, newSize * sizeof(int));
    readfile.close();

    cout << "Array: "<<endl;
    for(i = 0; i < newSize; i++){
        cout << *(arr2 + i) << endl;
    }
    delete[] arr2;
}
