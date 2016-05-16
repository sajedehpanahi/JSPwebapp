<%@ page import="domainLogic.domainObjects.RealCustomerObject" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html lang="fa">
<head>
    <%-- <meta http-equiv="content-type" content="text/html; charset=utf-8" charset="utf-8"/>--%>
    <link href="css/Style.css" rel="stylesheet">
    <title>تایید حذف مشتری</title>
</head>
<body>
<div class="title">
    <h1>تایید حذف مشتری</h1>
</div>

<div id="wrapper">
    <hr class="noscreen">
    <div class="content">
        <div class="box">
            <div class="box-top"></div>
            <div class="box-in">
                <p>آیا از حذف مشتری با مشخصات زیر اطمینان دارید؟</p>
                <form action="RealCustomerController" method="get">
                    <input type="hidden" name="action" value="delete">
                    <%RealCustomerObject realCustomerObject = (RealCustomerObject)request.getAttribute("realCustomerObject"); %>
                    <input type="hidden" name="id" value="<%=realCustomerObject.getCustomerId()%>">

                    <table>
                        <tr>
                            <td> شماره مشتری </td>
                            <td><%=realCustomerObject.getCustomerId()%></td>
                        </tr>
                        <tr>
                            <td> نام </td>
                            <td><%=realCustomerObject.getFirstName()%></td>
                        </tr>
                        <tr>
                            <td> نام خانوادگی</td>
                            <td><%=realCustomerObject.getLastName()%></td>
                        </tr>
                        <tr>
                            <td>نام پدر</td>
                            <td><%=realCustomerObject.getFatherName()%></td>
                        </tr>
                        <tr>
                            <td>تاریخ تولد</td>
                            <td><%=realCustomerObject.getDateOfBirth()%></td>
                        </tr>
                        <tr>
                            <td>کد ملی</td>
                            <td><%=realCustomerObject.getNationalCode()%></td>
                        </tr>
                    </table>
                    <input type="submit" class="button" value="بله">
                    <a href="retrieve-real-customer.jsp" class="form">بازگشت </a>
                </form>
                <br>
                <br>
            </div>
            <div class="box-bottom"></div>
        </div>
        <div class="cleaner">&nbsp</div>
    </div>
</div>

<div align="center">
    Sajedehpanahi@gmail.com
</div>

</body>
</html>
