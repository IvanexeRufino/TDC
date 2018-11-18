package tdc

class userService {

    def users = [:]

    def addUser(user) {

        users[user["username"]] = user
    }

    def getUsers() {
        users.values()
    }

    def get(userName) {
        users[userName]
    }

    def loadInitialData() {
        users["admin"] = new User("admin", "admin", "roberto", "perez")
        users["abc"] = new User("abc", "abc", "juan", "perez")
        users["soso123"] = new User("meme123", "admin", "roberto", "perez")
    }
}
