#include "NetworkResponse.h"

using namespace std;

NetworkResponse::NetworkResponse(int resCode, string body) : resCode_(resCode), body_(body) {};

std::string NetworkResponse::toString(){
    return "from MyClass";
}
