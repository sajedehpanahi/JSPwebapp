package dataAccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "LEGAL_CUSTOMER")
@PrimaryKeyJoinColumn(name = "CUSTOMER_ID")
public class LegalCustomerEntity extends CustomerEntity {

    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

    @Column(name = "DATE_OF_REGISTRATION", nullable = false)
    private String dateOfRegistration;

    @Column(name = "ECONOMIC_CODE", nullable = false)
    private String economicCode;

    public LegalCustomerEntity(String companyName, String dateOfRegistration, String economicCode) {
        this.companyName = companyName;
        this.dateOfRegistration = dateOfRegistration;
        this.economicCode = economicCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

}
