package apimodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * This class uses to response
 */
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestBody {
    String address;
    String subject;
    String birthDate;
    String password;
    String phone;
    String firstName;
    String lastName;
    String emailAddress;
    String joinDate;
    Company company;
}
