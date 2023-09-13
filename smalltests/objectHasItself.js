
function ResCode(number){
    this.number = number

    this.resCode = this
}

const SUCCESS = new ResCode(0)

const result = {
    resCode: SUCCESS,
    message: 'success'
}

console.log(SUCCESS.resCode, result.resCode, SUCCESS.resCode === result.resCode) // true