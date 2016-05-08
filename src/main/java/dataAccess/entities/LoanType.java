package dataAccess.beans;

import java.util.ArrayList;
import java.util.List;

public class LoanType {

    private String loanName;
    private float interestRate;
    private List<GrantCondition> grantConditions = new ArrayList<GrantCondition>();

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public List<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(List<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }

    public LoanType() {
    }
}
