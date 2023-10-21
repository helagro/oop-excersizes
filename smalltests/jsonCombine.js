
const data = {
    name: "John",
    age: 30,
}

const links = {
    _self: "http://localhost:3000/api/users/1",
}

const res = {
    ...data,
    links: links
}

console.log(res)