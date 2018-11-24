package tdc

class User {

    static constraints = {
    }

    private userName
    private password
    private firstName
    private lastName
    private profilePicture

    User(userName, password, firstName, lastName, profilePicture) {
        this.userName = userName
        this.password = password
        this.firstName = firstName
        this.lastName = lastName
        this.profilePicture = profilePicture
    }

    def toJson() {
        ["userName": this.userName, "password": this.password, "firstName": this.firstName, "lastName": this.lastName, "profilePicture": this.profilePicture]
    }
}
