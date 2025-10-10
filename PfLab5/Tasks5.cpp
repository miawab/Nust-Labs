#include <iostream>
using namespace std;
int main() {
    int y;
    do {
        cout<<endl;
        cout<<"Choose an option\n"<<endl;
        cout<<"1.Add\n2.Subrtract\n3.Multiply\n0.Exit"<<endl;
        cout<<endl<<"option: ";
        cin>>y;
    } while (y!=0);
    
    return 0;
}