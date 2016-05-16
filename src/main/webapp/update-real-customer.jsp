<%@ page import="domainLogic.domainObjects.RealCustomerObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang=fa>
<head>
    <meta charset=UTF-8>
    <link href=css/Style.css rel=stylesheet>
    <title>اصلاح اطلاعات مشتری</title>
</head>
<body>
<div class=title>
    <h1>اصلاح اطلاعات مشتری</h1>
</div>
<div id=wrapper>
    <div class=content>
        <div class=box>
            <div class=box-top></div>
            <div class=box-in>
                <br>
                <form action="RealCustomerController" method="get">
                    <input type="hidden" name="action" value="confirm-update">
                    <p>اطلاعات مشتری حقیقی :</p>
                    <br>
                    <%RealCustomerObject realCustomerObject = (RealCustomerObject) request.getAttribute("realCustomerObject"); %>
                    <table>
                        <tr>
                            <td>شماره مشتری</td>
                            <td><input type='text' name='customerId' value="<%=realCustomerObject.getCustomerId()%>"
                                       readonly></td>
                        </tr>
                        <tr>
                            <td> نام</td>
                            <td><input type='text' name='firstName' value="<%=realCustomerObject.getFirstName()%>"></td>
                        </tr>
                        <td> نام خانوادگی</td>
                        <td><input type='text' name='lastName' value="<%=realCustomerObject.getLastName()%>"></td>
                        </tr>
                        <td> نام پدر</td>
                        <td><input type='text' name='fatherName' value="<%=realCustomerObject.getFatherName()%>"></td>
                        </tr>
                        <tr>
                            <td> تاریخ تولد</td>
                            <td><input type='text' name='dateOfBirth' value="<%=realCustomerObject.getDateOfBirth()%>">
                            </td>
                        </tr>
                        <tr>
                            <td>کد ملی</td>
                            <td><input type='text' name='nationalCode'
                                       value="<%=realCustomerObject.getNationalCode()%>"></td>
                        </tr>
                    </table>
                    <input type='submit' class='button' value='ذخیره تغییرات'>
                </form>
            </div>
            <div class=box-bottom></div>
        </div>
        <div class=cleaner>&nbsp</div>
    </div>
</div>
<div align=center>Sajedehpanahi@gmail.com</div>
</body>
</html>
