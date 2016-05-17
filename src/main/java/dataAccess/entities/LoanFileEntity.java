package dataAccess.entities;

import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "LOAN_FILE_TABLE")
public class LoanFileEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "LOAN_FILE_ID", nullable = false)
    private int loanFileId;

    @Column(name = "DURATION", nullable = false)
    private int duration;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @ManyToOne//fetch= FetchType.LAZY)
    @JoinColumn(name = "LOAN_ID", nullable = false)
    private LoanTypeEntity loanType;

    @ManyToOne//(fetch= FetchType.LAZY )
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
//    @ForeignKey(name="FK_PARENT")
    private RealCustomerEntity realCustomer;

    public int getLoanFileId() {
        return loanFileId;
    }

    public void setLoanFileId(int loanFileId) {
        this.loanFileId = loanFileId;
    }

    public RealCustomerEntity getRealCustomer() {
        return realCustomer;
    }

    public void setRealCustomer(RealCustomerEntity realCustomer) {
        this.realCustomer = realCustomer;
    }

    public LoanFileEntity() {
    }

    public LoanFileEntity(BigDecimal amount, int duration) {
        this.duration = duration;
        this.amount = amount;
    }

    public LoanFileEntity(LoanTypeEntity loanType, int duration, BigDecimal amount) {
        this.loanType = loanType;
        this.duration = duration;
        this.amount = amount;
    }

    public LoanTypeEntity getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanTypeEntity loanType) {
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

}
