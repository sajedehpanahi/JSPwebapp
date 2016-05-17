package domainLogic;

import dataAccess.CRUD;
import dataAccess.entities.GrantConditionEntity;
import domainLogic.domainObjects.GrantConditionObject;
import domainLogic.domainObjects.LoanTypeObject;
import exceptions.ConditionRangeException;
import exceptions.DataNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class GrantConditionLogic {

    public static void create(LoanTypeObject loanTypeObject, ArrayList<GrantConditionObject> grantConditions)
            throws ConditionRangeException {

        validateGrantConditions(grantConditions);
        CRUD.saveLoanType(loanTypeObject.toLoanTypeEntity(), GrantConditionObject.toLoanTypeEntity(grantConditions));

    }

    private static void validateGrantConditions(ArrayList<GrantConditionObject> grantConditions)
            throws ConditionRangeException {

        for(GrantConditionObject grantConditionObject : grantConditions){
            if(grantConditionObject.getMinDuration() > grantConditionObject.getMaxDuration()){
                throw new ConditionRangeException("حداکثر مدت قرارداد باید بزرگتر از حداقل مدت قرارداد باشد.");
            }
            if(grantConditionObject.getMinAmount().compareTo(grantConditionObject.getMaxAmount())==1){
                throw new ConditionRangeException("حداکثر مبلغ قرارداد باید بزرگتر از حداقل مدت قرارداد باشد.");
            }
        }
    }

    public static ArrayList<GrantConditionObject> retrieveConditionsByLoanId(Integer loanId)
            throws DataNotFoundException {

        List<GrantConditionEntity> grantConditionEntities = CRUD.retrieveLoanTypeConditions(loanId);
        ArrayList<GrantConditionObject> grantConditionObjects = new ArrayList<>();
        for(GrantConditionEntity grantConditionEntity : grantConditionEntities){
            grantConditionObjects.add(GrantConditionObject.convert(grantConditionEntity));
        }
        return  grantConditionObjects;
    }
}
