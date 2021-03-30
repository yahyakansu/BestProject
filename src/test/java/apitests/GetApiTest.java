package apitests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Config;

public class GetApiTest {

    /**
     * to get agent info from api data
     */
    @Test
    public void getAgent(){
        Response response = RestAssured.get(Config.getProperties("getApiAgent"));
        System.out.println(response.statusCode());
        System.out.println(response.asString());

        JsonPath jp = response.jsonPath();
        String firstName = jp.get("agent[0].firstName");
        System.out.println(firstName);

        Assert.assertTrue(firstName!=null);
    }

    /**
     * Automate all agents and make sure that firstName and email is coming in the response without failure
     */
    @Test
    public void allTeachersTest(){
        Response response = RestAssured.get(Config.getProperties("getAllAgents"));
//        System.out.println(response.asString());
        Assert.assertEquals("API service down",200,response.statusCode());

        JsonPath jp = response.jsonPath();
        int listSize = jp.getList("agents").size();

        for (int i=0;i<listSize;i++){
            String name = jp.get("agents["+i+"].firstName");
            String email = jp.get("agents["+i+"].emailAddress");
            Assert.assertTrue(name!=null);
            Assert.assertTrue(email!=null);
        }
    }

}
