#include <iostream>
#include "NetworkResponse.h"
#include "NetworkHandler.h"
using namespace std;

int main(){
    NetworkResponse* responsePtr = downloadWebsite();
    if(responsePtr != nullptr){
        NetworkResponse response = *responsePtr;
        cout << response.toString();
    }

    return 0;
}