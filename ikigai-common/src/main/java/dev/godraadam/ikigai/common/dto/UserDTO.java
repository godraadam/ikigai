package dev.godraadam.ikigai.common.dto;

import java.util.List;

public class UserDTO extends BaseDTO {
    
    private String userName;

    private List<VisitDTO> visits;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the visits
     */
    public List<VisitDTO> getVisits() {
        return visits;
    }

    /**
     * @param visits the visits to set
     */
    public void setVisits(List<VisitDTO> visits) {
        this.visits = visits;
    }

}
