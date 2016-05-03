package dataAccess.beans;

import java.util.ArrayList;
import java.util.List;

public class LoanType {

    private String loanName;
    private int interestRate;
    private List<GrantCondition> grantConditions = new ArrayList<GrantCondition>();

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
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
