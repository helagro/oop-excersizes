#include "NetworkResponse.h"
#include <string>
#include <sstream> 
#include <iostream>

using namespace std;

NetworkResponse::NetworkResponse(int resCode, string body) : resCode_(resCode), body_(body) {};

std::string NetworkResponse::toString(){
    std::ostringstream oss;
    oss << "CODE: " << resCode_ << " \nBODY: " << body_;
    return oss.str();
}
