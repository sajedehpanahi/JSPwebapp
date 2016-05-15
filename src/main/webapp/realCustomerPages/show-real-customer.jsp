<%@ page import="domainLogic.domainObjects.RealCustomerObject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset=UTF-8>
    <link href=../css/Style.css rel=stylesheet>
    <title>جستجوی مشتری</title>
</head>
<body>
<div class=title>
    <h1>جستجوی مشتری</h1>
</div>
<div id=wrapper>
    <div class=content>
        <div class=box>
            <div class=box-top></div>
            <div class=box-in>
                <br>
                <br>
                <%
                    int count = 0;
                    ArrayList<RealCustomerObject> realCustomerObjects = (ArrayList<RealCustomerObject>) request.getAttribute("realCustomers");
                    if (realCustomerObjects.size() > 0) {
                %>
                <p>نتایج جستجو به شرح زیر است:</p>
                <table>
                    <thead>
                    <tr>
                        <th>
                            ردیف
                        </th>
                        <th>
                            نام
                        </th>
                        <th>
                            نام خانوادگی
                        </th>
                        <th>
                            نام پدر
                        </th>
                        <th>
                            کد ملی
                        </th>
                        <th>
                            شماره مشتری
                        </th>
                        <th>
                            انجام عملیات
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (RealCustomerObject realCustomerObject : realCustomerObjects) {
                            count++;
                    %>
                    <tr>
                        <td>
                            <%=count%>
                        </td>
                        <td>
                            <%=realCustomerObject.getFirstName()%>
                        </td>
                        <td>
                            <%=realCustomerObject.getLastName()%>
                        </td>
                        <td>
                            <%=realCustomerObject.getFatherName()%>
                        </td>
                        <td>
                            <%=realCustomerObject.getNationalCode()%>
                        </td>
                        <td>
                            <%=realCustomerObject.getCustomerId()%>
                        </td>
                        <td><a href="RealCustomerController?action=confirm-delete&id=<%=realCustomerObject.getCustomerId() %>"
                               class=form>حذف</a>
                            <a href=RealCustomerController?action=update&id=<%=realCustomerObject.getCustomerId() %> class=form>اصلاح</a>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
                <%} else {%>
                <h3>مشتری با مشخصات وارد شده وجود ندارد!</h3>
                <%}%>
                <a href=retrieve-real-customer.jsp class=form>بازگشت به صفحه قبل</a>
            </div>
            <div class=box-bottom></div>
        </div>
        <div class=cleaner>&nbsp</div>
    </div>
</div>
<div align=center>Sajedehpanahi@gmail.com</div>
</body>
</html>
