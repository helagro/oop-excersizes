#pragma once

#include <string>

class NetworkResponse {
public:
    NetworkResponse(int resCode, std::string body);
    std::string toString();

private:
    int resCode_;
    std::string body_;
};