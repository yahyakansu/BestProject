package apimodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * This class uses to request
 */
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBody {

    List<Agent> agents;
    List<SubAgent> subAgents;
    String message;
    int agentId;
    // JSON == ResponseBody

}
