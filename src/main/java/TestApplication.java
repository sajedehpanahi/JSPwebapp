import dataAccess.CRUD;
import dataAccess.entities.GrantConditionEntity;
import dataAccess.entities.LoanFileEntity;
import dataAccess.entities.LoanTypeEntity;
import dataAccess.entities.RealCustomerEntity;
import domainLogic.RealCustomerLogic;
import domainLogic.domainObjects.RealCustomerObject;
import exceptions.DataNotFoundException;
import exceptions.FieldRequiredException;
import exceptions.NationalCodeFormatException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;

public class TestApplication {
    public static void main(String[] args) {

        /*try {
            RealCustomerEntity realCustomer = CRUD.retrieveRealCustomerById(5);
            LoanTypeEntity loanType = new LoanTypeEntity("my loan name", 2.4F);

            ArrayList<GrantConditionEntity> grantConditions = new ArrayList<GrantConditionEntity>();
            for (int i = 0; i < 3; i++) {
                GrantConditionEntity grantCondition = new GrantConditionEntity("grant condition test", 50, 16, new BigDecimal(45), new BigDecimal(87));
                grantConditions.add(grantCondition);
            }

            CRUD.saveLoanType(loanType,grantConditions);

            LoanFileEntity loanFileEntity = new LoanFileEntity(loanType,25,new BigDecimal(5600));
            CRUD.saveLoanFile(loanFileEntity,realCustomer);
            System.out.println(realCustomer.getCustomerId() + " & " + loanFileEntity.getLoanFileId());
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }*/

        //String code = "0440074924";
        //String code = "6090023817";

        try {
            RealCustomerObject realCustomerObject=new RealCustomerObject("ساجده","پناهی","محمد","1371-02-01","0014813793");
            realCustomerObject.setCustomerId(4);

            RealCustomerLogic.update(realCustomerObject);
        } catch (FieldRequiredException e) {
            e.printStackTrace();
        } catch (NationalCodeFormatException e) {
            e.printStackTrace();
        }

    }
}
