package domainLogic;

import dataAccess.CRUD;
import dataAccess.entities.LoanTypeEntity;
import domainLogic.domainObjects.LoanTypeObject;
import exceptions.DataNotFoundException;
import exceptions.FieldRequiredException;

import java.util.ArrayList;
import java.util.List;

public class LoanTypeLogic {

    private static LoanTypeObject validateLoanType(String loanName, Float interestRate)
            throws FieldRequiredException {

        if (loanName.equals(null) || loanName.isEmpty()) {
            throw new FieldRequiredException("وارد کردن نام تسهیلات الزامی است.");
        }
        if (interestRate == null) {
            throw new FieldRequiredException("وارد کردن نرخ سود الزامی است.");
        }
        return new LoanTypeObject(loanName, interestRate);
    }

    public static LoanTypeObject create(String loanName, Float interestRate)
            throws FieldRequiredException {
        return validateLoanType(loanName, interestRate);
    }

    public static ArrayList<LoanTypeObject> retrieveAll()
            throws DataNotFoundException {

        List<LoanTypeEntity> loanTypeEntities = CRUD.retrieveAllLoanTypes();
        ArrayList<LoanTypeObject> loanTypeObjects = new ArrayList<>();
        for(LoanTypeEntity loanTypeEntity : loanTypeEntities){
            loanTypeObjects.add(LoanTypeObject.convert(loanTypeEntity));
        }
        return  loanTypeObjects;
    }

    public static LoanTypeObject retrieve(Integer loanTypeId)
            throws DataNotFoundException {

        return  LoanTypeObject.convert(CRUD.retrieveLoanTypeById(loanTypeId));
    }
}
