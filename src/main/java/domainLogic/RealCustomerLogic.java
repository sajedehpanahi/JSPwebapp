package domainLogic;

import dataAccess.CRUD;
import dataAccess.entities.RealCustomerEntity;
import domainLogic.domainObjects.RealCustomerObject;
import exceptions.DataNotFoundException;
import exceptions.FieldRequiredException;
import exceptions.NationalCodeFormatException;

import java.util.ArrayList;
import java.util.List;

public class RealCustomerLogic {

    private static void validateCustomerInformation(RealCustomerObject realCustomerObject)
            throws FieldRequiredException, NationalCodeFormatException {

        if (realCustomerObject.getFirstName().equals(null) || realCustomerObject.getFirstName().isEmpty()) {
            throw new FieldRequiredException("وارد کردن نام الزامی است.");
        }
        if (realCustomerObject.getLastName().equals(null) || realCustomerObject.getLastName().isEmpty()) {
            throw new FieldRequiredException("وارد کردن نام خانوادگی الزامی است.");
        }
        if (realCustomerObject.getFatherName().equals(null) || realCustomerObject.getFatherName().isEmpty()) {
            throw new FieldRequiredException("وارد کردن نام پدر الزامی است.");
        }
        if (realCustomerObject.getDateOfBirth().equals(null) || realCustomerObject.getDateOfBirth().isEmpty()) {
            throw new FieldRequiredException("وارد کردن تاریخ تولد الزامی است.");
        }
        if (realCustomerObject.getNationalCode().equals(null) || realCustomerObject.getNationalCode().isEmpty()) {
            throw new FieldRequiredException("وارد کردن کد ملی الزامی است.");
        } else {
            if (realCustomerObject.getNationalCode().trim().length() != 10) {
                throw new NationalCodeFormatException("کد ملی باید دقیقا ده رقم باشد");
            } else {
                String code = realCustomerObject.getNationalCode().trim();
                int sum = 0;
                for (int i = 10; i > 1; i--) {
                    sum += Integer.parseInt(code.substring(10 - i, 11 - i)) * i;
                }
                int rightMostNumber = Integer.parseInt(code.substring(9));
                int reminder = sum % 11;
                if (!(reminder == rightMostNumber) && !(reminder == 11 - rightMostNumber)) {
                    throw new NationalCodeFormatException("کد ملی وارد شده صحیح نیست");
                }
            }
        }
    }

    public static void update(RealCustomerObject realCustomerObject)
            throws FieldRequiredException, NationalCodeFormatException {

        validateCustomerInformation(realCustomerObject);
        CRUD.updateRealCustomer(realCustomerObject.toRealCustomerEntity());
    }

    public static RealCustomerObject retrieve(int customerId)
            throws DataNotFoundException {

        return  RealCustomerObject.convert(CRUD.retrieveRealCustomerById(customerId));
    }

    public static ArrayList<RealCustomerObject> retrieve(RealCustomerObject realCustomerObject)
            throws DataNotFoundException {

        List<RealCustomerEntity> realCustomerEntities = CRUD.retrieveRealCustomer(realCustomerObject.toRealCustomerEntity());
        ArrayList<RealCustomerObject> realCustomerObjects = new ArrayList<RealCustomerObject>();
        for(RealCustomerEntity realCustomerEntity : realCustomerEntities){
            realCustomerObjects.add(RealCustomerObject.convert(realCustomerEntity));
        }
        return  realCustomerObjects;
    }

    public static void create(RealCustomerObject realCustomerObject)
            throws NationalCodeFormatException, FieldRequiredException {

        validateCustomerInformation(realCustomerObject);
        CRUD.saveRealCustomer(realCustomerObject.toRealCustomerEntity());
    }

    public static void delete(int customerId) {

        CRUD.deleteRealCustomerById(customerId);
    }
}
