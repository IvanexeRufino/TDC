package tdc

import com.google.gson.Gson
import grails.converters.JSON
import org.grails.web.json.JSONArray

class userController {

    def userService

    def index() {}

    def initialData() {

        userService.loadInitialData()
        render "i've loaded data succesfuly"
    }

    def add() {

        def user = request.JSON

        userService.addUser(user)

        render(contentType: "text/json"){
            [data: "good job"]
        }

    }

    def list() {

        def listJson = userService.getUsers().stream().map({user -> new Gson().toJson(user)}).collect()

        render listJson as JSON
    }

    def getUser() {

        def userName = params.get("userName")

        render(contentType: "text/json") {
            userService.get(userName)
        }
    }
}
