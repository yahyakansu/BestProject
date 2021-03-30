package utilities;

import apimodels.RequestBody;
import apimodels.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIUtil {
    private static ResponseBody responseBody;

    /**
     * GET some values from api data
     * @param resource
     */
    public static void hitGET(String resource) {
        String uri = Config.getProperties("baseURL") + resource;
        Response response = RestAssured.get(uri);

        System.out.println(response.asString());
        System.out.println("STATUS CODE: " + response.statusCode());

        /**
         * ObjectMapper very important to convert between Api values and java object values
         */
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        }
        catch (Exception j){
            j.printStackTrace();
        }
    }

    public static ResponseBody getResponseBody(){
        return responseBody;
    }

    /**
     * POST means that create new values to the api data
     * @param resource
     * @param body
     */
    public static void hitPOST(String resource, RequestBody body){
        String uri = Config.getProperties("baseURL") + resource;

        ObjectMapper objectMapper = new ObjectMapper();
        String bodyJSON = "";
        try {
            bodyJSON = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Response response = RestAssured.given().contentType(ContentType.JSON).body(bodyJSON).when().post(uri);

        System.out.println(response.asString());
        System.out.println("STATUS CODE: " + response.statusCode());

        try{
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        }
        catch (Exception j){
            j.printStackTrace();
        }
    }

    /**
     * DELETE some values from api data
     * @param resource
     */
    public static void hitDELETE(String resource){
        String uri = Config.getProperties("baseURL") + resource;

        Response response = RestAssured.delete(uri);

        System.out.println(response.asString());
        System.out.println("STATUS CODE: " + response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        }
        catch (Exception j){
            System.err.println("WARNING!\nResponse couldn't map properly with Jackson Library");
        }

    }

    /**
     * PUT means that change some values in the api data
     * @param resource
     * @param body
     */
    public static void hitPUT(String resource, RequestBody body){
        String uri = Config.getProperties("baseURL") + resource;

        ObjectMapper objectMapper = new ObjectMapper();

        String bodyJson = "";
        try{
            bodyJson = objectMapper.writeValueAsString(body);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Response response = RestAssured.given().contentType(ContentType.JSON).body(bodyJson).when().put(uri);

        System.out.println(response.asString());
        System.out.println("STATUS CODE: " + response.statusCode());

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
