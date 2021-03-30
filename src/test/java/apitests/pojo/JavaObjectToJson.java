package apitests.pojo;

import apimodels.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class JavaObjectToJson {
    @Test
    public void jackson() throws JsonProcessingException {
        Agent agent = new Agent();
        agent.setFirstName("Jennifer");
        agent.setLastName("Anniston");
        agent.setEmailAddress("gson@gmail.com");
        agent.setJoinDate("03/15/2020");

        Company company = new Company();
        company.setCompanyName("ABC");
        company.setTitle("IT");

        agent.setCompany(company);

        ObjectMapper objectMapper = new ObjectMapper();
        String agentJson = objectMapper.writeValueAsString(agent);

        System.out.println(agentJson);
    }

    @Test
    public void test() throws Exception{
        SubAgent subAgent = new SubAgent();
        subAgent.setSubAgentId(232);
        subAgent.setFirstName("Andy");
        subAgent.setLastName("Warhol");

        Company company = new Company();
        company.setCompanyName("ABC");
        company.setTitle("IT");

        Address address = new Address();
        address.setAddressId(000);
        address.setCity("Rolling Meadows");
        address.setZipCode(45678);
        company.setAddress(address);
        subAgent.setCompany(company);

        ObjectMapper objectMapper = new ObjectMapper();
        String jSonSubAgent = objectMapper.writeValueAsString(subAgent);

        System.out.println(jSonSubAgent);
    }
}
