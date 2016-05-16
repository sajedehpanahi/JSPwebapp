package dataAccess.entities;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REAL_CUSTOMER")
@PrimaryKeyJoinColumn(name = "CUSTOMER_ID")
public class RealCustomerEntity extends CustomerEntity implements Serializable {

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "FATHER_NAME", nullable = false)
    private String fatherName;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private String dateOfBirth;

    @Column(name = "NATIONAL_CODE", nullable = false)
    private String nationalCode;

    @OneToMany(mappedBy = "realCustomer" , cascade = {CascadeType.ALL  })
//    @Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private Set<LoanFileEntity> loanFiles = new HashSet<LoanFileEntity>(0);

    public RealCustomerEntity(Integer customerId, String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode) {
        this.setCustomerId(customerId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        this.nationalCode = nationalCode;
    }

    public RealCustomerEntity() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Set<LoanFileEntity> getLoanFiles() {
        return loanFiles;
    }

    public void setLoanFiles(Set<LoanFileEntity> loanFiles) {
        this.loanFiles = loanFiles;
    }
}
