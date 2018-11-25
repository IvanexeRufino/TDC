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

        def map
        def user = request.JSON

        def valid = userService.addUser(user)

        if (valid) {
            map = [status: 200, message: "Good job"]
        } else {
            map = [status: 400, message: "user already exists"]
        }

        respond map, formats: ['json']

    }

    def modify() {

        def user = request.JSON

        userService.modifyUser(user)

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

    def login() {

        def map
        def user = request.JSON
        def valid = userService.validateLogin(user)

        if (valid) {
            map = [status: 200, message: "Authenticated"]
            respond map, formats: ['json']

        } else {
            map = [status: 400, message: "Not authenticated"]
            respond map, formats: ['json']
        }
    }

    def updatePassword() {

        def map
        def userData = request.JSON
        def valid = userService.updatePassword(userData)

        if (valid) {
            map = [status: 200, message: "Succesfuly changed"]
            respond map, formats: ['json']

        } else {
            map = [status: 400, message: "Wron password"]
            respond map, formats: ['json']
        }


    }
}
