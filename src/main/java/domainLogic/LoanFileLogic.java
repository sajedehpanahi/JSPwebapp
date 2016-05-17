package domainLogic;

import dataAccess.CRUD;
import domainLogic.domainObjects.GrantConditionObject;
import domainLogic.domainObjects.LoanFileObject;
import domainLogic.domainObjects.LoanTypeObject;
import domainLogic.domainObjects.RealCustomerObject;
import exceptions.DataNotFoundException;
import exceptions.InputNotInRangeException;

import java.math.BigDecimal;
import java.util.ArrayList;

public class LoanFileLogic {

    public static void validateLoanFile(LoanFileObject loanFileObject, Integer loanId)
            throws DataNotFoundException, InputNotInRangeException {

        ArrayList<GrantConditionObject> grantConditionObjects = GrantConditionLogic.retrieveConditionsByLoanId(loanId);
        for(GrantConditionObject grantConditionObject : grantConditionObjects){
            if( loanFileObject.getDuration() > grantConditionObject.getMaxDuration() || loanFileObject.getDuration() < grantConditionObject.getMinDuration()){
                throw new InputNotInRangeException("مدت زمان وارد شده در محدوده مدت زمان های شرایط تسهیلات صدق نمی کند! لطفا دوباره تلاش کنید.");
            }
            if( loanFileObject.getAmount().compareTo(new BigDecimal(grantConditionObject.getMaxDuration()))==1  || loanFileObject.getAmount().compareTo(new BigDecimal(grantConditionObject.getMinDuration()))==-1 ){
                throw new InputNotInRangeException("مبلغ وارد شده در محدوده مبلغ های شرایط تسهیلات صدق نمی کند! لطفا دوباره تلاش کنید.");
            }
        }
    }

    public static RealCustomerObject retrieveCustomer(Integer customerId)
            throws DataNotFoundException {

        return RealCustomerLogic.retrieve(customerId);
    }

    public static ArrayList<LoanTypeObject> retrieveLoanTypes()
            throws DataNotFoundException {

        return LoanTypeLogic.retrieveAll();
    }

    public static LoanTypeObject retrieveLoanType(Integer loanTypeId)
            throws DataNotFoundException {

        return LoanTypeLogic.retrieve(loanTypeId);
    }

    public static void create(Integer customerId, Integer loanTypeId, LoanFileObject loanFileObject)
            throws InputNotInRangeException {

        try {
            LoanTypeObject loanTypeObject = retrieveLoanType(loanTypeId);
            validateLoanFile(loanFileObject,loanTypeId);
            loanFileObject.setLoanType(loanTypeObject);
            RealCustomerObject realCustomerObject = retrieveCustomer(customerId);
            loanFileObject.setRealCustomer(realCustomerObject);
           CRUD.saveLoanFile(loanFileObject.toLoanFileEntity(), loanTypeObject.toLoanTypeEntity(), realCustomerObject.toRealCustomerEntity());
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }
    }
}
