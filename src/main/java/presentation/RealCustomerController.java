package presentation;

import dataAccess.CRUD;
import dataAccess.entities.RealCustomerEntity;
import domainLogic.RealCustomerLogic;
import domainLogic.domainObjects.RealCustomerObject;
import exceptions.DataNotFoundException;
import exceptions.FieldRequiredException;
import exceptions.NationalCodeFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RealCustomerController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        if ("create".equalsIgnoreCase(action)){
            creteRealCustomer(request, response);
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
        if ("confirm-update".equalsIgnoreCase(action)){
            confirmUpdateRealCustomer(request, response);
        }
        if ("update".equalsIgnoreCase(action)){
            updateRealCustomer(request, response);
        }
    }

    private void confirmUpdateRealCustomer(HttpServletRequest request, HttpServletResponse response) {

        try {
            RealCustomerObject realCustomerObject = new RealCustomerObject();
            realCustomerObject.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
            realCustomerObject.setFirstName(request.getParameter("firstName"));
            realCustomerObject.setLastName(request.getParameter("lastName"));
            realCustomerObject.setFatherName(request.getParameter("fatherName"));
            realCustomerObject.setDateOfBirth(request.getParameter("dateOfBirth"));
            realCustomerObject.setNationalCode(request.getParameter("nationalCode"));

            RealCustomerLogic.update(realCustomerObject);

            request.setAttribute("header","عملیات موفق");
            request.setAttribute("text","اطلاعات مشتری با شماره " + realCustomerObject.getCustomerId() + " با موفقیت به روز شد.");
            request.setAttribute("url","retrieve-real-customer.jsp");

        } catch (FieldRequiredException | NationalCodeFormatException e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در به روز زسانی مشتری ایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url","retrieve-real-customer.jsp");
        }finally {
            try {
                getServletConfig().getServletContext().getRequestDispatcher("/info-page.jsp").forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateRealCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("id"));
        try {
            RealCustomerObject realCustomerObject = RealCustomerLogic.retrieve(customerId);
            //RealCustomerObject realCustomerObject = RealCustomerObject.convert(CRUD.retrieveRealCustomerById(customerId));
            request.setAttribute("realCustomerObject",realCustomerObject);
            getServletConfig().getServletContext().getRequestDispatcher("/update-real-customer.jsp").forward(request,response);
        } catch (ServletException | IOException | DataNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void creteRealCustomer(HttpServletRequest request, HttpServletResponse response) {

        try {
            RealCustomerObject realCustomerObject = new RealCustomerObject();
            realCustomerObject.setFirstName(request.getParameter("firstName"));
            realCustomerObject.setLastName(request.getParameter("lastName"));
            realCustomerObject.setFatherName(request.getParameter("fatherName"));
            realCustomerObject.setDateOfBirth(request.getParameter("dateOfBirth"));
            realCustomerObject.setNationalCode(request.getParameter("nationalCode"));

            RealCustomerLogic.create(realCustomerObject);

            request.setAttribute("header","عملیات موفق");
            request.setAttribute("text","مشتری با موفقیت ثبت شد.");
            request.setAttribute("url","create-real-customer.jsp");
        } catch (FieldRequiredException | NationalCodeFormatException e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در ثبت مشتری جدیدایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url","create-real-customer.jsp");
        }finally {
            try {
                getServletConfig().getServletContext().getRequestDispatcher("/info-page.jsp").forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void confirmDeleteRealCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            int customerId = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("realCustomerObject",RealCustomerObject.convert(CRUD.retrieveRealCustomerById(customerId)));
            getServletConfig().getServletContext().getRequestDispatcher("/confirm-delete-real-customer.jsp").forward(request,response);
        } catch (ServletException | IOException | DataNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteRealCustomer(HttpServletRequest request, HttpServletResponse response) {

        try {
            int customerId = Integer.parseInt(request.getParameter("id"));
            RealCustomerLogic.delete(customerId);

            request.setAttribute("header","عملیات موفق");
            request.setAttribute("text","مشتری با شماره ی"+ customerId + " با موفقیت حذف شد.");
            request.setAttribute("url","retrieve-real-customer.jsp");
            getServletConfig().getServletContext().getRequestDispatcher("/info-page.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void retrieveRealCustomer(HttpServletRequest request, HttpServletResponse response) {

        try {
            RealCustomerObject realCustomerObject = new RealCustomerObject();
            realCustomerObject.setFirstName(request.getParameter("firstName"));
            realCustomerObject.setLastName(request.getParameter("lastName"));
            realCustomerObject.setFatherName(request.getParameter("fatherName"));
            realCustomerObject.setNationalCode(request.getParameter("nationalCode"));

            ArrayList<RealCustomerObject> realCustomerObjects = RealCustomerLogic.retrieve(realCustomerObject);

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
