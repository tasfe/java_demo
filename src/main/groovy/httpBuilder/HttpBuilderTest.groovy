package httpBuilder

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

        http.request(Method.POST) { req ->
            //requestContentType: "multipart/form-data"
            def builder = MultipartEntityBuilder.create()
            builder.addTextBody("username", "zdxu")
            builder.addTextBody("code", "FREE_10M_TC")
            builder.addTextBody("scode", "test726kk203364f04b7f6577")
            builder.addTextBody("user_combo_id", "23")
            req.entity = builder.build()
//            entity.
//            builder.
//            FormBodyPart
//            ContentBody
//            MultipartCont
//            StringBody
//            MultipartEntity multiPartContent = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE)
//
//            // Adding Multi-part file parameter "imageFile"
//
//            multiPartContent.addPart("imageFile", new InputStreamBody(multipartImageFile.inputStream, multipartImageFile.contentType, multipartImageFile.originalFilename))
//
//            // Adding another string parameter "city"
//
//            multiPartContent.addPart("city", new StringBody(cityName))
//            headers.Accept = 'multipart/form-data'
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


//    request( POST, JSON ) {
//
//
//        //headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
//        response.success = { resp, json ->
//            println(json)
//        }
//        response.failure = {
//            resp ->
//                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
//                println resp
//        }
//    }
}
