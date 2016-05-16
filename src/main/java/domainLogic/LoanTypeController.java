package domainLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoanTypeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setAttribute("loanName",request.getParameter("loanName"));
            request.setAttribute("interestRate",Float.parseFloat(request.getParameter("interestRate")));
            getServletConfig().getServletContext().getRequestDispatcher("/create-grant-condition.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
