package apimodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)   //default(null,0,false) olmayan verileri calistirir
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {

    int agentId;

    String birthDate;
    String department;
    String emailAddress;
    String firstName;
    String lastName;
    String password;
    String joinDate;
    String phone;
    Company company;
}
