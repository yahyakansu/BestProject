package apitests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Config;

public class AgentAPI {
    /**
     * This test written by Junit
     * It shows us Agent which include in 2021
     * It count agents size
     */
    @Test
    public void findAgent(){
        Response response = RestAssured.get(Config.getProperties("AgentAPI"));
        JsonPath jsonPath = response.jsonPath();
        int size = jsonPath.getList("agents").size();
        int count=0;

        for (int i=0 ; i<size ; i++){
            String joinDate = jsonPath.getString("agents["+i+"].joinDate");
            if (joinDate==null)continue;
            if (joinDate.endsWith("2021")){
                count++;
            }
        }
        System.out.println("Count: "+count);
    }
}
