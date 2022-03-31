<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/31/2022
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
<div class="container-fluid">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row ">
                    <div class="col-sm-10">
                        <h2>Danh sách <b>Tờ khai y tế</b></h2>
                    </div>
                    <div class="col-sm-2">
                        <a href="/create" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>Thêm mới</span></a>
                    </div>
                </div>
            </div>
        </div>
        <h3><span class="message">${requestScope["message"]}</span></h3>
        <table class="table table-striped table-hover" id="example">
            <thead>
            <tr>
                <th>ID</th>
                <th>Họ Tên</th>
                <th>Năm Sinh</th>
                <th>Giới tính</th>
                <th>Quố tịch</th>
                <th>CMND</th>
                <th>Phương Tiện</th>
                <th>Số hiệu</th>
                <th>Số ghế</th>
                <th>Ngày khởi hành</th>
                <th>Ngày kết thúc</th>
                <th>Tỉnh đi gần nhất</th>
                <th>Tỉnh/thành</th>
                <th>Quận/Huyện</th>
                <th>Phường/Xã</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Cập nhập</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="medicalDeclaration" items="${medicalDeclarationList}" varStatus="l">
                <tr>
                    <td>${medicalDeclaration.id}</td>
                    <td>${medicalDeclaration.name}</td>
                    <td>${medicalDeclaration.yearBirthday}</td>
                    <td>${medicalDeclaration.gender}</td>
                    <td>${medicalDeclaration.nationality}</td>
                    <td>${medicalDeclaration.idCard}</td>
                    <td>${medicalDeclaration.vehicle}</td>
                    <td>${medicalDeclaration.idVehicle}</td>
                    <td>${medicalDeclaration.seats}</td>
                    <td>${medicalDeclaration.startDate}</td>
                    <td>${medicalDeclaration.endDate}</td>
                    <td>${medicalDeclaration.nearestProvince}</td>
                    <td>${medicalDeclaration.province}</td>
                    <td>${medicalDeclaration.district}</td>
                    <td>${medicalDeclaration.ward}</td>
                    <td>${medicalDeclaration.address}</td>
                    <td>${medicalDeclaration.phone}</td>
                    <td>${medicalDeclaration.email}</td>

                    <td>
                        <a href="/update/${medicalDeclaration.id}">
                            <i class="material-icons" style="color: dodgerblue">&#xE254;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>

<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/products?action=delete">
                <input type="hidden" name="id_modal_delete" id="isDelete">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script>

    function sendProductId(id) {
        document.getElementById('isDelete').value = id;
    }

    // Disable form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Get the forms we want to add validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>
<%--code phân trang--%>
<script>
    $.extend(true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": false
    });
    $(document).ready(function () {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    });
</script>


</html>
