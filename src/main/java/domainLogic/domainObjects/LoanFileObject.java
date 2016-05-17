package domainLogic.domainObjects;

import dataAccess.entities.LoanFileEntity;
import dataAccess.entities.LoanTypeEntity;

import java.math.BigDecimal;

public class LoanFileObject {

    private int loanFileId;
    private int duration;
    private BigDecimal amount;
    private LoanTypeObject loanType;
    private RealCustomerObject realCustomer;

    public int getLoanFileId() {
        return loanFileId;
    }

    public void setLoanFileId(int loanFileId) {
        this.loanFileId = loanFileId;
    }

    public RealCustomerObject getRealCustomer() {
        return realCustomer;
    }

    public void setRealCustomer(RealCustomerObject realCustomer) {
        this.realCustomer = realCustomer;
    }

    public LoanFileObject() {
    }

    public LoanFileObject(LoanTypeObject loanType, int duration, BigDecimal amount) {
        this.loanType = loanType;
        this.duration = duration;
        this.amount = amount;
    }

    public LoanTypeObject getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanTypeObject loanType) {
        this.loanType = loanType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LoanFileEntity toLoanFileEntity(){
        if(loanType != null) {
            return new LoanFileEntity(this.loanType.toLoanTypeEntity(), this.duration, this.amount);
        }
        return  new LoanFileEntity(this.amount, this.duration);
    }
}
