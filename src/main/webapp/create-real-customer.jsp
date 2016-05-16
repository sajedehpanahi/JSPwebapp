<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html lang="fa">
<head>
   <%-- <meta http-equiv="content-type" content="text/html; charset=utf-8" charset="utf-8"/>--%>
    <link href="css/Style.css" rel="stylesheet">
    <title>ثبت اطلاعات مشتری</title>
</head>
<body>
<div class="title">
    <h1>ثبت اطلاعات مشتری</h1>
</div>

<div id="wrapper">
    <hr class="noscreen">
    <div class="content">
        <div class="box">
            <div class="box-top"></div>
            <div class="box-in">
                <br>
                <p>لطفا اطلاعات مشتری را وارد نمایید.</p>
                <br>
                <form action="RealCustomerController" method="get">
                    <input type="hidden" name="action" value="create">
                    <table>
                        <tr>
                            <td> نام </td>
                            <td><input type="text" name="firstName"></td>
                        </tr>
                        <tr>
                            <td> نام خانوادگی</td>
                            <td><input type="text" name="lastName"></td>
                        </tr>
                        <tr>
                            <td>نام پدر</td>
                            <td><input type="text" name="fatherName"></td>
                        </tr>
                        <tr>
                            <td>تاریخ تولد</td>
                            <td><input type="text" name="dateOfBirth"></td>
                        </tr>
                        <tr>
                            <td>کد ملی</td>
                            <td><input type="text" name="nationalCode"></td>
                        </tr>
                    </table>
                    <input type="submit" class="button" value="ثبت اطلاعات">
                    <a href="real-customer-managment.jsp" class="form">بازگشت به صفحه قبل</a>
                </form>
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
