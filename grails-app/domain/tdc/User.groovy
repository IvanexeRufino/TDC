package tdc

class User {

    static constraints = {
    }

    private userName
    private password
    private firstName
    private lastName

    User(userName, password, firstName, lastName) {
        this.userName = userName
        this.password = password
        this.firstName = firstName
        this.lastName = lastName
    }

    def toJson() {
        ["userName": this.userName, "password": this.password, "firstName": this.firstName, "lastName": this.lastName]
    }
}
