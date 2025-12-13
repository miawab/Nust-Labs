#include <iostream>
using namespace std;

int main(){

    struct student {
        char name[20];
        int rollNo;
        float marks1;
        float marks2;
        float marks3;
        float total;
        float percentage;
    };

    int N = 5;
    student s[N];
    int highest = 0;
    int* phighest = &highest;

    for (int i = 0; i < N; i++) {
        cout << "Enter name: ";
        cin>>s[i].name;
        cout << "Enter roll no: ";
        cin >> s[i].rollNo;
        cout << "Enter marks for subject 1: ";
        cin >> s[i].marks1;
        cout << "Enter marks for subject 2: ";
        cin >> s[i].marks2;
        cout << "Enter marks for subject 3: ";
        cin >> s[i].marks3;

        s[i].total = s[i].marks1 + s[i].marks2 + s[i].marks3;
        s[i].percentage = s[i].total / 3.0;

        if(s[i].percentage > s[highest].percentage) {
            *phighest = i;
        }

        cout << endl;
    }
    cout<<"Student with highest percentage is "<<s[highest].name;
    cout<<"("<<s[highest].percentage<<")"<<endl;
    return 0;
}