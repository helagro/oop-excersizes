#include "cpp-httplib/httplib.h"
#include "NetworkResponse.h"
#include "NetworkHandler.h"

NetworkResponse* downloadWebsite(){
    httplib::Client cli("http://google.com");

    auto res = cli.Get("/");
    if (res) {

        NetworkResponse response(
            res->status,
            res->body
        );
        
        return &response;
    } else {
        std::cerr << "Error: " << res.error() << std::endl;
    }

    return nullptr;
}