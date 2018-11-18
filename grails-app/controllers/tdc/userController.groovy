package tdc

import com.google.gson.Gson

class userController {

    def userService

    def index() {}

    def initialData() {

        userService.loadInitialData()
        [data: "i've loaded some users for you to test"]
    }

    def add() {

        def user = request.JSON

        userService.addUser(user)

        [data: "good job"]

    }

    def list() {
        [data: new Gson().toJson(userService.getUsers())]
    }

    def getUser() {

        def userName = params.get("userName")

        [data: new Gson().toJson(userService.get(userName))]
    }
}
