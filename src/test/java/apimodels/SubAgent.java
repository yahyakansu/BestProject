package apimodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAgent {

    int subAgentId;

    String firstName;
    String lastName;
    String password;
    String joinDate;
    String birthDate;
    Company company;
}
