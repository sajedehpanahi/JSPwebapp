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
                <form action="LoanFileController"> <%--TODO retrive customer number in retrive customer number jsp--%>
                    <input type="text" name="action" value="retrieve-customer" hidden>
                    <table>
                        <tr>
                            <td>شماره مشتری</td>
                            <td><input type="text" name="customerNumber"></td>
                            <td><input class="button" type="submit" value="بازیابی"></td>
                            <td><a href="real-customer-managment.jsp" class="form">بازگشت به صفحه قبل</a></td>
                        </tr>
                    </table>
                </form>
                <br><hr><br>
                <c:choose>
                    <c:when test="true">
                        <form> <%--TODO create new loan file--%>
                            <table>
                                <tr>
                                    <td> نام و نام خانوادگی مشتری*</td>
                                    <td><input type="text" readonly value="ساجده پناهی" name="duration"></td>
                                        <%--TODO get customer number from lower layer--%>
                                </tr>
                                <tr>
                                    <td> نوع تسهیلات*</td>
                                    <td>
                                        <select class="my-dropdown"
                                                name="loanType"> <%--TODO get loan types from lower layer--%>
                                            <option>تسهیلات مسکن</option>
                                            <option>تسهیلات خودرو</option>
                                            <option>تسهیلات کارافرینی</option>
                                            <option>تسهیلات جهیزیه</option>
                                        </select>
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
                                <%--TODO validate amount and duration and after that show a success or fail message--%>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <h2>خطا</h2>
                        <p>شماره مشتری یافت نشد</p>
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
