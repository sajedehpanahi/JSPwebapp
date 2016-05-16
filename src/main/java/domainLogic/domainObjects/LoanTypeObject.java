package domainLogic.domainObjects;

import dataAccess.entities.LoanTypeEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoanTypeObject {

    private int loanId;
    private String loanName;
    private float interestRate;
    private List<GrantConditionObject> grantConditions = new ArrayList<GrantConditionObject>();

    public LoanTypeObject(String loanName, float interestRate) {
        this.loanName = loanName;
        this.interestRate = interestRate;
    }

    public LoanTypeObject() {
    }

    public LoanTypeObject(List<GrantConditionObject> grantConditions, float interestRate, String loanName) {
        this.grantConditions = grantConditions;
        this.interestRate = interestRate;
        this.loanName = loanName;
    }

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

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public List<GrantConditionObject> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(List<GrantConditionObject> grantConditions) {
        this.grantConditions = grantConditions;
    }

    public static  LoanTypeEntity toLoanTypeEntity( LoanTypeObject loanTypeObject){
        return new LoanTypeEntity(loanTypeObject.loanName, loanTypeObject.interestRate);
    }

/*    public static Set<LoanTypeEntity> toLoanTypeEntity(ArrayList<LoanTypeObject> loanTypeObjects){
        Set<LoanTypeEntity> loanTypeEntities = new HashSet<>();
        for(LoanTypeObject loanTypeObject : loanTypeObjects){
            loanTypeEntities.add(toLoanTypeEntity(loanTypeObject));
        }
        return loanTypeEntities;
    }*/
}
