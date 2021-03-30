package apitests.pojo;

import apimodels.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Config;

public class JsonToJavaObject {
    @Test
    public void subAgentGet() throws Exception{
        String uri = Config.getProperties("baseURL")+"/subagent";
        Response response = RestAssured.get(uri);
        System.out.println(response.asString());

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody rb = objectMapper.readValue(response.asString(), ResponseBody.class);

        String fName = rb.getSubAgents().get(0).getFirstName();

        System.out.println(fName);
    }
}
