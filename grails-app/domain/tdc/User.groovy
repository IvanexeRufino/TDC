package tdc

class User {

    static constraints = {
    }

    private userName
    private password
    private firstName
    private lastName
    private birthday
    private position
    private profilePicture
    private email

    User(userName, password, firstName, lastName, birthday, position, profilePicture, email) {
        this.userName = userName
        this.password = password
        this.firstName = firstName
        this.lastName = lastName
        this.birthday = birthday
        this.position = position
        this.profilePicture = profilePicture
        this.email = email
    }

    def toJson() {
        if (position != null) {
            ["userName": this.userName, "password": this.password, "firstName": this.firstName, "lastName": this.lastName, "birthday": this.birthday, "position": [latitude: this.position.latitude, longitude: this.position.longitude], "profilePicture": this.profilePicture, "email": email]

        } else {
            ["userName": this.userName, "password": this.password, "firstName": this.firstName, "lastName": this.lastName, "birthday": this.birthday, "position": null, "profilePicture": this.profilePicture, "email": email]
        }
    }
}
