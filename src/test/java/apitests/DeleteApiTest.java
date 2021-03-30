package apitests;

import org.junit.Test;
import utilities.APIUtil;
import utilities.Config;

public class DeleteApiTest {

    // "Teacher with id=4596 NOT FOUND!" should be in the message attribute when teacher not found in DB

    /**
     * "Agent with id=2333 NOT FOUND!" should be in the message attribute when agent not found in DB
     */
    @Test
    public void deletePositive(){
        String resource = Config.getProperties("deletePositiveEndPoint");
        APIUtil.hitDELETE(resource);

        String resourceForGet = Config.getProperties("getDeletePositiveEndPoint");
        APIUtil.hitGET(resourceForGet);
        String message = APIUtil.getResponseBody().getMessage();
        System.err.println(message);
    }

    /**
     * "Agent with id=2333 NOT FOUND!" when we try to delete not existing agent.
     */
    @Test
    public void deleteNegative(){
        String resource = Config.getProperties("deletePositiveEndPoint");
        APIUtil.hitDELETE(resource);

        String message = APIUtil.getResponseBody().getMessage();
        System.err.println(message);
    }
}
