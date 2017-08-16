package httpBuilder

import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import org.apache.http.entity.mime.MultipartEntityBuilder

/**
 * Created by zhdxu on 2017/8/10.
 */
class HttpBuilderTest {

    // body = ["username":"zdxu", "code":"FREE_10M_TC", "scode":"test726kk203364f04b7f6577", "user_combo_id":"12"]

    static HTTPBuilder http = new HTTPBuilder('http://render.vsochina.com:8472/index.php?r=wsapi/v1/combo/add-user-combo')

    public static void main(String[] args){
//        test()
        testMultipartFormData()
    }

    public static void testMultipartFormData() {
        http.request(Method.POST) { req ->
            def builder = MultipartEntityBuilder.create()
            builder.addTextBody("username", "zdxu")
            builder.addTextBody("code", "FREE_10M_TC")
            builder.addTextBody("scode", "test726kk203364f04b7f6577")
            builder.addTextBody("user_combo_id", "1123")
            req.entity = builder.build()
            response.success = { resp, json ->
                println(json)
            }
            response.failure = {
                resp ->
                    println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                    println resp
            }
        }
    }

    /**
     * httpBuilder 本身不支持 multipart/form-data 传递
     */
    public static void test() {
        http.request(Method.POST) { req ->
            requestContentType = "application/json"
            headers."User-Agent" = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)"
            headers."Content-Type" = "multipart/form-data;"
            body = ["username":"zdxu", "code":"FREE_10M_TC", "scode":"test726kk203364f04b7f6577", "user_combo_id":"1235"]
            response.success = { resp, json ->
                println(json)
            }
            response.failure = {
                resp ->
                    println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                    println resp
            }
        }
    }
}
