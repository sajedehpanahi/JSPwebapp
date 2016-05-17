<%@ page import="domainLogic.domainObjects.LoanTypeObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="css/Style.css" rel="stylesheet">
    <script type="text/javascript" src="table-script.js"></script>
    <title>شرایط اعطا</title>
</head>
<body>
<div class="title">
    <h1>شرایط اعطا</h1>
</div>
<div id="wrapper">
    <div class="content">
        <div class="box">
            <div class="box-top"></div>
            <div class="box-in">
                <br>
                <table>
                    <%
                        LoanTypeObject loanTypeObject = (LoanTypeObject) request.getAttribute("loanTypeObject");
                    %>
                    <tr>
                        <td>نام تسهیلات</td>
                        <td><%=loanTypeObject.getLoanName()%></td>
                    </tr>
                    <tr>
                        <td>نرخ سود تسهیلات</td>
                        <td><%=loanTypeObject.getInterestRate()%></td>
                    </tr>
                </table>
                <a href="create-loan-type.jsp" class=form>تصحیح</a>
                <br>
                <hr>
                <br>
                <h3>لطفا مشخصات شرط اعطای مورد نظر را وارد کنید</h3>
                <br>
                    <table>
                        <tr>
                            <td>نام*</td>
                            <td><input type="text" id="conditionName"></td>
                        </tr>
                        <tr>
                            <td>حداقل مدت قرارداد*</td>
                            <td><input type="text" id="minDuration"></td>
                        </tr>
                        <tr>
                            <td>حداکثر مدت قرارداد*</td>
                            <td><input type="text" id="maxDuration"></td>
                        </tr>
                        <tr>
                            <td>حداقل مبلغ قرارداد*</td>
                            <td><input type="text" id="minAmount"></td>
                        </tr>
                        <tr>
                            <td>حداکثر مبلغ قرارداد*</td>
                            <td><input type="text" id="maxAmount"></td>
                        </tr>
                    </table>
                    <input class="button" type="submit" value="اضافه" onclick="addRow()">
                    <br>
                    <hr>
                    <br>
                <form action="GrantConditionController" method="get">
                    <input type="hidden" name="loanName" value="<%=request.getParameter("loanName")%>">
                    <input type="hidden" name="interestRate" value="<%=request.getParameter("interestRate")%>">
                    <input type="hidden" name="loanTypeObject" value="${loanTypeObject}">
                    <table class="result-table" id="grantConditionsTable"></table>
                    <br>
                </form>
            </div>
            <div class="box-bottom"></div>
            <div class="cleaner">&nbsp;</div>
        </div>
    </div>
</div>
<div align="center">
    Sajedehpanahi@gmail.com
</div>
</body>
</html>
