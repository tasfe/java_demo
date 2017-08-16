package closure

/**
 * Created by zhdxu on 2017/8/16.
 */
class Test {

    static void main(String[] args) {
        new ClosureDemo().println("success"){ value ->
            println(value)
            name = "success"
            result.success = { resp, json ->
                println(resp)
                println(json)
            }
            result.fail = { resp ->
                println(resp)
            }
        }



        new ClosureDemo().println("fail"){ value ->
            println(value)
            name = "fail"
            result.success = { resp, json ->
                println(resp)
                println(json)
            }
            result.fail = { resp ->
                println(resp)
            }
        }
    }
}
