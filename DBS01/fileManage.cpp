#include <iostream>
#include <fstream>
#include <string>
using namespace std;
int main(){
    int i;
    int intSize;
    int floatSize;
    cout<<"enter int array size: ";
    cin>>intSize;
    cout<<"enter float array size: ";
    cin>>floatSize;

    int* intArr = new int[intSize];
    float* floatArr = new float[floatSize];

    cout<<"int Array:"<<endl;
    for(i = 0;i<intSize;i++){
        cout<<"enter "<<i+1<<"th item of array: ";
        cin>>*(intArr+i);
    }
    cout<<"float Array:"<<endl;
    for(i = 0;i<floatSize;i++){
        cout<<"enter "<<i+1<<"th item of array: ";
        cin>>*(floatArr+i);
    }

    ofstream writefile("text.txt");
    writefile<<intSize<<endl;
    for(i = 0; i<intSize;i++){
        writefile<<*(intArr+i)<<endl;
    }
    writefile<<floatSize<<endl;
    for(i = 0; i<floatSize;i++){
        writefile<<*(floatArr+i)<<endl;
    }
    writefile.close();
    delete[] intArr;
    delete[] floatArr;

    string item;

    ifstream readfile("text.txt");
    int integer;
    float floatnum;

    getline(readfile,item);
    int size = stoi(item);
    int* intArr2 = new int[size];
    for(int i=0;i<size;i++){
        getline(readfile,item);
        integer = stoi(item);
        *(intArr2+i)= integer;
    }
    cout<<"int Array"<<endl;
    for(i = 0;i<size;i++){
        cout<<*(intArr2+i)<<endl;
    }

    getline(readfile,item);
    size = stoi(item);
    float* floatArr2 = new float[floatSize];
    for(int i=0;i<size;i++){
        getline(readfile,item);
        floatnum = stof(item);
        *(floatArr2+i)= floatnum;
    }
    cout<<"int float"<<endl;
    for(i = 0;i<size;i++){
        cout<<*(floatArr2+i)<<endl;
    }
}
