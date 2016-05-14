package dataAccess.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LOAN_TYPE")
public class LoanTypeEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "LOAN_ID")
    private int loanId;

    @Column(name = "LOAN_NAME", nullable = false)
    private String loanName;

    @Column(name = "INTEREST_RATE", nullable = false)
    private float interestRate;

    @OneToMany(mappedBy = "loanType")
    private Set<GrantConditionEntity> grantConditions = new HashSet<GrantConditionEntity>(0);

    @OneToMany(mappedBy = "loanType")
    private Set<LoanFileEntity> loanFiles = new HashSet<LoanFileEntity>(0);

    public LoanTypeEntity(){

    }
    public LoanTypeEntity(String loanName, float interestRate, HashSet<GrantConditionEntity> grantConditions) {
        this.loanName = loanName;
        this.interestRate = interestRate;
        this.grantConditions = grantConditions;
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

    public Set<GrantConditionEntity> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(HashSet<GrantConditionEntity> grantConditions) {
        this.grantConditions = grantConditions;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public void setGrantConditions(Set<GrantConditionEntity> grantConditions) {
        this.grantConditions = grantConditions;
    }

    public Set<LoanFileEntity> getLoanFiles() {
        return loanFiles;
    }

    public void setLoanFiles(Set<LoanFileEntity> loanFiles) {
        this.loanFiles = loanFiles;
    }
}
