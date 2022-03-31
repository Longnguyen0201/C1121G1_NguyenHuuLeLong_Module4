<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/31/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
</head>
<body>
<div style="text-align: center">
    <h3>TỜ KHAI Y TẾ</h3>
    <p><span style="color: red">Khuyến cáo : Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</span>
    </p>
</div>
<div class="container">
    <form:form modelAttribute="medicalDeclaration" method="post" action="/save">

        <div class="form-group">
            <label>Họ tên (ghi chữ in HOA) <span style="color: red">(*)</span></label>
            <form:input path="name" type="text" class="form-control" placeholder="NGUYỄN VĂN A"/>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Năm sinh <span style="color: red">(*)</span></label>
                <form:input path="yearBirthday" type="text" class="form-control"/>
            </div>
            <div class="form-group col-md-4">
                <label>Giới tính <span style="color: red">(*)</span></label>
                <form:select path="gender">
                    <form:options items="${gender}"/>
                </form:select>
            </div>
            <div class="form-group col-md-4">
                <label>Quốc tịch <span style="color: red">(*)</span></label>
                <form:input path="nationality" type="text" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label >Số hộ chiếu hoặc số CMND <span style="color: red">(*)</span></label>
            <form:input path="idCard" type="text" class="form-control" />
        </div>

        <div class="form-group">
            <div class="form-group">
                <label >Thông tin đi lại <span style="color: red">(*)</span></label><br>
                <form:select path="vehicle">
                    <form:options items="${vehicle}"/>
                </form:select>
            </div>
            <div class="form-row">
            <div class="form-group col-md-6">
                <label>Số hiệu phương tiện</label>
                <form:input path="idVehicle" type="text" class="form-control"/>
            </div>
            <div class="form-group col-md-6">
                <label>Số ghế</label>
                <form:input path="seats" type="text" class="form-control"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Ngày khởi hành <span style="color: red">(*)</span></label><br>
                <form:input path="startDate" type="date" class="form-control"/>
            </div>
            <div class="form-group col-md-6">
                <label>Ngày kết thúc <span style="color: red">(*)</span></label><br>
                <form:input path="endDate" type="date" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào ? <span
                    style="color: red">(*)</span></label>
            <form:input path="nearestProvince" type="text" class="form-control"/>
        </div>

        <div>
            <label>Địa chỉ liên lạc</label><br>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>Tỉnh / thành <span style="color: red">(*)</span></label>
                    <form:input path="province" type="text" class="form-control" />
                </div>
                <div class="form-group col-md-4">
                    <label>Quận / huyện <span style="color: red">(*)</span></label>
                    <form:input path="district" type="text" class="form-control"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Phường / xẫ <span style="color: red">(*)</span></label>
                    <form:input path="ward" type="text" class="form-control"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label>Địa chỉ nơi ở <span style="color: red">(*)</span></label>
            <form:input path="address" type="text" class="form-control" />
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Điện thoại <span style="color: red">(*)</span></label>
                <form:input path="phone" type="text" class="form-control"/>
            </div>
            <div class="form-group col-md-6">
                <label>Email</label>
                <form:input path="email" type="text" class="form-control"/>
            </div>
        </div>

        <button>Gửi tờ khai</button>
    </form:form>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
</html>
