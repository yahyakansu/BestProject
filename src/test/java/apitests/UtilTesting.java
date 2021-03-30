package apitests;

import apimodels.Agent;
import apimodels.RequestBody;
import org.junit.Test;
import utilities.APIUtil;

public class UtilTesting {
    /**
     * to GET agent 4711
     */
    @Test
    public void agentTest(){
        String resource = "/agent/4711";
        APIUtil.hitGET(resource);
        System.out.println(APIUtil.getResponseBody().getAgents().get(0).getFirstName());
    }

    /**
     * to GET all agents are joined on Aug 2020
     */
    @Test
    public void allAgents(){
        APIUtil.hitGET("/agent/all");
        for (Agent t : APIUtil.getResponseBody().getAgents()){
            if (t.getJoinDate().contains("08/2020")){
                System.out.println(t.getFirstName());
            }
        }
    }

    @Test
    public void postTesting(){
        RequestBody requestBody = new RequestBody();
        requestBody.setEmailAddress("new.gmail.com");
        requestBody.setFirstName("Tina");
        requestBody.setLastName("Wonder");
        requestBody.setJoinDate("01/01/2000");
        requestBody.setBirthDate("01/01/1999");
        requestBody.setPassword("1234");
        requestBody.setPhone("123-234-2345");
        requestBody.setSubject("intro");

        APIUtil.hitPOST("/agent/create",requestBody);
    }

    @Test
    public void deleteTesting(){
        String resource = "/agent/delete/4601";
        APIUtil.hitDELETE(resource);
    }

    @Test
    public void putTesting(){
        String resource = "/agent/update";
        RequestBody requestBody = new RequestBody();
        requestBody.setEmailAddress("new.gmail.com");
        requestBody.setFirstName("Tina");
        requestBody.setLastName("Wonder");
        requestBody.setJoinDate("01/01/2000");
        requestBody.setBirthDate("01/01/1999");
        requestBody.setPassword("1234");
        requestBody.setPhone("123-234-2345");
        requestBody.setSubject("intro");

        APIUtil.hitPUT(resource,requestBody);
    }
}
