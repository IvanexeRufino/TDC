package tdc

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/login"(controller: 'user') {
            action = [POST: 'login']
        }

        "/usuario"(controller: 'user') {
            action = [POST: 'add', GET: 'list']
        }

        "/usuario/$userName"(controller: 'user') {
            action = [GET: 'getUser']
        }

        "/loadData"(controller: 'user') {
            action = [GET: 'initialData']
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
