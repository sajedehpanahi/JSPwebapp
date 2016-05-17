import dataAccess.CRUD;
import dataAccess.entities.GrantConditionEntity;
import dataAccess.entities.LoanFileEntity;
import dataAccess.entities.LoanTypeEntity;
import dataAccess.entities.RealCustomerEntity;
import domainLogic.LoanFileLogic;
import domainLogic.RealCustomerLogic;
import domainLogic.domainObjects.LoanFileObject;
import domainLogic.domainObjects.LoanTypeObject;
import domainLogic.domainObjects.RealCustomerObject;
import exceptions.DataNotFoundException;
import exceptions.FieldRequiredException;
import exceptions.InputNotInRangeException;
import exceptions.NationalCodeFormatException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;

//String code = "0440074924";
//String code = "6090023817";
//String code = "0010904689";

public class TestApplication {
    public static void main(String[] args) {

        /*try {
            RealCustomerEntity realCustomer = CRUD.retrieveRealCustomerById(5);
            LoanTypeEntity loanType = new LoanTypeEntity("تسهیلات جدید", 2.4F);

            ArrayList<GrantConditionEntity> grantConditions = new ArrayList<GrantConditionEntity>();
            for (int i = 0; i < 3; i++) {
                GrantConditionEntity grantCondition = new GrantConditionEntity("دوما", 50, 100, new BigDecimal(45), new BigDecimal(87));
                grantConditions.add(grantCondition);
            }

            CRUD.saveLoanType(loanType,grantConditions);

            LoanFileEntity loanFileEntity = new LoanFileEntity(loanType,25,new BigDecimal(5600));
            Load
            LoanFileObject loanFileObject = new LoanFileObject(loanType,5, new BigDecimal(5))
            LoanFileLogic.create(2,48,);
            CRUD.saveLoanFile(loanFileEntity,loanType,realCustomer);
            System.out.println(realCustomer.getCustomerId() + " & " + loanFileEntity.getLoanFileId());
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }*/

        try {
            LoanFileObject loanFileObject =  new LoanFileObject();
            loanFileObject.setAmount(new BigDecimal(5));
            loanFileObject.setDuration(5);
            LoanFileLogic.validateLoanFile(loanFileObject,48);
        } catch (DataNotFoundException | InputNotInRangeException e) {
            e.printStackTrace();
        }

        /*try {
            RealCustomerObject realCustomerObject=new RealCustomerObject("ساجده","پناهی","محمد","1371-02-01","0014813793");
            realCustomerObject.setCustomerId(4);

            RealCustomerLogic.update(realCustomerObject);
        } catch (FieldRequiredException e) {
            e.printStackTrace();
        } catch (NationalCodeFormatException e) {
            e.printStackTrace();
        }*/

    }
}
