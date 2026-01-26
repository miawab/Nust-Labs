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

    ofstream writefile("text.txt");
    for(i = 0; i<size ;i++){
        writefile<<*(arr+i)<<endl;
    }
    writefile.close();
    delete[] arr;

    string item;

    ifstream readfile("text.txt");
    while(1){
        getline(readfile,item);
        cout<<item<<endl;
        if(item == ""){
            break;
        }
        item = "";
    }


}