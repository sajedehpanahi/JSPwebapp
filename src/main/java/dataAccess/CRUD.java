package dataAccess;

import dataAccess.entities.RealCustomerEntity;
import exceptions.DataNotFoundException;
import org.hibernate.Session;
import util.HibernateUtil;
import util.LoggerUtil;

public class CRUD {

    public static void saveRealCustomer(RealCustomerEntity realCustomer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.save(realCustomer);
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + "with customer #" + realCustomer.getCustomerId() + " successfully created in data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Creating real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + " failed!");
            e.printStackTrace();
        }
    }

    public static RealCustomerEntity RetrieveRealCustomerById(int id)
            throws DataNotFoundException {
        RealCustomerEntity realCustomer;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
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

    public static void updateRealCustomer(RealCustomerEntity realCustomer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.update(realCustomer);
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + "with customer #" + realCustomer.getCustomerId() + " successfully updated in data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Updating real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + " failed!");
            e.printStackTrace();
        }
    }

    public static void deleteRealCustomerById(int id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.delete(realCustomer);
            session.getTransaction().commit();
            LoggerUtil.getLogger().info("Real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + "with customer #" + realCustomer.getCustomerId() + " successfully deleted from in data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Deleting real Customer " + realCustomer.getFirstName() + " " + realCustomer.getLastName() + " failed!");
            e.printStackTrace();
        }

    }


}
