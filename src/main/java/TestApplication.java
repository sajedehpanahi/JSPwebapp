import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import dataAccess.CRUD;
import dataAccess.entities.*;
import exceptions.DataNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import util.LoggerUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TestApplication {
    public static void main(String[] args) {
//        try (Session session= HibernateUtil.getSessionFactory().openSession()) {
//            LoggerUtil.getLogger().info("session opened!");
//            LoggerUtil.getLogger().error("everything is OK!");
//
//            session.beginTransaction();
//
//            LegalCustomerEntity legalCustomer = new LegalCustomerEntity("dotin","1389-09-17","234785");
//            session.save(legalCustomer);
//
//            RealCustomerEntity realCustomer = new RealCustomerEntity("a","s","d","f","g");
//            session.save(realCustomer);
//
//            HashSet<GrantConditionEntity> grantConditions = new HashSet<GrantConditionEntity>();
//            for(int i=0; i<3; i++){
//                GrantConditionEntity grantCondition = new GrantConditionEntity("grant name", 10,20, new BigDecimal(30),new BigDecimal(40));
//                grantConditions.add(grantCondition);
//            }
//
//            LoanTypeEntity loanType = new LoanTypeEntity("loan name",2.4F,grantConditions);
//            session.save(loanType);
//
//            for (GrantConditionEntity grantCondition: grantConditions){
//                grantCondition.setLoanType(loanType);
//                session.save(grantCondition);
//            }
//
//            LoanFileEntity loanFile = new LoanFileEntity(loanType,24,new BigDecimal(52));
//            loanFile.setRealCustomer(realCustomer);
//            //new RealCustomer("customer first name", "last name", "father name", "date of birth", "national code 2121")
//            session.save(loanFile);
//
//            session.getTransaction().commit();
//        }catch (RuntimeException e){
//            System.out.println("Error!");
//            e.printStackTrace();
//        }
//        finally {
//        }
//         RealCustomerEntity realCustomer = new RealCustomerEntity("1371-02-01","ننن","پناهی","مککم","بلی");
//          CRUD.saveRealCustomer(realCustomer);
//        LoggerUtil.getLogger().error("real customer saved via CRUD class!");
//        RealCustomerEntity retrievedRealCustomer = null;
//        try {
//            retrievedRealCustomer = CRUD.RetrieveRealCustomerById(2);
//        } catch (DataNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(retrievedRealCustomer.toString() + retrievedRealCustomer.getCustomerId() + retrievedRealCustomer.getLastName());
//
//        realCustomer.setFirstName("sajede");
//        realCustomer.setLastName("panahi");
//        CRUD.updateRealCustomer(retrievedRealCustomer);
//        System.out.println("real customer updated!");*/

        CRUD.deleteRealCustomerById(3);
        //System.out.println("real customer deleted!");

       // realCustomer.setCustomerId(16);
        //CRUD.deleteRealCustomer(realCustomer);
        //System.out.println("real customer deleted!");
/*
        try {
            ArrayList list = (ArrayList)CRUD.retrieveRealCustomer(realCustomer);
            for(Object entity : list){
                RealCustomerEntity t = (RealCustomerEntity)entity;
                System.out.println(t.getFirstName()+ " " + t.getFatherName());
            }
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}
