package dataAccess;

import dataAccess.entities.GrantConditionEntity;
import dataAccess.entities.LoanFileEntity;
import dataAccess.entities.LoanTypeEntity;
import dataAccess.entities.RealCustomerEntity;
import exceptions.DataNotFoundException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import util.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

public class CRUD {

    public static void saveRealCustomer(RealCustomerEntity realCustomer) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.save(realCustomer);
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + "with customer #" + realCustomer.getCustomerId() + " successfully created in data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Creating real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + " failed!");
            e.printStackTrace();
        }
    }

    public static RealCustomerEntity retrieveRealCustomerById(int id)
            throws DataNotFoundException {
        RealCustomerEntity realCustomer;
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            realCustomer = session.get(RealCustomerEntity.class, id);
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + "with customer #" + realCustomer.getCustomerId() + " successfully retrieved from data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("retrieving real Customer with customer ID " + id + " failed!");
            e.printStackTrace();
            throw new DataNotFoundException("مشتری با شماره " + id + "وجود ندارد.");
        }
        return realCustomer;
    }

    public static List<RealCustomerEntity> retrieveRealCustomer(RealCustomerEntity realCustomer)
            throws DataNotFoundException {
        List<RealCustomerEntity> realCustomers;
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            realCustomers = generateCriteria(session, realCustomer).list();
            LoggerUtil.getLogger().info("Real Customer(s) successfully retrieved from data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("retrieving real Customer(s) from data base failed!");
            e.printStackTrace();
            throw new DataNotFoundException("خطا در بازیابی مشتری!");
        }
        return realCustomers;
    }

    private static Criteria generateCriteria(Session session, RealCustomerEntity realCustomer) {
        Criteria criteria = session.createCriteria(RealCustomerEntity.class);
        if (realCustomer.getCustomerId() != null && !realCustomer.getCustomerId().toString().isEmpty()) {
            criteria.add(Restrictions.eq("customerId", realCustomer.getCustomerId()));
        } else if (!realCustomer.getNationalCode().equalsIgnoreCase(null) && !realCustomer.getNationalCode().isEmpty()) {
            criteria.add(Restrictions.eq("nationalCode", realCustomer.getNationalCode()));
        } else {
            if (!realCustomer.getFirstName().equalsIgnoreCase(null) && !realCustomer.getFirstName().isEmpty()) {
                criteria.add(Restrictions.eq("firstName", realCustomer.getFirstName()));
            }
            if (!realCustomer.getLastName().equalsIgnoreCase(null) && !realCustomer.getLastName().isEmpty()) {
                criteria.add(Restrictions.eq("lastName", realCustomer.getLastName()));
            }
            if (!realCustomer.getFatherName().equalsIgnoreCase(null) && !realCustomer.getFatherName().isEmpty()) {
                criteria.add(Restrictions.eq("fatherName", realCustomer.getFatherName()));
            }
        }
        return criteria;
    }

    public static void deleteRealCustomerById(int id) {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            RealCustomerEntity realCustomerToDelete = session.get(RealCustomerEntity.class, id);
            if (realCustomerToDelete != null) {
                session.delete(realCustomerToDelete);
            }
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Real Customer with customer #" + id + " successfully deleted from data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("deleting real Customer with customer #" + id + " failed!");
            e.printStackTrace();
        }
    }

    public static void deleteRealCustomer(RealCustomerEntity realCustomer) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.delete(realCustomer);
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + "with customer #" + realCustomer.getCustomerId() + " successfully deleted from in data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Deleting real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + " failed!");
            e.printStackTrace();
        }
    }

    public  static  void saveLoanType(LoanTypeEntity loanType, ArrayList<GrantConditionEntity> grantConditions)
    {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.save(loanType);
            for(GrantConditionEntity grantCondition : grantConditions){
                grantCondition.setLoanType(loanType);
                session.save(grantCondition);
            }
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Loan Type " + loanType.getLoanName() + " with interest rate " + loanType.getInterestRate() + " successfully created in data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Creating Loan Type " + loanType.getLoanName() + " with interest rate " + loanType.getInterestRate() + " failed!");
            e.printStackTrace();
        }
    }

    public static void updateRealCustomer(RealCustomerEntity realCustomer) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.update(realCustomer);
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + "with customer #" + realCustomer.getCustomerId() + " successfully updated in data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Updating real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + " failed!");
            e.printStackTrace();
        }
    }

    public static void saveLoanFile(LoanFileEntity loanFile, LoanTypeEntity loanType, RealCustomerEntity realCustomer){
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            loanFile.setLoanType(loanType);
            loanFile.setRealCustomer(realCustomer);
            session.save(loanFile);
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Loan File for customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + " with loan type " + loanType.getLoanName() + "successfully saved in data base with id #" + loanFile.getLoanFileId());
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Creating loan File for customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + " with loan type " + loanType.getLoanName() + " failed!");
            e.printStackTrace();
        }
    }

    public static List<LoanTypeEntity> retrieveAllLoanTypes()
            throws DataNotFoundException {

        List<LoanTypeEntity> loanTypeEntities;
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            //Criteria criteria = session.createCriteria(LoanTypeEntity.class);
            session.beginTransaction();
            loanTypeEntities = session.createCriteria(LoanTypeEntity.class).list();
            LoggerUtil.getLogger().info("Loan type(s) successfully retrieved from data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("retrieving loan type(s) from data base failed!");
            e.printStackTrace();
            throw new DataNotFoundException("هیچ نوع تسهیلاتی ثبت نشده است!");
        }
        return loanTypeEntities;
    }

    public static LoanTypeEntity retrieveLoanTypeById(Integer loanTypeId)
            throws DataNotFoundException {

        LoanTypeEntity loanTypeEntity;
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            loanTypeEntity = session.get(LoanTypeEntity.class, loanTypeId);
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Loan type " + loanTypeEntity.getLoanName() + "with loan Id #" + loanTypeEntity.getLoanId() + " successfully retrieved from data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("retrieving loan type with loan Id #" + loanTypeId +" failed!");
            e.printStackTrace();
            throw new DataNotFoundException("نوع تسهیلات با شماره " + loanTypeId + "وجود ندارد.");
        }
        return loanTypeEntity;
    }

    public static List<GrantConditionEntity> retrieveLoanTypeConditions(Integer loanId)
            throws DataNotFoundException {
        List<GrantConditionEntity> grantConditionEntities;
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            Criteria criteria =session.createCriteria(GrantConditionEntity.class);
            criteria.add(Restrictions.eq("loanType.loanId", loanId));
            grantConditionEntities = criteria.list();
            //grantConditionEntities = session.createCriteria(GrantConditionEntity.class).add(Restrictions.eq("loanType", loanId)).list();
            LoggerUtil.getLogger().info("Grant condition(s) successfully retrieved from data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("retrieving grant condition(s) from data base failed!");
            e.printStackTrace();
            throw new DataNotFoundException("خطا در بازیابی شروط اعطا!");
        }
        return grantConditionEntities;
    }
}
