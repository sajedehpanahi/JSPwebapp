package domainLogic;

import dataAccess.CRUD;
import domainLogic.domainObjects.GrantConditionObject;
import domainLogic.domainObjects.LoanTypeObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class GrantConditionController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String loanName = request.getParameter("loanName");
            Float interestRate = Float.parseFloat(request.getParameter("interestRate"));

            int rowCount = Integer.parseInt(request.getParameter("rowCount"));
            ArrayList<GrantConditionObject> grantConditions = new ArrayList<GrantConditionObject>();

            for (int i = 1; i < rowCount - 1; i++) {
                GrantConditionObject grantConditionObject = new GrantConditionObject();
                grantConditionObject.setGrantName(request.getParameter("conditionName" + i));
                grantConditionObject.setMinDuration(Integer.parseInt((request.getParameter("minDuration" + i))));
                grantConditionObject.setMaxDuration(Integer.parseInt((request.getParameter("maxDuration" + i))));
                grantConditionObject.setMinAmount(new BigDecimal((request.getParameter("minAmount" + i))));
                grantConditionObject.setMaxAmount(new BigDecimal((request.getParameter("maxAmount" + i))));
                grantConditions.add(grantConditionObject);
            }
            LoanTypeObject loanType = new LoanTypeObject(loanName, interestRate);
            CRUD.saveLoanType(LoanTypeObject.toLoanTypeEntity(loanType), GrantConditionObject.toLoanTypeEntity(grantConditions));

            request.setAttribute("header", "عملیات موفق");
            request.setAttribute("text", "نوع تسهیلات جدید با موفقیت ثبت شد!");
            request.setAttribute("url", "create-loan-type.jsp");
        }catch (Exception e){
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", " خطا در ذخیره نوع تسهیلات. لطفا مجددا تلاش کنید!" + "\n" + e.getMessage());
            request.setAttribute("url", "create-loan-type.jsp");
        }
        getServletConfig().getServletContext().getRequestDispatcher("/info-page.jsp").forward(request, response);


    }
}
