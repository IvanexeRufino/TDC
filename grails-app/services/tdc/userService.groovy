package tdc

import com.google.gson.Gson

class userService {

    def users = [:]

    def addUser(user) {

        users[user["userName"]] = new Gson().fromJson(user.toString(), User.class)
    }

    def getUsers() {
        users.values()
    }

    def get(userName) {
        users[userName]
    }

    def modifyUser(user) {
        def userToModify = users[user.userName]
        userToModify.firstName = user.firstName
        userToModify.lastName = user.lastName
        userToModify.profilePicture = user.profilePicture
        users[user.userName] = userToModify

    }

    def loadInitialData() {
        users["admin"] = new User("admin", "admin", "roberto", "perez",null)
        users["abc"] = new User("abc", "abc", "juan", "perez",null)
        users["soso123"] = new User("meme123", "admin", "roberto", "perez", null)
    }

    def validateLogin(user) {
        if(users.containsKey(user.userName)) {
            if(users[user.userName].password == user.password) {
                return true
            }
        }

        return false
    }

    def updatePassword(userData) {

        if(users.containsKey(userData.userName)) {
            if(users[userData.userName].password == userData.oldPassword) {
                users[userData.userName].password = userData.newPassword
                return true
            }
        }

        return false
    }
}
