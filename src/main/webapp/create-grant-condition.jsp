<%@ page import="dataAccess.beans.GrantCondition" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    List<GrantCondition> data = new ArrayList<GrantCondition>();

    data.add(new GrantCondition("شرط اول","1 ماه","75 ماه",new BigDecimal(10000),new BigDecimal(500000)));
    data.add(new GrantCondition("شرط دوم","5 ماه","57 ماه",new BigDecimal(5000),new BigDecimal(1000000)));
    data.add(new GrantCondition("شرط سوم","7 ماه","45 ماه",new BigDecimal(30000),new BigDecimal(350000)));
    data.add(new GrantCondition("شرط چهارم","7 ماه","44 ماه",new BigDecimal(900),new BigDecimal(15000)));
    data.add(new GrantCondition("شرط پنچم","2 ماه","20 ماه",new BigDecimal(150000),new BigDecimal(250000)));

    pageContext.setAttribute("grantConditions",data);
%>
<html>
<head>
    <meta charset="UTF-8">
    <link href="css/Style.css" rel="stylesheet">
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
                <form> <%--TODO retrive customer number in retrive customer number jsp--%>
                    <h4>لطفا مشخصات شرط اعطای مورد نظر را وارد کنید</h4>
                    <table>
                        <tr>
                            <td>نام</td>
                            <td><input type="text" name="conditionName"></td>
                        </tr>
                        <tr>
                            <td>حداقل مدت قرارداد</td>
                            <td><input type="text" name="minDuration"></td>
                        </tr>
                        <tr>
                            <td>حداکثر مدت قرارداد</td>
                            <td><input type="text" name="maxDuration"></td>
                        </tr>
                        <tr>
                            <td>حداقل مبلغ قرارداد</td>
                            <td><input type="text" name="minAmount"></td>
                        </tr>
                        <tr>
                            <td>حداکثر مبلغ قرارداد</td>
                            <td><input type="text" name="maxAmount"></td>
                        </tr>
                    </table>
                    <input class="button" type="submit" value="ثبت">
                </form>
                <c:if test="true">
                    <table class="result-table">
                        <tr>
                            <th> نام شرط</th>
                            <th> حداقل مدت قرارداد</th>
                            <th> حداکثر مدت قرارداد</th>
                            <th> حداقل مبلغ قرارداد</th>
                            <th> حداکثر مبلغ قرارداد</th>
                        </tr>
                        <c:forEach var="bean" items="${beans}">
                            <tr>
                                <td>${bean.firstName}</td>
                                <td>${bean.lastName}</td>
                                <td>${bean.number}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>

                <c:choose>
                <c:when test="true">
                </form>
                <table class="result-table">
                    <tr>
                        <th> نام</th>
                        <th> نام خانوادگی</th>
                        <th> شماره مشتری</th>
                    </tr>
                    <c:forEach var="bean" items="${beans}">
                        <tr>
                            <td>${bean.firstName}</td>
                            <td>${bean.lastName}</td>
                            <td>${bean.number}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            </c:when>
            <c:otherwise>
                <h2>خطا</h2>
                <p>شماره مشتری یافت نشد</p>
            </c:otherwise>
            </c:choose>
            <br>
        </div>
        <div class="box-bottom"></div>
        <div class="cleaner">&nbsp</div>
    </div>
</div>

<div align="center">
    Sajedehpanahi@gmail.com
</div>
</body>
</html>
