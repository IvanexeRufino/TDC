package tdc

class User {

    static constraints = {
    }

    private userName
    private password
    private firstName
    private lastName
    private position
    private profilePicture

    User(userName, password, firstName, lastName, position, profilePicture) {
        this.userName = userName
        this.password = password
        this.firstName = firstName
        this.lastName = lastName
        this.position = position
        this.profilePicture = profilePicture
    }

    def toJson() {
        if (position != null) {
            ["userName": this.userName, "password": this.password, "firstName": this.firstName, "lastName": this.lastName, "position": [latitude: this.position.latitude, longitude: this.position.longitude], "profilePicture": this.profilePicture]

        } else {
            ["userName": this.userName, "password": this.password, "firstName": this.firstName, "lastName": this.lastName, "position": null, "profilePicture": this.profilePicture]
        }
    }
}
