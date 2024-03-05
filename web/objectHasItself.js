
function ResCode(number){
    this.number = number

    this.resCode = this
}

const SUCCESS = new ResCode(0)
const ERROR = new ResCode(1)

const result = {
    resCode: ERROR,
    message: 'success'
}




console.log(SUCCESS.resCode, result.resCode, SUCCESS.resCode === result.resCode) // true

switch (result.resCode) {
    case SUCCESS.resCode:
        console.log('success from result')
        break
    case ERROR.resCode:
        console.log('error from result')
        break
}

switch (ERROR.resCode) {
    case SUCCESS.resCode:
        console.log('success from SUCCESS')
        break
    case ERROR.resCode:
        console.log('error from SUCCESS')
        break
}