package presentation;

import domainLogic.LoanFileLogic;
import domainLogic.LoanTypeLogic;
import domainLogic.domainObjects.LoanFileObject;
import domainLogic.domainObjects.LoanTypeObject;
import domainLogic.domainObjects.RealCustomerObject;
import exceptions.DataNotFoundException;
import exceptions.FieldRequiredException;
import exceptions.InputNotInRangeException;
import exceptions.NationalCodeFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class LoanFileController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        if ("retrieve-customer-and-loan-type".equalsIgnoreCase(action)){
            retrieveCustomerLoanType(request, response);
        }
        if ("first-run".equalsIgnoreCase(action)){
            firstRun(request, response);
        }
        if ("create".equalsIgnoreCase(action)){
            createLoanFile(request, response);
        }
    }

    private void createLoanFile(HttpServletRequest request, HttpServletResponse response) {

        try {
            Integer customerId = Integer.parseInt(request.getParameter("confirmedCustomerId"));
            Integer loanTypeId = Integer.parseInt(request.getParameter("loanType"));
            LoanFileObject loanFileObject = new LoanFileObject();
            loanFileObject.setAmount(new BigDecimal(request.getParameter("amount")));
            loanFileObject.setDuration(Integer.parseInt(request.getParameter("duration")));
            LoanFileLogic.create(customerId,loanTypeId,loanFileObject);

            request.setAttribute("header","عملیات موفق");
            request.setAttribute("text","پرونده تسهیلاتی با موفقیت ثبت شد.");
        } catch (InputNotInRangeException | Exception e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در ثبت پرونده تسهیلاتی جدیدایجاد شده است." + "\n" + e.getMessage());
        } finally {
            try {
                request.setAttribute("url","LoanFileController?action=first-run");
                getServletConfig().getServletContext().getRequestDispatcher("/info-page.jsp").forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void firstRun(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("customerExists",-1);
            request.setAttribute("customerId","");
            getServletConfig().getServletContext().getRequestDispatcher("/create-loan-file.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void retrieveCustomerLoanType(HttpServletRequest request, HttpServletResponse response) {


        Integer customerId = Integer.parseInt(request.getParameter("customerId"));
        int customerExists = 0;
        boolean anyLoanTypeExists = false;
        try {
            RealCustomerObject realCustomerObject = LoanFileLogic.retrieveCustomer(customerId);
            customerExists = 1;
            request.setAttribute("realCustomerObject",realCustomerObject);
            request.setAttribute("customerId",realCustomerObject.getCustomerId());

            ArrayList<LoanTypeObject> loanTypeObjects = LoanFileLogic.retrieveLoanTypes();
            anyLoanTypeExists = true;
            request.setAttribute("loanTypeObjects",loanTypeObjects);
        } catch (DataNotFoundException e) {
            customerExists = 0;
            anyLoanTypeExists = false;
        }
        try {
            request.setAttribute("customerExists",customerExists);
            request.setAttribute("anyLoanTypeExists",anyLoanTypeExists);
            getServletConfig().getServletContext().getRequestDispatcher("/create-loan-file.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
