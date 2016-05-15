package domainLogic;

import dataAccess.CRUD;
import dataAccess.entities.RealCustomerEntity;
import domainLogic.domainObjects.RealCustomerObject;
import exceptions.DataNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RealCustomerController extends HttpServlet {

    private void creteRealCustomer(HttpServletRequest request) {

        RealCustomerObject realCustomerObject = new RealCustomerObject();
        realCustomerObject.setFirstName(request.getParameter("firstName"));
        realCustomerObject.setLastName(request.getParameter("lastName"));
        realCustomerObject.setFatherName(request.getParameter("fatherName"));
        realCustomerObject.setDateOfBirth(request.getParameter("dateOfBirth"));
        realCustomerObject.setNationalCode(request.getParameter("nationalCode"));

        CRUD.saveRealCustomer(realCustomerObject.toRealCustomerEntity());
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        if ("create".equalsIgnoreCase(action)){
            creteRealCustomer(request);
        }
        if ("retrieve".equalsIgnoreCase(action)){
            retrieveRealCustomer(request, response);
        }
        if ("confirm-delete".equalsIgnoreCase(action)){
            confirmDeleteRealCustomer(request, response);
        }
        if ("delete".equalsIgnoreCase(action)){
            deleteRealCustomer(request, response);
        }
        if ("update".equalsIgnoreCase(action)){
            retrieveRealCustomer(request, response);
        }

    }

    private void confirmDeleteRealCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("id"));
        try {
            /*RealCustomerObject  realCustomerObject =RealCustomerObject.convert(CRUD.retrieveRealCustomerById(customerId));
            request.setAttribute("customerId",realCustomerObject.getCustomerId());
            request.setAttribute("firstName",realCustomerObject.getFirstName());
            request.setAttribute("lastName",realCustomerObject.getLastName());
            request.setAttribute("fatherName",realCustomerObject.getFatherName());
            request.setAttribute("dateOfBirth",realCustomerObject.getDateOfBirth());
            request.setAttribute("nationalCode",realCustomerObject.getNationalCode());*/
            request.setAttribute("realCustomerObject",RealCustomerObject.convert(CRUD.retrieveRealCustomerById(customerId)));
            getServletConfig().getServletContext().getRequestDispatcher("/confirm-delete-real-customer.jsp").forward(request,response);
        } catch (ServletException | IOException | DataNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteRealCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("id"));
        CRUD.deleteRealCustomerById(customerId);
        request.setAttribute("header","خطا در ثبت اطلاعات مشتری");
        request.setAttribute("subject","عملیات موفق");
        request.setAttribute("text","مشتری با شماره ی"+ customerId + " با موفقیت حذف شد.");
        try {
            getServletConfig().getServletContext().getRequestDispatcher("/info-page.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void retrieveRealCustomer(HttpServletRequest request, HttpServletResponse response) {

        RealCustomerObject realCustomerObject = new RealCustomerObject();
        realCustomerObject.setFirstName(request.getParameter("firstName"));
        realCustomerObject.setLastName(request.getParameter("lastName"));
        realCustomerObject.setFatherName(request.getParameter("fatherName"));
        realCustomerObject.setNationalCode(request.getParameter("nationalCode"));

        try {
            List<RealCustomerEntity> realCustomerEntities = CRUD.retrieveRealCustomer(realCustomerObject.toRealCustomerEntity());
            ArrayList<RealCustomerObject> realCustomerObjects = new ArrayList<RealCustomerObject>();
            for(RealCustomerEntity realCustomerEntity : realCustomerEntities){
                realCustomerObjects.add(RealCustomerObject.convert(realCustomerEntity));
            }
            request.setAttribute("realCustomers",realCustomerObjects);
            getServletConfig().getServletContext().getRequestDispatcher("/show-real-customer.jsp").forward(request,response);
        } catch (DataNotFoundException e) {
            e.printStackTrace();
            System.out.println("khata dar bazyabi moshtari");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in parring data from servlet to jsp page");
        }
    }
}
