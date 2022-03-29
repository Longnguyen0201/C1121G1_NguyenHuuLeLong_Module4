<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Currency Conversion</title>

</head>
<body>
<form action="/conversion" method="post">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 m-lg-auto">
                <div class="mb-3">
                    <label for="number1" class="form-label">USD</label>
                    <input type="text" class="form-control" id="number1" name="usd">
                </div>
                <div class="mb-3">
                    <label for="number2" class="form-label">Tỉ giá</label>
                    <input type="text" class="form-control" id="number2" name="rate" value="23000" >
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
            <h3> ${message} ${vnd}</h3>
        </div>
    </div>
</form>

</body>
</html>