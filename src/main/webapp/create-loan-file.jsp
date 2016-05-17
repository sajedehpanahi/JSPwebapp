<%@ page import="domainLogic.domainObjects.RealCustomerObject" %>
<%@ page import="domainLogic.domainObjects.LoanTypeObject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <link href="css/Style.css" rel="stylesheet">
    <title>پرونده تسهیلاتی</title>
</head>
<body>
<div class="title">
    <h1>پرونده تسهیلاتی</h1>
</div>

<div id="wrapper">
    <div class="content">
        <div class="box">
            <div class="box-top"></div>
            <div class="box-in">
                <br>
                <form action="LoanFileController">
                    <input type="text" name="action" value="retrieve-customer-and-loan-type" hidden>
                    <table>
                        <tr>
                            <td>شماره مشتری</td>
                            <td><input type="text" name="customerId" value="<%=request.getAttribute("customerId")%>"></td>
                            <td><input class="button" type="submit" value="بازیابی"></td>
                            <td><a href="real-customer-managment.jsp" class="form">بازگشت به صفحه قبل</a></td>
                        </tr>
                    </table>
                </form>
                <br><hr><br>
                <% int customerExists = (int)request.getAttribute("customerExists");%>
                <c:choose>
                    <c:when test="<%=(customerExists==1)%>">
                        <form action="LoanFileController">
                            <input type="text" hidden name="action" value="create">
                            <% RealCustomerObject realCustomerObject = (RealCustomerObject)request.getAttribute("realCustomerObject"); %>
                            <input type="text" hidden name="confirmedCustomerId" value="<%=realCustomerObject.getCustomerId()%>">

                            <table>
                                <tr>
                                    <td> نام و نام خانوادگی مشتری : </td>
                                    <td><%=realCustomerObject.getFullName()%></td>
                                </tr>
                                <tr>
                                    <td> نوع تسهیلات*</td>
                                    <td>
                                        <%boolean anyLoanTypeExists = (boolean)request.getAttribute("anyLoanTypeExists"); %>
                                        <c:choose>
                                        <c:when test="<%=anyLoanTypeExists%>">
                                            <% ArrayList<LoanTypeObject> loanTypeObjects = (ArrayList<LoanTypeObject>)request.getAttribute("loanTypeObjects"); %>
                                            <select class="my-dropdown" name="loanType">
                                                <% for( LoanTypeObject loanTypeObject : loanTypeObjects){ %>
                                                    <option value="<%= loanTypeObject.getLoanId()%>" ><%= loanTypeObject.getLoanName()%></option>
                                                <%}%>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <p>داده ای وجود ندارد</p>
                                        </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <td> مدت قرارداد*</td>
                                    <td><input type="text" name="duration"></td>
                                </tr>
                                <tr>
                                    <td>مبلغ قرارداد*</td>
                                    <td><input type="text" name="amount"></td>
                                </tr>
                            </table>
                            <input  class="button" type="submit" value="ثبت">
                        </form>
                    </c:when >
                    <c:when test="<%=(customerExists==0)%>">
                        <h2>خطا</h2>
                        <p>شماره مشتری یافت نشد</p>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
                <br>
            </div>
        </div>
        <div class="box-bottom"></div>
    </div>
</div>
<div align="center">
    Sajedehpanahi@gmail.com
</div>
</body>
</html>
