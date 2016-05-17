package presentation;

import domainLogic.LoanTypeLogic;
import domainLogic.domainObjects.LoanTypeObject;
import exceptions.FieldRequiredException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoanTypeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pageToForward="";
        try {
            String loanName = request.getParameter("loanName");
            Float interestRate = Float.parseFloat(request.getParameter("interestRate"));
           // request.setAttribute("loanName",request.getParameter("loanName"));
           //request.setAttribute("interestRate",Float.parseFloat(request.getParameter("interestRate")));

            LoanTypeObject loanTypeObject = LoanTypeLogic.create(loanName, interestRate);
            request.setAttribute("loanTypeObject", loanTypeObject);
            pageToForward="/create-grant-condition.jsp";
        } catch ( FieldRequiredException e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در ثبت نوع تسهیلات جدید! " + "\n" + e.getMessage());
            request.setAttribute("url","create-loan-type.jsp");
            pageToForward="/info-page.jsp";
        }finally {
            try {
                getServletConfig().getServletContext().getRequestDispatcher(pageToForward).forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
