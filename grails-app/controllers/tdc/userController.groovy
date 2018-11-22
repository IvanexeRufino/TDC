package tdc

import com.google.gson.Gson
import grails.converters.JSON
import org.grails.web.json.JSONArray

class userController {

    def userService

    def index() {}

    def initialData() {

        userService.loadInitialData()

        def map = [status: 200, message: "Good job"]

        respond map, formats: ['json']
    }

    def add() {

        def user = request.JSON

        userService.addUser(user)

        def map = [status: 200, message: "Good job"]

        respond map, formats: ['json']

    }

    def list() {

        def listJson = userService.getUsers().stream().map({user -> user.toJson()}).collect()

        respond listJson, formats: ['json']
    }

    def getUser() {

        def userName = params.get("userName")

        respond userService.get(userName).toJson(), formats: ['json']
    }
}
