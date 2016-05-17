package domainLogic.domainObjects;

import dataAccess.entities.LoanTypeEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoanTypeObject {

    private Integer loanId;
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

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public List<GrantConditionObject> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(List<GrantConditionObject> grantConditions) {
        this.grantConditions = grantConditions;
    }

    public  LoanTypeEntity toLoanTypeEntity(){
        LoanTypeEntity loanTypeEntity =  new LoanTypeEntity(this.loanName, this.interestRate);
        if(this.loanId != null){
            loanTypeEntity.setLoanId(this.loanId);
        }
        return loanTypeEntity;
    }

    public static LoanTypeObject convert(LoanTypeEntity loanTypeEntity) {
        LoanTypeObject loanTypeObject = new LoanTypeObject();
        loanTypeObject.setLoanName(loanTypeEntity.getLoanName());
        loanTypeObject.setInterestRate(loanTypeEntity.getInterestRate());
        loanTypeObject.setLoanId(loanTypeEntity.getLoanId());
        return loanTypeObject;
    }

/*    public static Set<LoanTypeEntity> toLoanTypeEntity(ArrayList<LoanTypeObject> loanTypeObjects){
        Set<LoanTypeEntity> loanTypeEntities = new HashSet<>();
        for(LoanTypeObject loanTypeObject : loanTypeObjects){
            loanTypeEntities.add(toLoanTypeEntity(loanTypeObject));
        }
        return loanTypeEntities;
    }*/
}
