package domainLogic.domainObjects;

import dataAccess.entities.RealCustomerEntity;

public class RealCustomerObject {

    private String firstName;
    private String lastName;
    private String fullName;
    private String fatherName;
    private String dateOfBirth;
    private String nationalCode;
    private  Integer customerId;
   // private Set<LoanFileEntity> loanFiles = new HashSet<LoanFileEntity>(0);

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public RealCustomerObject() {
    }

    public RealCustomerObject(String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        this.nationalCode = nationalCode;
        this.setFullName(firstName, lastName);
    }

    /*
    public Set<LoanFileEntity> getLoanFiles() {
        return loanFiles;
    }

    public void setLoanFiles(Set<LoanFileEntity> loanFiles) {
        this.loanFiles = loanFiles;
    }*/

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public RealCustomerEntity toRealCustomerEntity(){
        return new RealCustomerEntity(this.customerId, this.firstName, this.lastName, this.fatherName,this.dateOfBirth,this.nationalCode);
    }

    public static RealCustomerObject convert(RealCustomerEntity realCustomerEntity) {
        RealCustomerObject realCustomerObject = new RealCustomerObject();
        realCustomerObject.setFirstName(realCustomerEntity.getFirstName());
        realCustomerObject.setLastName(realCustomerEntity.getLastName());
        realCustomerObject.setFatherName(realCustomerEntity.getFatherName());
        realCustomerObject.setNationalCode(realCustomerEntity.getNationalCode());
        realCustomerObject.setDateOfBirth(realCustomerEntity.getDateOfBirth());
        realCustomerObject.setCustomerId(realCustomerEntity.getCustomerId());
        return realCustomerObject;
    }
}
