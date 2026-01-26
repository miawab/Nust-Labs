#include <iostream>
#include <fstream>
#include <string>
using namespace std;
int main(){
    int i, n;
    cout << "Enter number of arrays: ";
    cin >> n;

    ofstream writefile("arrays.bin", ios::binary);

    for(int a = 0; a < n; a++){
        int size;
        cout << "Enter size of array " << a+1 << ": ";
        cin >> size;

        int* arr = new int[size];
        for(i = 0; i < size; i++){
            cout << "Enter " << i+1 << "th item of array " << a+1 << ": ";
            cin >> *(arr+i);
        }

        writefile.write((char*)&size, sizeof(size));
        writefile.write((char*)arr, size * sizeof(int));
        delete[] arr;
    }
    writefile.close();

    ifstream readfile("arrays.bin", ios::binary);
    int arrayCount = 0;
    while(readfile.peek() != EOF){
        int newSize;
        readfile.read((char*)&newSize, sizeof(newSize));
        int* arr2 = new int[newSize];
        readfile.read((char*)arr2, newSize * sizeof(int));

        cout << "Array " << arrayCount+1 << ": " << endl;
        for(i = 0; i < newSize; i++){
            cout << *(arr2 + i) << endl;
        }
        delete[] arr2;
        arrayCount++;
    }
    readfile.close();
}
