package dataAccess.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "GRANT_CONDITION_TABLE")
public class GrantConditionEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "GRANT_ID", nullable = false)
    private int grantId;

    @Column(name = "GRANT_NAME", nullable = false)
    private String grantName;

    @Column(name = "MIN_DURATION", nullable = false)
    private int minDuration;

    @Column(name = "MAX_DURATION", nullable = false)
    private int maxDuration;

    @Column(name = "MIN_AMOUNT", nullable = false)
    private BigDecimal minAmount;

    @Column(name = "MAX_AMOUNT", nullable = false)
    private BigDecimal maxAmount;

    @ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LOAN_ID", nullable = false)
    private LoanTypeEntity loanType;


    public GrantConditionEntity(String grantName, int minDuration, int maxDuration, BigDecimal minAmount, BigDecimal maxAmount) {
        this.grantName = grantName;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public int getGrantId() {
        return grantId;
    }

    public void setGrantId(int grantId) {
        this.grantId = grantId;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public LoanTypeEntity getLoanType() {
        return loanType;
    }

    public GrantConditionEntity() {
    }

    public void setLoanType(LoanTypeEntity loanType) {
        this.loanType = loanType;
    }
}
